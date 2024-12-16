package com.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get data from the form
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        // Database connection parameters
        String url = "jdbc:mysql://localhost:2508/login?useSSL=false";
        String dbUsername = "root";
        String dbPassword = "Vishal@2508";

        try (Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)) {
            // SQL query to insert the user data
            String sql = "INSERT INTO users (name, username, password) VALUES (?, ?, ?)";

            // Prepare the statement
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, username);
            stmt.setString(3, password);

            // Execute the query
            int rowsAffected = stmt.executeUpdate();

            // Redirect to a success page or show a message
            if (rowsAffected > 0) {
                // Pass the name as a query parameter to Welcome.jsp
                response.sendRedirect("Welcome.jsp?name=" + java.net.URLEncoder.encode(name, "UTF-8"));
            } else {
                // Handle unexpected cases where no rows were affected
                request.setAttribute("error", "Unable to register. Please try again.");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            // Log the exception for debugging
            e.printStackTrace();
            request.setAttribute("error", "Database error: " + e.getMessage());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}



//package com.login;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@SuppressWarnings("serial")
//@WebServlet("/RegisterServlet")
//public class RegisterServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // Get data from the form
//        String username = request.getParameter("username");
//        String name = request.getParameter("name");
//        String password = request.getParameter("password");
//
//        // Database connection parameters
//        String url = "jdbc:mysql://localhost:2508/login";
//        String dbUsername = "root";
//        String dbPassword = "Vishal@2508";
//
//        try {
//            // Establish connection to the database
//            Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword);
//
//            // SQL query to insert the user data
//            String sql = "INSERT INTO users (name, username, password) VALUES (?, ?, ?)";
//
//            // Prepare the statement
//            PreparedStatement stmt = conn.prepareStatement(sql);
//            stmt.setString(1, name);  // Set 
//            stmt.setString(2, username);     // Set email
//            stmt.setString(3, password);  // Set password
//
//            // Execute the query
//            int rowsAffected = stmt.executeUpdate();
//
//            // Close resources
//            stmt.close();
//            conn.close();
//
//            // Redirect to a success page or show a message
//            if (rowsAffected > 0) {
//                response.sendRedirect("Welcome.jsp");
//            } else {
//                response.sendRedirect("error.jsp");
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            response.sendRedirect("error.jsp");
//        }
//    }
//}
