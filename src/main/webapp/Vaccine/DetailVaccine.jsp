<%@page import="BEAN.disease"%>
<%@page import="BEAN.Vaccine"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>Chi tiết</title>
    <meta charset="UTF-8">
    <link rel="styleSheet" href="<%= request.getContextPath() %>/Vaccine/DetailVaccine.css">
    <script>
        function activea(tena) {
            document.getElementById(tena).click();

        }
    </script>
</head>

<body class="background_body">
    <div class="title">
        <h2>Danh sách bệnh và vaccine</h2>
    </div>
    <div class="task">

    </div>
    <% ArrayList<Vaccine> listV = (ArrayList<Vaccine>)request.getAttribute("listV"); 
    	String index = request.getAttribute("index").toString();
    	String index1 = "";String index2 = "";String index3 = "";
    	if(index=="1") index1="active";
    	else if(index =="2") index2 = "active";
    	else index3="active";
    %>
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
            <form class="form_schedule">
            <% Vaccine temp = (Vaccine)request.getAttribute("list"); %>
                <h2><%=temp.getName() %></h2>
                <div class="row1">
                    <div class="column1">
                        <div class="dad">
                            <div class="child">
                                <label>Mã vaccine<span>*</span></label> 
                                <br>
                                <input class="inputtext" type="text" value="<%=temp.getIDVac() %>" name="id" readonly style="text-transform:uppercase">
                            </div>
                            <div class="child">
                                <label>Tên vaccine<span>*</span></label> 
                                <br>
                                <input class="inputtext" type="text" value="<%=temp.getName() %>" name="name" style="text-transform:uppercase">
                            </div>
                            <div class="child">
                                <label>Số mũi cần tiêm<span>*</span></label>
                                <br>
                                <input class="inputtext" type="number" value="<%=temp.getSoMui() %>" name="num">
                            </div>
                            <div class="child">
                                <label>Khoảng cách mũi tiêm (Ngày)<span>*</span></label>
                                <br>
                                <input class="inputtext" type="number" value="<%=temp.getNextDate() %>" name="nextdate">
                            </div>
                            <div class="child">
                                <label>Mô tả vaccine<span>*</span></label>
                                <br>
                                <textarea class="inputtext" name="dec" rows="5"><%=temp.getDesc() %></textarea>
                                
                            </div>
                            
                        </div>
                    </div>
                    <div class="column2">
                        <div class="">
                            <h3>Phòng được bệnh : </h3>
                            <table class="table_detail">
                                <tr>
                                    <th>Mã Bệnh</th>
                                    <th>Tên Bệnh</th>
                                </tr>
                                <% ArrayList<disease> listB = (ArrayList<disease>)request.getAttribute("listB"); %>
                                <% for(int i =0 ;i<listB.size();i++)
                                	{%>
                                <tr>
                                    <td><%=listB.get(i).getIDdise() %></td>
                                    <td><%=listB.get(i).getName() %></td>
                                </tr>
                                <%} %>
                            </table>
                            
                        </div>
                    </div>
                </div>
                <div class="divUpdateVac">
                    <input type="submit" value="Cập nhật" name="updateVac" class="UpdateVac"> 
                </div>
                
            </form>
        </div>
    </div>
</body>

</html>