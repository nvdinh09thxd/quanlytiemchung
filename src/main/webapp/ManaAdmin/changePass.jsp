<%@page import="BEAN.AccountAdmin"%>
<%@page import="java.util.ArrayList"%>
<%@page import="BEAN.disease"%>
<%@page import="BEAN.Vaccine"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Đăng nhập SSKDT</title>
        <meta charset="UTF-8" >
        <link rel="styleSheet" href="<%= request.getContextPath() %>/ManaAdmin/changePass.css">
    </head>
    <% String userName = request.getAttribute("userAdmin").toString();%>
    <script type="text/javascript">   	
		    	function loadmk() {
					
		    		<% if(request.getAttribute("notice")!=null)
		    	    {%>
		    	    	
		    	    		alert('Mật khẩu cũ bạn nhập không đúng !');
		    		
		    	    <% 
		    	    }
		    	    %>
				}		  		
    			</script>
    <body  class="background_body" onload="loadmk()">
		<div class="login_div2">
            <h2>Tài khoản</h2>
            <h3><%=userName %></h3>
        </div>
        <div class="login_div">
            <form class="form_login" action="HeadMenuServlet" method="get" onsubmit="return check();">
            	<p class="title_user">Tài khoản</p>
                <input type="text" value="<%=userName%>" name="user" readonly>
                <p class="title_user">Mật khẩu cũ</p>
                <input type="password" value="" name="oldpass">
                <p class="title_pass" >Mật khẩu mới</p>
                <input type="password" value="" name="newpass" id ="newpass" >
                <p class="title_pass2">Nhập lại mật khẩu mới</p>
                <input type="password" value="" name="renewpass" id="renewpass">
                 <br>  <br> 
                <input type="submit" value="Xác nhận" class="login_button" name="changePassSub">  
                
            </form>
            <script type="text/javascript">
            	function check() {
					var newPass = document.getElementById('newpass').value;
					var renewPass = document.getElementById('renewpass').value;					
					if(newPass != renewPass)
						{
							alert('Mật khẩu nhập lại không đúng');
							return false;
						}
					else
						return true;
				}
            </script>
        </div>
    </body>
</html>