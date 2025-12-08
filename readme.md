# Appointment Scheduling System

A full-stack Appointment Scheduling application built with **Java Spring Boot**.  
This system allows users to view available slots on an interactive calendar, book appointments, and receive email confirmations. It features a modern, responsive frontend and a robust backend API.

## Table of Contents
* [Features](#features)
* [Tech Stack](#tech-stack)
* [Getting Started](#getting-started)
    * [Prerequisites](#prerequisites)
    * [Configuration (Optional)](#configuration-optional)
* [How to Run](#how-to-run)
    * [Accessing the Database](#accessing-the-database)
* [Project Structure](#project-structure)

---

## Features

* **Interactive Dashboard:** View all appointments on a drag-and-drop enabled calendar (FullCalendar.js).
* **Booking System:** Easy-to-use form for customers to schedule appointments.
* **Real-time Availability:** The calendar updates instantly to show booked slots.
* **Email Notifications:** Automated email confirmations sent upon successful booking.
* **In-Memory Database:** Uses H2 for zero-configuration setup (data resets on restart).
* **Auto-Launch:** Automatically opens your default web browser when the server starts.

---

## Tech Stack

* **Backend:** Java 17, Spring Boot 3.2.3
* **Database:** H2 (In-Memory SQL Database)
* **Frontend:** Thymeleaf, Bootstrap 5, FullCalendar.js
* **Security:** Spring Security (Permissive configuration for easy testing)
* **Build Tool:** Maven

---

## Getting Started

Follow these instructions to get the project up and running on your local machine.

### Prerequisites

* Java Development Kit (JDK) 17 or higher
* IntelliJ IDEA (Recommended) or any Java IDE

### Configuration (Optional)

The project comes pre-configured with a "Fake Email" setup so it runs immediately without errors.  
To enable **real email sending**:

1. Open `src/main/resources/application.properties`
2. Update the email settings with your real SMTP credentials:

```properties
spring.mail.username=your-real-email@gmail.com
spring.mail.password=your-app-password
   ```

---

# How to Run

Open `src/main/java/com/scheduler/scheduler/SchedulerApplication.java`

Click the **Green Play Button** next to the `main` method

The application will start, and your browser should automatically open to:  
**http://localhost:8080**

## Accessing the Database

You can view the raw data tables using the H2 Console:

* **URL:** `http://localhost:8080/h2-console`
* **JDBC URL:** `jdbc:h2:mem:testdb`
* **Username:** `sa`
* **Password:** `password`

## Project Structure

```text
src/main/java/com/scheduler/scheduler
├── config/           # Security & Browser Launch logic
├── controller/       # Web & API Controllers (URLs)
├── model/            # Database Entities (User, Appointment)
├── repository/       # Database Interfaces
└── service/          # Business Logic (Email, Booking)

src/main/resources
├── static/           # CSS & JS files
├── templates/        # HTML Views (Thymeleaf)
└── application.properties
