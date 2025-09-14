package com.email.email_Writer_Backend.App;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class EmailGeneratorService {
	
	private final WebClient webClient;
	
	@Value("${gemini.api.url}")
	private String geminiApiUrl;
	
	@Value("${gemini.api.key}")
	private String geminiApiKey;
	
	public EmailGeneratorService(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.build();
	}
	
	public String generateEmailReply(EmailRequest emailRequest) {
		// Build the prompt
		String prompt = buildPrompt(emailRequest);
		
		// Craft a request
		Map<String, Object> requestBody = Map.of(
				"contents", new Object[] {
						Map.of("parts", new Object[]{
								Map.of("text", prompt)
						})
				}
		);
		
		// Build endpoint properly: add ?key= or &key= depending on existing query params
		String endpoint;
		if (geminiApiUrl.contains("?")) {
			endpoint = geminiApiUrl + "&key=" + geminiApiKey;
		} else {
			endpoint = geminiApiUrl + "?key=" + geminiApiKey;
		}
		
		// Do request and get response
		String response = webClient.post()
				.uri(endpoint)
				.header("Content-Type","application/json")
				.bodyValue(requestBody)
				.retrieve()
				.bodyToMono(String.class)
				.block();
		
		// Extract Response and Return
		return extractResponseContent(response);
	}
	
	private String extractResponseContent(String response) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode rootNode = mapper.readTree(response);
			return rootNode.path("candidates")
					.get(0)
					.path("content")
					.path("parts")
					.get(0)
					.path("text")
					.asText();
		} catch (Exception e) {
			return "Error processing request: " + e.getMessage();
		}
	}
	
	private String buildPrompt(EmailRequest emailRequest) {
		String tone = (emailRequest.getTone() == null || emailRequest.getTone().isEmpty()) ? "professional" : emailRequest.getTone();
		StringBuilder prompt = new StringBuilder();
		prompt.append("You are an assistant that writes professional email replies. ");
		prompt.append("Produce ONLY the email body — do NOT include a subject line, headers, or labeled sections (for example: 'Summary', 'Action Items'). ");
		prompt.append("Write in a ").append(tone).append(" tone. ");
		prompt.append("Be concise, clear, and preserve the original sender's intent and key facts. Avoid adding new information or external commentary. ");
		prompt.append("Include an appropriate short greeting and a brief closing line (e.g., 'Best regards') consistent with the tone. ");
		prompt.append("Do not include any section headings or metadata.\n\nOriginal email:\n").append(emailRequest.getEmailContent());
		return prompt.toString();
	}
}