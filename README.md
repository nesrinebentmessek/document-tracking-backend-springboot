# Document Tracking System - Backend

This is the backend of a document tracking system developed during my internship at **Sharing Technologies** (June–July 2024). The project was built using **Spring Boot** and **MySQL**, and is designed to manage document progression through workflow steps with deadline monitoring and email notifications.

## 🔍 Project Overview

The system helps organizations track the lifecycle of internal documents as they move through predefined workflow steps. It reflects real-world document processes and ensures timely follow-ups through automated email alerts.

### Key Capabilities:
- Workflow step tracking
- Deadline monitoring
- Email notifications via SMTP
- RESTful APIs for frontend integration

The frontend was built with Angular, and although it is not included in this repository yet, it will be uploaded in a future update after clean-up.

## 🛠 Technologies Used

- **Spring Boot** – Backend logic and RESTful APIs
- **MySQL** – Relational database
- **Java** – Programming language
- **Maven** – Build and dependency management
- **JavaMailSender** – For sending notification emails

## 🚀 Features

- Manages document states and transitions between workflow steps
- Monitors submission deadlines and sends alert emails when deadlines are missed or approaching
- Handles backend operations for document tracking logic
- Exposes API endpoints for the Angular frontend 

## 📧 Email Notifications

The backend uses **SMTP with Spring Boot's JavaMailSender** to send email alerts in scenarios such as:
- Missed document deadlines
- Pending approvals
- Workflow status updates

You can configure your own email credentials in `application.properties`.


