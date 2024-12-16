package com.login;

import java.io.IOException;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:8080/Login";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "****";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 1: Establish database connection
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {

                // Step 2: Create SQL query to check if the username and password exist
                String query = "SELECT * FROM users WHERE username = ? AND password = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, username);
                    preparedStatement.setString(2, password);

                    ResultSet resultSet = preparedStatement.executeQuery();

                    // Step 3: If credentials match, create session and redirect to Welcome page
                    if (resultSet.next()) {
                        HttpSession session = request.getSession();  // Create a new session
                        session.setAttribute("username", username);  // Store username in session
                        response.sendRedirect("Welcome.jsp");  // Redirect to Welcome page
                    } else {
                        // Invalid credentials, redirect with error message
                        request.setAttribute("error", "Invalid username or password");
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                    }

                }
            }
        } catch (ClassNotFoundException e) {
            // Server error, unable to find JDBC driver
            request.setAttribute("error", "Server error occurred: Driver not found");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } catch (SQLException e) {
            // Database connection error
            request.setAttribute("error", "Database error occurred");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}



