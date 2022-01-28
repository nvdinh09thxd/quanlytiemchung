<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/index/main.css">
    <!-- font awesome -->
    <title>Login Form</title>
</head>
<script>
    function login(link)
    {
        window.location=link;
    }
</script>
<body>
    <div class="container">
        <form class="contact__form">
            <h2>Choose Login Type</h2>

            <div class="options">
                <input type="radio" name="option" id="individual">
                <label for="individual" onclick="login('../UserView/Login.jsp')" class="hove">
                    <img src="<%= request.getContextPath() %>/image/examination.png">
                    <span class="icon__select"><i class="fas fa-user"></i></span>
                    <h3>Khách hàng</h3>
                    <span class="selected"><i class="fas fa-check"></i></span>
                </label>

                <input type="radio" name="option" id="company">
                <label for="company" onclick="login('../Login/LoginAdmin.jsp')" class="hove">
                    <img src="<%= request.getContextPath() %>/image/doctor.png">
                    <span class="icon__select"><i class="fas fa-briefcase"></i></span>
                    <h3>Bác sĩ</h3>
                    <span class="selected"><i class="fas fa-check"></i></span>
                </label>
            </div>

            

            
        </form>
    </div>

    <script src="main.js"></script>
</body>
</html>