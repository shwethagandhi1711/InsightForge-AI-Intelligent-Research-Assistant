# InsightForge-AI-Intelligent-Research-Assistant

📌 Project Overview

Research Assistant is an AI-powered Chrome Extension integrated with a Spring Boot backend and Gemini API that helps users summarize selected text from any webpage instantly.

The extension sends selected content to the backend, which processes it using Google's Gemini AI and returns a summarized response.

This project demonstrates real-world full stack development with AI integration.

🎯 Project Objectives

• Provide AI-based text summarization
• Help users understand content faster
• Improve research productivity
• Integrate Chrome Extension with Spring Boot
• Use Gemini API for intelligent responses
• Build a real-world AI powered application

🛠️ Technology Stack
Frontend (Chrome Extension)

HTML

CSS

JavaScript

Chrome Extension Manifest V3

Backend

Java 17

Spring Boot

Spring WebFlux (WebClient)

AI Integration

Gemini Pro API

Tools

IntelliJ / Eclipse

VS Code

Chrome Browser

GitHub

🧩 Core Modules Description
1️⃣ Chrome Extension Module

Files:

manifest.json
background.js
sidepanel.html
sidepanel.js
sidepanel.css

Function:

• Extract selected text
• Send request to backend
• Display summary
• Save notes

2️⃣ Controller Layer

File:

ResearchController.java

Function:

• Handles API requests
• Sends request to service layer
• Returns response

Endpoint:

POST /api/research/process
3️⃣ Service Layer

File:

ResearchService.java

Function:

• Creates prompt
• Calls Gemini API
• Processes response

4️⃣ DTO Layer

Files:

ResearchRequest.java
GeminiResponse.java

Function:

• Transfer request and response data

5️⃣ Configuration Layer

File:

WebClientConfig.java

Function:

• Configure WebClient
• Configure ObjectMapper

⚙️ Workflow and Architecture
Workflow

User selects text

User opens extension

Extension extracts text

Sends request to backend

Backend calls Gemini API

Gemini processes request

Backend receives response

Extension displays summary

Architecture
User
 ↓
Chrome Extension
 ↓
Spring Boot Backend
 ↓
Gemini API
 ↓
Backend
 ↓
Extension
 ↓
User
🗄️ Database Design

This project currently uses:

Chrome Local Storage

chrome.storage.local

Purpose:

• Save research notes

Future support:

• MySQL
• MongoDB

⚙️ Installation and Setup
Step 1: Clone Repository
git clone https://github.com/yourusername/research-assistant.git
Step 2: Backend Setup

Open in IntelliJ or Eclipse

Run:

ResearchAssistantApplication.java

Server starts at:

http://localhost:8080
Step 3: Load Chrome Extension

Open Chrome

Go to:

chrome://extensions/

Enable:

Developer Mode

Click:

Load Unpacked

Select extension folder

🔑 Gemini API Key Setup
Step 1: Open

https://aistudio.google.com/app/apikey

Step 2: Login with Google Account
Step 3: Click

Create API Key

Step 4: Copy API Key

Example:

AIzaSyXXXXXX
Step 5: Set Environment Variables

Windows:

set GEMINI_KEY=your_api_key
set GEMINI_URL=https://generativelanguage.googleapis.com/v1beta/models/gemini-pro:generateContent?key=

Mac/Linux:

export GEMINI_KEY=your_api_key
export GEMINI_URL=https://generativelanguage.googleapis.com/v1beta/models/gemini-pro:generateContent?key=
▶️ How to Use

Step 1:

Select text from webpage

Step 2:

Click extension icon

Step 3:

Click Summarize

Step 4:

View result

Step 5:

Save notes

🔗 REST API Endpoints
Process Content

URL:

POST /api/research/process
Request
{
  "content": "Artificial Intelligence is transforming industries",
  "operation": "summarize"
}
Response
Artificial Intelligence is rapidly transforming industries by...
✅ Advantages

• Saves time
• Easy to use
• AI powered
• Improves productivity
• Real-time processing
• Lightweight

🚀 Future Enhancements

• Explain feature
• Rewrite feature
• Multi language support
• Database integration
• User authentication
• Cloud deployment
• Chrome Web Store publishing

🎓 Conclusion

Research Assistant is an AI powered Chrome Extension integrated with Spring Boot and Gemini API.

It demonstrates:

• Full Stack Development
• AI Integration
• Chrome Extension Development
• REST API Development

This project is useful for students, researchers, and professionals.
