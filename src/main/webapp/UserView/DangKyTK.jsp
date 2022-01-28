<%@page import="BEAN.Quan"%>
<%@page import="BEAN.Phuong"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>Login SSKDT</title>
    <meta charset="UTF-8">
    <link rel="styleSheet" href="<%=request.getContextPath() %>/UserView/DangKyTK.css">
</head>
<%ArrayList<Phuong> listP = null;
if((ArrayList<Phuong>)request.getAttribute("listP")!=null)
	listP = (ArrayList<Phuong>)request.getAttribute("listP");
ArrayList<Quan> listQ = null;
if((ArrayList<Quan>)request.getAttribute("listQ")!=null)
	listQ=(ArrayList<Quan>)request.getAttribute("listQ");
%>
<script type="text/javascript">
	function loadnotice() {
		<% if(request.getAttribute("notice")!=null)
		
		{%>
			alert('Số điện thoại này đã được đăng ký !');
		<%}%>
	}
</script>
<body class="background_body" onload="loadnotice()">
    <div class="div_register">
        <form class="form_register" onsubmit="return check();" action="C_Login" method="post">
            <p style="font-weight: bold;">1.Thông tin thiết yếu</p>
            <p class="">Họ và Tên</p>
            <input type="text" placeholder="Tên đầy đủ" name="Name" id="Name" class="text_res">
            <p class="">Chứng minh thư/CCCD</p>
            <input type="text" placeholder="CMND/CCCD" name="Cmnd" id="Cmnd" class="text_res">
            <p class="">Ngày sinh</p>
            <input type="date" placeholder="Ngày sinh" name="Date" id="Date" class="text_res">
            <p class="">Mã bảo hiểm y tế</p>
            <input type="text" placeholder="Mã số" name="Idy" id="Idy" class="text_res">
            <p class="">Số điện thoại</p>
            <input type="number" placeholder="Số điện thoại" name="Sdt" id="Sdt" class="text_res">
            <p style="font-weight: bold;">2.Địa chỉ cư trú</p>
            <p class="">Địa chỉ cư trú</p>
            <input type="text" placeholder="Số nhà/tên đường" name="addr" id="addr" class="text_res">
            <p class="">Quận</p>
            <select class="select_res" name="QuanSelect" id="QuanSelect" onchange="lastLoad(document.getElementById('QuanSelect').value)">
                <% for(int i =0 ;i<listQ.size();i++)
                        	{
                        	%>
                            <option value="<%=listQ.get(i).getIDQuan()%>" ><%=listQ.get(i).getNameQuan() %></option>
                            <%} %>
            </select>
            <p class="">Phường</p>
            <select class="select_res" name="PhuongSelect" id="PhuongSelect">
                 <% for(int i=0;i<listP.size();i++)
                        	{
                        	%>
                        		<option value="<%= listP.get(i).getIDPhuong()%>" ><%=listP.get(i).getNamePhuong() %></option>
                        	<%} %>
            </select>          
            <p style="font-weight: bold;">3.Thông tin đăng nhập</p>
            <p class="">Mật khẩu</p>
            <input type="password" placeholder="Mật khẩu" name="passw" id="passw" class="text_res">
            <p class="">Xác nhận mật khẩu</p>
            <input type="password" placeholder="Nhập lại mật khẩu" name="repassw" id="repassw" class="text_res">
            <br>
            <br>
            <input type="submit" name="registerAC" value="Đăng ký" class="submit_res">
            <a href="/Login/Login.html" class="a_return">Hủy bỏ</a>
            <script type="text/javascript">
            function lastLoad(idQ)
           	{
           		var sel = document.getElementById('PhuongSelect');
                while(sel.lastChild)
                {
                    sel.removeChild(sel.lastChild);
                }
                <% 
					for(int i =0;i<listP.size();i++)
					{
					
					%>
					if(idQ==<%=listP.get(i).getIDQuan()%>)
						{
						var opt = document.createElement('option');
				          	opt.value = '<%= listP.get(i).getIDPhuong()%>'; 
				            opt.appendChild( document.createTextNode('<%=listP.get(i).getNamePhuong()%>') );
						    sel.appendChild(opt);
						}
					<%}%>
                
           	}
            function check() {
				var newPass = document.getElementById('passw').value;
				var renewPass = document.getElementById('repassw').value;
				var Name = document.getElementById('Name').value;	
				var SDT = document.getElementById('Sdt').value;	
				var CMND = document.getElementById('Cmnd').value;	
				var NGAY = document.getElementById('Date').value;	
				var IDY = document.getElementById('Idy').value;	
				var addr = document.getElementById('addr').value;
				if(newPass==''||renewPass==''||Name==''||SDT==''||CMND==''||NGAY==null||IDY==''||addr=='')
				{
					alert('Hãy điền đầy đủ thông tin !!!');
					return false;
				}
				if(newPass != renewPass|| newPass==''||renewPass=='')
					{
						alert('Mật khẩu nhập lại không đúng hoặc chưa nhập mật khẩu !!!');
						return false;
					}
				else
					return true;
			}
            </script>
        </form>
    </div>
</body>

</html>