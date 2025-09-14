# AI Email Writer

A comprehensive AI-powered email assistant system that helps users generate professional email replies using Google Gemini AI.

## Components

### 🌐 Web Application (`Email_Writer_React`)
- Modern React 19.1.1 application with Material-UI
- Real-time AI email generation interface
- Tone customization (professional, casual, friendly)
- Built with Vite for optimal performance

### 🔌 Chrome Extension (`Email_Writer_Ext`)
- Seamless Gmail integration
- Manifest V3 compliant browser extension
- One-click AI reply generation directly in Gmail
- Dynamic button injection and content extraction

### ⚙️ Backend API (`email_Writer_Backend`)
- Spring Boot 3.4.9 with WebFlux reactive programming
- Google Gemini AI integration
- RESTful API with CORS support
- Intelligent prompt engineering for email context

## Technology Stack

- **Frontend:** React 19.1.1, Material-UI, Vite, Axios
- **Extension:** Chrome Extension APIs, DOM Manipulation, Manifest V3
- **Backend:** Spring Boot 3.4.9, WebFlux, Maven, Lombok
- **AI:** Google Gemini API
- **Build Tools:** Vite, Maven, ESLint

## Quick Start

### Frontend
```bash
cd Email_Writer_React
npm install
npm run dev
```

### Backend
```bash
cd email_Writer_Backend
mvn spring-boot:run
```

### Extension
1. Load `Email_Writer_Ext` folder as unpacked extension in Chrome
2. Navigate to Gmail and compose a new email
3. Click the "AI Reply" button to generate intelligent responses

## Features

- ✨ AI-powered email reply generation
- 🎯 Multiple tone options (professional, casual, friendly)
- 🔗 Seamless Gmail integration
- 📱 Responsive web interface
- ⚡ Real-time API communication
- 🛡️ Error handling and validation
- 📋 Copy-to-clipboard functionality

## Resume Highlights

For detailed resume points and technical accomplishments, see [`RESUME_POINTS.md`](./RESUME_POINTS.md).

---

**Note:** This project demonstrates full-stack development skills, AI integration expertise, and modern web development practices suitable for showcasing in professional portfolios and resumes.