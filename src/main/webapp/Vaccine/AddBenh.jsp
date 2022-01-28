<%@page import="BEAN.disease"%>
<%@page import="BEAN.Vaccine"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>Đăng nhập SSKDT</title>
    <meta charset="UTF-8">
    <link rel="styleSheet" href="<%= request.getContextPath() %>/Vaccine/AddBenh.css">
    <script>
        function activea(tena) {
            document.getElementById(tena).click();

        }   	
    </script>
</head>
<% disease B = null;
	if(request.getAttribute("B")!=null)
		B  = (disease)request.getAttribute("B");
	ArrayList<disease> listB = (ArrayList<disease>)request.getAttribute("listB");
%>
<body class="background_body">
    <div class="title">
        <h2>Danh sách bệnh và vaccine</h2>
    </div>
    <div class="task">

    </div>
    <% 
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
        <%if(B!=null)
        	{%>
            <form class="form_schedule" action="" method="get">
                <h2><%=B.getName() %></h2>
                        <div class="dad">
                            <div class="child">
                                <label>Mã bệnh<span>*</span></label> 
                                <br>
                                <input class="inputtext" type="text" value="<%=B.getIDdise() %>" name="idBenh" readonly>
                            </div>
                            <div class="child">
                                <label>Tên bệnh<span>*</span></label> 
                                <br>
                                <input class="inputtext" type="text" value="<%=B.getName() %>" name="nameBenh" >
                            </div>
                            <div class="child">
                                <label>Mô tả<span>*</span></label>
                                <br>
                                <textarea name="decBenh" id="" class="inputtext" rows="15" ><%=B.getDisc() %></textarea>
                            </div>
                            
                        </div>
                <div class="divUpdateVac">
                    <input type="submit" value="Cập nhật" name="updateBenh" class="UpdateVac"> 
                </div>
                
            </form>
            <%}
        else
        {%>
        <form class="form_schedule" action="" method="get">
                <h2>Thêm bệnh mới</h2>
                        <div class="dad">
                            <div class="child">
                                <label>Tên bệnh<span>*</span></label> 
                                <br>
                                <input class="inputtext" type="text" value="" name="nameBenh" placeholder="Tên bệnh">
                            </div>
                            <div class="child">
                                <label>Mô tả<span>*</span></label>
                                <br>
                                <textarea name="decBenh" id="" class="inputtext" rows="15" placeholder="Mô tả về bệnh"></textarea>
                            </div>
                            
                        </div>
                <div class="divUpdateVac">
                    <input type="submit" value="Thêm mới" name="ADDBENH" class="UpdateVac"> 
                </div>
                
            </form>
        <%} %>
        </div>
    </div>
</body>

</html>