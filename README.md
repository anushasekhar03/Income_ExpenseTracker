# Income and Expense Tracker

## Overview

This is a **Spring Boot** application designed to help users track their income and expenses. The application provides functionalities for managing financial transactions, including adding, updating, deleting, and viewing transactions. It also exposes a set of **RESTful APIs** for interacting with the backend system. Additionally, the app includes a **Swagger UI** for easy API documentation and testing.

## Features

- **Track Income and Expenses**: Users can add, update, and delete income and expense records.
- **Balance Calculation**: The balance is calculated by subtracting the total expenses from the total income.
- **Min and Max Records**: Users can fetch the minimum and maximum income and expense records.
- **API Documentation via Swagger UI**: Interactive API documentation using Swagger UI for exploring and testing APIs.

## Technologies Used

- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA & Hibernate**
- **MySQL Database**
- **Swagger UI** (for interactive API documentation)

## Setup Instructions

### Prerequisites

- **Java 17** or higher
- **MySQL** database server
- **Maven** (for dependency management)
- **IDE**: IntelliJ IDEA or Visual Studio Code

### Clone the Repository

```bash
git clone https://github.com/anushasekhar03/Income-Expense-Tracker.git
cd Income-Expense-Tracker

# Income and Expense Tracker - Project Structure


This is a Spring Boot application that helps track **income** and **expenses**. The project is structured in a standard way, following the **layered architecture** pattern, making it easy to maintain and scale. Below is an explanation of the directory structure and the role of each folder and file.

## Project Structure

├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── example/
│   │   │   │   │   ├── Income_ExpenseTracker/
│   │   │   │   │   │   ├── controller/          # API Controllers
│   │   │   │   │   │   ├── service/             # Service Layer
│   │   │   │   │   │   ├── repository/          # Repository Layer
│   │   │   │   │   │   ├── Entity/              # Entities
│   │   │   │   │   │   ├── DTO/                 # Data Transfer Objects
│   │   └── resources/
│   │       ├── application.properties            # Application Configuration
│   ├── pom.xml                                 # Project Dependencies



http://localhost:8080/swagger-ui.html
