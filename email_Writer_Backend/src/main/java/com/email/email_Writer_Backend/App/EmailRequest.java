package com.email.email_Writer_Backend.App;

import lombok.Data;

@Data
public class EmailRequest {
	private String emailContent;
	private String tone;
}