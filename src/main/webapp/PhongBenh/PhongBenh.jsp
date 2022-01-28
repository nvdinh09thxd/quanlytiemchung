<%@page import="BEAN.Vaccine"%>
<%@page import="BEAN.disease"%>
<%@page import="BEAN.PhongBenh"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>Chi tiết</title>
    <meta charset="UTF-8">
    <link rel="styleSheet" href="<%= request.getContextPath() %>/PhongBenh/PhongBenh.css">
    <script>
        function activea(tena) {
            document.getElementById(tena).click();

        }
    </script>
</head>

<body class="background_body">
    <div class="title">
        <h2>Vaccine/Bệnh</h2>
    </div>
    <div class="task">
 <% 	ArrayList<PhongBenh> listPB = (ArrayList<PhongBenh>)request.getAttribute("listPB");
 		ArrayList<disease> listB = (ArrayList<disease>)request.getAttribute("listB");
 		ArrayList<Vaccine> listV = (ArrayList<Vaccine>)request.getAttribute("listV");
    	String index = request.getAttribute("index").toString();
    	String index1 = "";String index2 = "";String index3 = "";
    	if(index=="1") index1="active";
    	else if(index =="2") index2 = "active";
    	else index3="active";
    %>
    </div>
    <div class="row">
        <div class="column left">

            <div class="location">
                <div class="location_item <%=index1 %>" onclick="activea('a2')">
                    <img src="<%= request.getContextPath() %>/image/vaccination.png">
                    <a href="VaccineServlet?Vaccine=true" id="a2">Vaccine</a>
                </div>
                <div class="location_item <%=index2 %>" onclick="activea('a1')">
                    <img src="<%= request.getContextPath() %>/image/virus.png">
                    <a href="VaccineServlet?Benh=true" id="a1" class="">Bệnh</a>
                </div>     
                <div class="location_item <%=index3 %>" onclick="activea('a3')">
                    <img src="<%= request.getContextPath() %>/image/vaccine.png">
                    <a href="VaccineServlet?PhongBenh=true" id="a3" class="">Phòng bệnh</a>
                </div>        
            </div>
        </div>
        <div class="column right" id="right">
            <form class="form_schedule" onsubmit="return CheckExitPB();">
                <h2>Tên vaccine</h2>
                <div class="row1">
                    <div class="column1">
                        <div class="">
                            <div class="title_table">
                                <h3>Vaccine/Bệnh</h3>
                            </div>
                            <div class="Delete_button">
                                <img src="<%= request.getContextPath() %>/image/delete.png">
                                <input type="submit" id="deletePB" name="deletePB" value="Xóa" class="delete">
                            </div>
                            <table class="table_accountUser">

                                <thead>

                                    <tr class="head_table">
                                        <th>Tên vaccine</th>
                                        <th>Tên bệnh</th>
                                        <th>Chọn</th>
                                    </tr>

                                </thead>
                                <tbody>
                                <% for(int i = 0 ;i<listPB.size();i++)
                                	{%>
                                    <tr class="detail_schedule" onclick="">
                                        <td><%=listPB.get(i).getNameVac() %></td>
                                        <td><%=listPB.get(i).getNameBenh() %></td>
                                        <td><input type="checkbox" name="listPBDel" value="<%=listPB.get(i).getIDVac()%>&&<%=listPB.get(i).getIDBenh()%>"></td>
                                    </tr>
                                    <%} %>
                                    
                                </tbody>
                            </table>

                        </div>
                    </div>
                    <div class="column2">
                        <div>
                            <h2>Thêm liên kết bệnh-vaccine</h2>
                        </div>
                        <div class="dad">
                            <div class="child">
                                <label>Vaccine</label>
                                <br>
                                <select name="CBVac" id="CBVac" class="combobox_vac">
                                <%for(int i=0;i<listV.size();i++)
                                	{%>
                                    <option value="<%=listV.get(i).getIDVac()%>"><%=listV.get(i).getName()%></option>
                                    <%} %>
                                </select>
                            </div>
                            <div class="child">
                                <label>Bệnh</label>
                                <br>
                                <select id="CBB" name="CBB" class="combobox_vac">
                                   <%for(int i=0;i<listB.size();i++)
                                	{%>
                                    <option value="<%=listB.get(i).getIDdise()%>"><%=listB.get(i).getName()%></option>
                                    <%} %>
                                </select>
                            </div>
                            <div class="Add_button">
                                <img src="<%= request.getContextPath() %>/image/plus.png">
                                <input type="submit" name="addPhongBenh" value="Thêm vào" class="Add">
                            </div>
                        </div>
                    </div>
                </div>
						<script type="text/javascript">
							function CheckExitPB()
							{
								var check =document.activeElement.getAttribute('name');
								if(check =='deletePB')
									return true;
								var IDVac = document.getElementById('CBVac').value;
								var IDB = document.getElementById('CBB').value;
								<% for(int i =0;i<listPB.size();i++)
									{
								%>
									if(IDVac=='<%=listPB.get(i).getIDVac()%>' && IDB=='<%=listPB.get(i).getIDBenh()%>')
										{
										 	alert("Đã có liên kết này"); 
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