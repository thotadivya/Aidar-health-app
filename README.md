# Aidar Health Application

This repository contains a full-stack application for managing patient health data with threshold settings and real-time alerts. The project is built with a Spring Boot backend and Angular frontend.

## Table of Contents

1. [Project Overview](#project-overview)
2. [Features](#features)
3. [Technologies Used](#technologies-used)
4. [Setup Instructions](#setup-instructions)
   - [Backend Setup](#backend-setup)
   - [Frontend Setup](#frontend-setup)
5. [Usage](#usage)
6. [Project Structure](#project-structure)

## Project Overview

The Aidar Health application allows physicians to set threshold ranges for various health metrics (e.g., heart rate, blood pressure, temperature) for patients. The system triggers alerts if a patient’s health data exceeds or falls below the set thresholds. Alerts are displayed in real-time on the physician's dashboard, and notifications are sent dynamically.

## Features

- **Threshold Setting**: Physicians can set thresholds for patients’ health metrics.
- **Real-Time Alerts**: Notifications are generated when patient data crosses the set threshold.
- **Data Monitoring**: Simulated real-time patient data is processed and compared against thresholds.
- **Notification System**: Alerts are displayed and updated dynamically in real-time.

## Technologies Used

- **Frontend**: Angular
- **Backend**: Spring Boot (Java)
- **Database**: MySQL
- **Communication**: REST API
- **Version Control**: Git, GitHub

## Setup Instructions

### Backend Setup

1. **Prerequisites**: 
   - Java 17 or above
   - MySQL
   - Maven

2. **Database Setup**:
   - Create a MySQL database:
     ```sql
     CREATE DATABASE aidar_health_db;
     ```

3. **Configuration**:
   - Update `application.properties` in `backend/src/main/resources/` with your database credentials:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/aidar_health_db
     spring.datasource.username=your-username
     spring.datasource.password=your-password
     ```

4. **Run the Backend**:
   Navigate to the backend directory and run the following Maven commands:
   ```bash
   cd backend
   mvn clean install
   mvn spring-boot:run
   Backend will be running at http://localhost:8080
  ```
### Frontend Setup

1. **Prerequisites**:
   - Node.js (v14 or above) and npm (or yarn)

2. **Install Dependencies**:
   - Navigate to the `frontend/` directory:
     ```bash
     cd frontend
     ```
   - Install the required packages:
     ```bash
     npm install
     ```

3. **Configuration** (if necessary):
   - If your backend API is running on a different port or URL, update the API URL in your service files (e.g., `alert.service.ts`, `thresholds.service.ts`) in the `frontend/src/app/services/` folder:
     ```typescript
     private apiUrl = 'http://localhost:8080/api';  // Ensure this matches your backend URL
     ```

4. **Run the Frontend**:
   - Start the Angular development server:
     ```bash
     ng serve
     ```
   - The frontend will be running at `http://localhost:4200`.
