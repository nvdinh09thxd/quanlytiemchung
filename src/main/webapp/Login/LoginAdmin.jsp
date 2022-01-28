<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <%@ page import="java.lang.*" %>
        <title>Đăng nhập SSKDT</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="styleSheet" href="<%= request.getContextPath() %>/Login/LoginAdmin.css">
    </head>
    <body  class="background_body">
        <div class="login">
        <h1>Quản lý tiêm chủng</h1>
        <form action="../CheckLoginAdminServlet"    method="post">
          <p><input type="text" name="username" value="" placeholder="Username"></p>
          <p><input type="password" name="password" value="" placeholder="Password"></p>
          <p class="submit"><input type="submit" name="commit" value="Login"></p>
        </form>
      </div>
    </body>
</html>