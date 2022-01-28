<%@page import="BEAN.AccountAdmin"%>
<%@page import="java.util.ArrayList"%>
<%@page import="BEAN.disease"%>
<%@page import="BEAN.Vaccine"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>Admin</title>
    <meta charset="UTF-8">
    <link rel="styleSheet" href="<%= request.getContextPath() %>/ManaAdmin/Admin.css">
</head>
<% ArrayList<AccountAdmin> listA = (ArrayList<AccountAdmin>)request.getAttribute("listA");
String userAdmin = request.getAttribute("userAdmin").toString();
%>
<body class="background_body">
    <div class="title">
        <h2>Tài khoản admin</h2>
    </div>
    <div class="task">
    </div>
    <div class="">
            
                <h2><input type="password" name="userAdmin" value="<%=userAdmin%>" ></h2>
                <div class="row1">
                    <form class="form_schedule" action="HeadMenuServlet" method="get">
                    <input type="password" name="userAdmin" value="<%=userAdmin%>" readonly="readonly" class="ninja">
                    <div class="column1">
                        <div class="">
                            <div class="title_table">
                                <h3>Tài khoản đang dùng : <%=userAdmin %></h3>
                            </div>
                            <div class="Delete_button">
                                <img src="<%= request.getContextPath() %>/image/delete.png">
                                <input type="submit" name="deleteAdmin" value="Xóa" class="delete">
                            </div>
                            <table class="table_accountUser">

                                <thead>

                                    <tr class="head_table">
                                        <th>Tên người dùng</th>
                                        <th>Chọn</th>
                                    </tr>

                                </thead>
                                <tbody>
                                <% for(int i =0;i<listA.size();i++)
                                	{%>
                                    <tr class="detail_schedule" onclick="">
                                        <td><%=listA.get(i).getUsername() %></td>
                                        <td><input type="checkbox" name="listDel" value="<%=listA.get(i).getUsername() %>"></td>
                                    </tr>
                                    <%} %>
                                </tbody>
                            </table>

                        </div>
                    </div>
                </form>
                <form action="HeadMenuServlet" method="get" onsubmit="return checkexit()">
                    <div class="column2">
                        <div>
                            <h2>Tạo tài khoản Admin</h2>
                        </div>
                        <div class="dad">
                            <div class="child">
                                <div>
                                    <label>Tên tài khoản</label>
                                </div>
                                
                                <input type="text" placeholder="tên tài khoản" id="user" name="user" class="search_input">
                                
                            </div>
                            <div class="child">
                                <div><label>Mật khẩu</label></div>
                                
                                <input type="text" placeholder="Mật khẩu" id="pass" name="pass" class="search_input">
                                
                            </div>
                            <input type="password" name="userAdmin" value="<%=userAdmin%>" class="ninja" readonly="readonly">
                            <div class="Add_button">
                                <img src="<%= request.getContextPath() %>/image/plus.png">
                                <input type="submit" name="addAdmin" value="Tạo" class="Add">
                                
                            </div>
                        </div>
                    </div>
                    <script type="text/javascript">
                    	function checkexit() {	
							var username =  document.getElementById('user').value;
							var passw = document.getElementById('pass').value;
							  
							if(username==''||passw=='')
							{
							 	alert("Hãy nhập đủ thông tin"); 
							    return false;
							}
							<% for(int i =0;i<listA.size();i++)
								{
							%>
								if(username=='<%=listA.get(i).getUsername()%>'||username=='<%=userAdmin%>')
									{
									 	alert("Tài khoản này đã tồn tại ! hãy kiểm tra lại"); 
									    return false;
									}
								
							
							<%}%>
							return true;
						}
                    	</script>
                </form>
                </div>

            
    </div>
</body>

</html>