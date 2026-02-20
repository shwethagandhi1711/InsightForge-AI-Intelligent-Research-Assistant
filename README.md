# InsightForge-AI-Intelligent-Research-Assistant

# 🤖 AI Research Assistant

## 📌 Project Overview

**AI Research Assistant** is an intelligent web application that helps users perform research-related tasks such as **summarization, explanation, and content analysis** using advanced AI. It integrates with **Google Gemini API** to generate accurate, fast, and context-aware responses.

This tool is useful for **students, researchers, developers, and professionals** to quickly understand large content without reading everything manually.

---

## 🎯 Project Objectives

The main objectives of this project are:

* To automate research-related tasks using AI
* To summarize long content into short, meaningful information
* To explain complex topics in simple terms
* To save time and improve productivity
* To provide an easy-to-use interface for AI-powered research

---

## 🛠️ Technology Stack

### Frontend

* React.js
* HTML5
* CSS3
* JavaScript
* Bootstrap

### Backend

* Java
* Spring Boot
* Spring Web
* Spring WebFlux (WebClient)

### AI Integration

* Google Gemini API

### Tools

* VS Code
* IntelliJ / Eclipse
* Postman
* Git & GitHub

---

## ⚙️ Core Modules Description

### 1. User Interface Module

* Accepts research content from user
* Displays AI response
* Provides simple and clean UI

### 2. AI Processing Module

* Sends user content to Gemini API
* Receives AI-generated response
* Processes and formats output

### 3. Backend Module

* Handles REST API requests
* Connects frontend and Gemini API
* Manages business logic

### 4. Integration Module

* Uses WebClient to call Gemini API
* Handles authentication
* Processes API responses

---

## 🔄 Workflow and Architecture

### Workflow Steps:

1. User enters content
2. Frontend sends request to Spring Boot backend
3. Backend calls Gemini API
4. Gemini processes content
5. Response returned to backend
6. Backend sends response to frontend
7. Frontend displays result

### Architecture Diagram (Logical)

```
User
 ↓
Frontend (React)
 ↓
Backend (Spring Boot)
 ↓
Gemini API
 ↓
Backend
 ↓
Frontend
 ↓
User
```

---

## 🗄️ Database Design

❌ This project currently does not use a database.

Future version may include:

| Table            | Purpose                 |
| ---------------- | ----------------------- |
| Users            | Store user details      |
| Research_History | Store previous research |

---

## 💻 Installation and Setup

### Step 1: Clone Repository

```bash
git clone https://github.com/yourusername/ai-research-assistant.git
```

---

### Step 2: Backend Setup

Open project in IntelliJ / Eclipse

Run:

```
ResearchAssistantApplication.java
```

Runs on:

```
http://localhost:8080
```

---

### Step 3: Frontend Setup

```bash
cd frontend
npm install
npm start
```

Runs on:

```
http://localhost:3000
```

---

## 🔑 How to Get Gemini API Key

Follow these steps:

### Step 1: Go to Google AI Studio

Visit:

https://aistudio.google.com/

Sign in using your Google account.

---

### Step 2: Create API Key

Click:

**Get API Key**

Then click:

**Create API Key**

---

### Step 3: Copy API Key

Example:

```
AIzaSyXXXXXXXXXXXXXXX
```

---

### Step 4: Add API Key in application.properties

```
gemini.api.key=YOUR_API_KEY
```

---

## 🚀 How to Use

Step 1:

Open application

Step 2:

Enter research content like:

```
Artificial Intelligence is transforming the world...
```

Step 3:

Click Submit

Step 4:

View result

Example output:

```
AI is changing industries by automating tasks and improving efficiency.
```

---

## 🔗 REST API Endpoints

### 1. Process Research Content

**POST**

```
/api/research/process
```

Request Body:

```json
{
  "content": "Artificial Intelligence is transforming industries",
  "operation": "summarize"
}
```

Response:

```json
{
  "response": "AI is transforming industries by automating tasks."
}
```

---

## ✅ Advantages

* Saves time
* Fast results
* Easy to use
* Accurate responses
* Improves productivity
* Reduces manual research effort

---

## 🔮 Future Enhancements

Future improvements:

* Add user login system
* Save research history
* Add PDF upload
* Add document download
* Add voice input
* Add multi-language support
* Add chatbot feature

---

## 🏁 Conclusion

AI Research Assistant is a powerful tool that uses **Google Gemini AI** to help users perform research tasks easily and efficiently.

It reduces manual effort, improves productivity, and makes research faster and smarter.

This project demonstrates:

* Spring Boot integration with Gemini
* REST API development
* AI integration
* Full stack development

---

