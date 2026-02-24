# 📚 InsightForge-AI-Intelligent-Research-Assistant

An AI-powered Research Assistant Chrome Extension that helps users summarize selected webpage content and save research notes instantly.
It integrates a Chrome Extension frontend with a Spring Boot backend and Google Gemini API to generate intelligent summaries in real time.

---

# 🚀 Project Overview

The Research Assistant is designed to improve productivity during online research by allowing users to:

• Summarize selected text from any webpage

• Save personal research notes

• View AI-generated summaries instantly

• Use AI directly inside the Chrome browser side panel

The system connects the Chrome Extension with a Spring Boot backend, which communicates with the Gemini AI model to process the content.

---

# 🎯 Project Objectives

The main objectives of this project are:

• Provide AI-based text summarization

• Help users understand content faster

• Improve research productivity

• Integrate Chrome Extension with Spring Boot

• Use Gemini API for intelligent responses

• Build a real-world AI powered application

---

# 🛠 Technology Stack

### Frontend (Chrome Extension)

• HTML

• CSS

• JavaScript

• Chrome Extension API

• Chrome Storage API

### Backend

• Java

• Spring Boot

• Spring WebFlux (WebClient)

### AI Integration

• Google Gemini API

### Tools

• IntelliJ 

• VS Code

• Chrome Browser

• Postman

• Github

• Github Desktop
---

# 🧩 Core Modules

## 1. Chrome Extension Side Panel

### Files:

• sidepanel.html

• sidepanel.css

• sidepanel.js

• manifest.json

• background.js

### Function:

• Displays UI

• Takes selected text

• Sends request to backend

• Displays summary

• Saves notes locally

## 2. Controller Layer

### File:

• ResearchController.java

### Function:

• Receives request from extension

• Calls service layer

• Returns AI response

### Endpoint:

```bash
POST /api/research/process
```
## 3. Service Layer

### File:

• ResearchService.java

### Function:

• Build prompt

• Call Gemini API

• Parse response

• Return summary

## 4. DTO Module

### Files:

• ResearchRequest.java

• GeminiResponse.java

### Function:

• Transfer data

• Map JSON response

## 5. Configuration Module

### File:

• WebClientConfig.java

### Function:

• Configure WebClient

• Configure ObjectMapper

----

# 🔄 Workflow and Architecture

• Step 1

User selects text on webpage

• Step 2

User clicks Chrome Extension

• Step 3

Side Panel opens

• Step 4

User clicks Summarize

• Step 5

Chrome Extension sends request to Spring Boot API

```bash
POST /api/research/process
```

• Step 6

Spring Boot sends request to Gemini API

• Step 7

Gemini generates summary

• Step 8

Summary returned to Chrome Extension

• Step 9

Summary displayed in Side Panel

---
# 🏗 Architecture Diagram 

```id="arch001"
User
 ↓
Chrome Extension (Side Panel)
 ↓
Spring Boot Backend
 ↓
Gemini API
 ↓
Spring Boot Backend
 ↓
Chrome Extension
 ↓
User sees summary
```
---
# 🗄 Database Design

This project currently does not use database.

Notes are stored using:

Chrome Local Storage

Future versions can use:

MySQL

MongoDB

---
# ⚙ Installation and Setup

• Step 1: Clone Repository

```bash
git clone https://github.com/yourusername/research-assistant.git
```

• Step 2: Backend Setup

Open project in IntelliJ 

Run:

ResearchAssistantApplication.java

Backend runs at:

```bash
http://localhost:8080
```

• Step 3: Setup Chrome Extension

Open Chrome

Go to:

chrome://extensions/

Enable:

Developer Mode

Click:

Load Unpacked

Select extension folder

• Step 4: Add Gemini API Key

Open:

application.properties

Add:

```bash
gemini.api.url=https://generativelanguage.googleapis.com/v1beta/models/gemini-pro:generateContent?key=

gemini.api.key=YOUR_API_KEY
```
---

# 🔑 How to Get Gemini API Key

• Step 1:

Go to:

https://makersuite.google.com/app/apikey

• Step 2:

Login with Google account

• Step 3:

Click:

Create API Key

• Step 4:

Copy API key

• Step 5:

Paste in:

application.properties

### ▶ How to Use

• Step 1

Start Spring Boot backend

• Step 2

Open Chrome

• Step 3

Open any website

• Step 4

Select text

• Step 5

Click Extension icon

• Step 6

Click Summarize

• Step 7

View AI Summary

---

# 🌐 REST API Endpoints

### Process Content

```bash
POST /api/research/process
```

Request Body

```bash
{
  "content": "Artificial Intelligence is transforming industries",
  "operation": "summarize"
}
```
Response

```bash
Artificial Intelligence is transforming industries by automating tasks and improving efficiency.
```
---

# ✅ Advantages

• Saves research time

• Provides instant AI summaries

• Easy to use Chrome Extension

• Improves productivity

• Works on any website

• Lightweight

• Secure API integration

---

# 🔮 Future Enhancements

• Add Translate feature

• Add Question Answer feature

• Save notes to database

• Add authentication

• Deploy to cloud

---

# 🏁 Conclusion

The Research Assistant is an AI-powered Chrome Extension integrated with Spring Boot and Gemini API that helps users quickly summarize and understand webpage content. It demonstrates real-world implementation of Chrome Extension development, REST API integration, and AI usage. This project improves research productivity, saves time, and showcases strong full-stack development skills with modern AI integration.
