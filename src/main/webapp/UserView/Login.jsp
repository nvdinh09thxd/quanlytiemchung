<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
        <title>Đăng nhập SSKDT</title>
        <meta charset="UTF-8" >
        <link rel="styleSheet" href=".//Login.css">
    </head>
    <body  class="background_body">
        <div class="title_login_div">
           <img  src="./images/logo.png">
        </div>
        <div class="login_div">
            <form class="form_login" action="<%=request.getContextPath()%>/C_Login" method="post">
                <p class="title_user" >Số điện thoại</p>
                <input type="text" name= "SDT" >
                <p class="title_pass" >Mật khẩu</p>
                <input type="password"  name = "PassWord" >
                 <br>  <br> 
                <input type="submit" value="Đăng nhập" class="login_button" name="SubmitLogin"> 
                <br>  
                <a href="../C_Login?DangKyTK=true" class="login_a">Tạo tài khoản mới</a>        
            </form>
        </div>
    </body>
</html>