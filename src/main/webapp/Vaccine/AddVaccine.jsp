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
    <link rel="styleSheet" href="<%= request.getContextPath() %>/Vaccine/AddVaccine.css">
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
            <form class="form_schedule" action="VaccineServlet" method="get" onsubmit="return checkVCExits();">
                <h2>Thêm vaccine</h2>
                <div class="row1">
                    <div class="column1">
                        <div class="dad">
                            <div class="child">
                                <label>Mã vaccine<span>*</span></label> 
                                <br>
                                <input class="inputtext" type="text" value="" name="id" id="id" style="text-transform:uppercase">
                            </div>
                            <div class="child">
                                <label>Tên vaccine<span>*</span></label> 
                                <br>
                                <input class="inputtext" type="text" value="" name="name" id="name" style="text-transform:uppercase">
                            </div>
                            <div class="child">
                                <label>Số mũi cần tiêm<span>*</span></label>
                                <br>
                                <input class="inputtext" type="number" min="1" value="1" name="num" id="num">
                            </div>
                            <div class="child">
                                <label>Khoảng cách mũi tiêm<span>*</span></label>
                                <br>
                                <input class="inputtext" type="number" min="1" value="1" id="next" name="next">
                            </div>
                            <div class="child">
                                <label>Mô tả vaccine<span>*</span></label>
                                <br>
                                <textarea class="inputtext" name="dec" id="dec" rows="5">mô tả ở đây</textarea>
                            </div>
                            
                        </div>
                    </div>
                </div>
                <div class="divUpdateVac">
                    <input type="submit" value="Thêm vào" name="addVac" class="UpdateVac"> 
                </div>
                <script type="text/javascript">
                	function checkVCExits()
                	{
                		var id = document.getElementById("id").value;
                		var name = document.getElementById("name").value;
                		var num = document.getElementById("num").value;
                		var next = document.getElementById("next").value;
                		var dec = document.getElementById("dec").value;
                		alert(id+name+num+next+dec);	
                		if(id==''||name==''||dec==''||num==''||next=='')
                			{
                			alert("Hãy nhập đầy đủ thông tin !!");				    
						    return false;
                			}
                		<% for(int i = 0;i<listV.size();i++)
                		{
                		%>
                			if(id=='<%=listV.get(i).getIDVac()%>')
                				{
                				alert("Mã vaccine đã tồn tại hãy kiểm tra lại !!");				    
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