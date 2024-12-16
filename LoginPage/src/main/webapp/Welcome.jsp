<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .welcome-container {
            text-align: center;
            background: white;
            padding: 20px 30px;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
        .welcome-container h1 {
            font-size: 24px;
            color: #333;
        }
    </style>
</head>
<body>
<%
    // Get the current session, don't create one if it doesn't exist
     
    
    // Check if the session exists and if the username attribute is present
    if (session == null || session.getAttribute("username") == null) {
        // If not, redirect to login page
        response.sendRedirect("login.jsp");
        return;
    }
    
    // Retrieve the username from the session
    String username = (String) session.getAttribute("username");
%>
    <div class="welcome-container">
        <h1>Welcome, <%= username %>!</h1>
        <p>You have successfully logged in.</p>
        <a href="logoutServlet">Logout</a>
    </div>
</body>
</html>
