# AI Email Writer

A comprehensive AI-powered email assistant that integrates with Gmail to automatically generate professional email replies using Google's Gemini AI.

## Resume Summary (3 Key Points)

• **Full-Stack AI Application**: Developed a complete email automation solution using React frontend, Spring Boot backend, and Chrome extension, integrating Google Gemini AI API to generate contextual email replies with customizable tones (professional, casual, friendly)

• **Chrome Extension Development**: Built a Gmail-integrated browser extension that dynamically injects AI-powered reply buttons into Gmail's compose interface, enabling seamless one-click email generation with real-time DOM manipulation and API communication

• **RESTful API & Cross-Platform Integration**: Architected a Spring Boot REST API with WebClient for external AI service integration, implemented CORS for cross-origin requests, and created a responsive React web interface with Material-UI components for standalone email composition

## Project Components

### 1. React Frontend (`Email_Writer_React`)
- Modern React application with Material-UI components
- Email composition interface with tone selection
- Real-time API integration with loading states and error handling
- Copy-to-clipboard functionality for generated replies

### 2. Spring Boot Backend (`email_Writer_Backend`)
- RESTful API built with Spring Boot and WebFlux
- Google Gemini AI integration for intelligent email generation
- Cross-origin resource sharing (CORS) enabled
- Configurable tone-based prompt engineering

### 3. Chrome Extension (`Email_Writer_Ext`)
- Gmail integration with content script injection
- Dynamic button placement in Gmail's compose toolbar
- Real-time email content extraction and AI reply generation
- Seamless user experience within Gmail interface

## Technologies Used

- **Frontend**: React, Material-UI, Vite, Axios
- **Backend**: Spring Boot, WebFlux, Lombok, Maven
- **AI Integration**: Google Gemini AI API
- **Browser Extension**: Chrome Extension API, DOM Manipulation
- **Build Tools**: Maven, Vite, ESLint

## Features

- ✨ AI-powered email reply generation
- 🎯 Multiple tone options (professional, casual, friendly)
- 🔗 Gmail integration via Chrome extension
- 📱 Standalone web application
- 🚀 Real-time response generation
- 📋 One-click copy functionality
- 🌐 Cross-platform accessibility