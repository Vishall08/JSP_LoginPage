<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .login-container {
            background: #ffffff;
            padding: 20px 30px;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            width: 300px;
            text-align: center;
        }
        .login-container h1 {
            font-size: 24px;
            color: #333;
            margin-bottom: 20px;
        }
        .login-container input[type="text"],
        .login-container input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-sizing: border-box;
        }
        .login-container input[type="submit"] {
            background: #007bff;
            color: white;
            border: none;
            padding: 10px;
            width: 100%;
            border-radius: 10px;
            cursor: pointer;
            font-size: 16px;
            margin-bottom: 10px;
            
        }
        .login-container input[type="submit"]:hover {
            background: #0056b3;
        }
       
        .login-container input[type="button"] {
            background: #007bff;
            color: white;
            border: none;
            padding: 10px;
            width: 100%;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
         .login-container input[type="button"]:hover {
            background: #0056b3;
        }
        .login-container a {
            display: block;
            margin-top: 10px;
            color: #007bff;
            text-decoration: none;
        }
        .login-container a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h1>Login</h1>
        <form action="RegisterServlet" method="post">
        <input type="text" name ="name" placeholder="Name" required>
            <input type="text" name="username" placeholder="Username" required />
            <input type="password" name="password" placeholder="Password" required />
            <input type="submit" value="Register" />
            
            </form>
           
        
        
        <!-- Display error message if any -->
        <% 
            String errorMessage = (String) request.getAttribute("error");
            if (errorMessage != null) {
        %>
            <div style="color: red; margin-top: 10px;">
                <strong><%= errorMessage %></strong>
            </div>
        <% 
            }
        %>
    </div>
</body>
</html>
