<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="<%= request.getContextPath() %>/Frameset/HeadFrameSet.css" rel="styleSheet" >
</head>
<%String usernameAdmin = request.getParameter("userAdmin").toString();%>
<body>
  <div class="container_header">
    <div class="head">
      <div class="head_logo_title">
        <img src="../image/logo.png" class="img_logo">
        <p class="p_title">Quản lý tiêm chủng</p>
      </div>
      <div class="head_name_logout">      	
        <div class="dropdown">
          <button class="dropbtn">ADMIN</button>
          <div class="dropdown-content">
            <a href="../HeadMenuServlet?Admin=true&userAdmin=<%=usernameAdmin %>" target="BODYFrame">Tạo Admin</a>
            <a href="../HeadMenuServlet?changePass=true&userAdmin=<%=usernameAdmin %>" target="BODYFrame">Đổi mật khẩu</a>
            <a href="../Login/LoginAdmin.jsp" target="_top">Thoát</a>
          </div>
        </div>           
               
      </div>    
    </div>
	<form action="../HeadMenuServlet" method="get" target="BODYFrame">
    <div class="head_menu">
        <input class="head_menu_submit" type="submit" name="schedule" value="Lịch tiêm" >
        <input  class="head_menu_submit" type="submit" name="address" value="Địa điểm" >
        <input  class="head_menu_submit" type="submit" name="history" value="Lịch sử tiêm">
        <input  class="head_menu_submit" type="submit" name="vaccine" value="Vaccine/Bệnh">
        <input  class="head_menu_submit" type="submit" name="account" value="Tài khoản">
    </div>
  </form>
  </div>
</body>
</html>