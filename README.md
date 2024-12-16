# JSP_LoginPage

This repository contains a login module implementation using JSP, Java Servlets, and a MySQL database. It includes the following components:

JSP files: For the front-end user interface.

Java Servlets: For backend logic and database interaction.

Database file: For the structure and sample data of the MySQL database.

Features

User login authentication

Integration with MySQL database for user validation

Clean and modular code structure

Prerequisites

Java JDK (Version 8 or above)

Eclipse IDE or any other Java IDE

Apache Tomcat (Version 9 or above)

MySQL

Setup Instructions

1. Clone the Repository

git clone https://github.com/Vishall08/JSP_LoginPage.git
cd JSP_LoginPage

2. Configure the Database

Open MySQL and create a database.

Run the login_db.sql file located in the database/ directory to create the required tables and populate them with sample data.

3. Update Database Configuration

Modify the DatabaseConnection.java file to include your MySQL database credentials:

private static final String URL = "jdbc:mysql://localhost:3306/your_database_name";
private static final String USER = "your_username";
private static final String PASSWORD = "your_password";

4. Deploy the Application

Import the project into your IDE.

Configure Apache Tomcat as your server.

Build and deploy the project.

Access the application at http://localhost:8080/JSP_LoginPage/login.jsp.

Usage

Navigate to the login page.

Enter your credentials.

Upon successful login, you will be redirected to the success page. If login fails, you will see an error message.

Files Description

login.jsp: The login page where users enter their credentials.

error.jsp: Displays an error message for invalid login attempts.

success.jsp: Displays a welcome message for valid users.

LoginServlet.java: Handles the login logic and connects to the database.

DatabaseConnection.java: Manages the connection to the MySQL database.

login_db.sql: Contains the SQL script for setting up the database.





Contribution

Feel free to fork the repository and submit pull requests for improvements.



