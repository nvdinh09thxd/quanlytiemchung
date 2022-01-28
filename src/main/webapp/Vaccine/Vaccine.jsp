<%@page import="BEAN.Vaccine"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>Đăng nhập SSKDT</title>
    <meta charset="UTF-8">
    <link rel="styleSheet" href="<%= request.getContextPath() %>/Vaccine/Vaccine.css">
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
            <form class="form_schedule" action="VaccineServlet" method="get" onsubmit="return confirmF();">
                <input type="text" name="searchVaccine" id="searchVaccine" value="" placeholder="Thông tin tìm kiếm" class="search_input" onkeyup="search()">                
                <div class="Delete_button">
                <img src="<%= request.getContextPath() %>/image/delete.png">                
                <input type="submit" name="deleteVac" value="Xóa" class="delete">
                </div>
                <div class="Add_button">
                                <img src="<%= request.getContextPath() %>/image/plus.png">
                                <input type="submit" name="addvaccine" value="Thêm" class="Add">
                            </div>
                <table class="table_accountUser" id="tableVac">
    
                    <thead>
    
                        <tr class="head_table">
                            <th>Mã vaccine</th>
                            <th>Tên</th>
                            <th>Số mũi cần tiêm</th>
                            <th>Khoảng cách mũi tiêm</th>
                            <th>Chọn</th>
                        </tr>
    
                    </thead>
    
                    <tbody>
                    <%	for(int i=0;i<listV.size();i++)
                    	{%>
                        <tr class="detail_schedule" ondblclick="window.location='VaccineServlet?detailVac=<%=listV.get(i).getIDVac()%>';">
                            <td><%=listV.get(i).getIDVac() %></td>
                            <td><%=listV.get(i).getName() %></td>
                            <td><%=listV.get(i).getSoMui()%></td>
                            <td><%=listV.get(i).getNextDate() %></td>
                            <td><input type="checkbox" name="ListDel" value="<%= listV.get(i).getIDVac()%>"></td>
                        </tr>
                        <%} %>
                       
                    </tbody>
                </table>
            </form>
        </div>
    </div>
    <script type="text/javascript">
                	function confirmF() {
                		var check =document.activeElement.getAttribute('name');
                		if (check != 'deleteVac')
                			return true;
                		else
                			{
                				if(confirm('Bạn có thật sự muốn xóa đối tượng này ?'))
                					return true;
                				else
                					return false;
                			}                			
					}
                	function search()
                    {
                		var tableHeaderRowCount = 1;
                		var table = document.getElementById('tableVac');
                		var rowCount = table.rows.length;
                		for (var i = tableHeaderRowCount; i < rowCount; i++) {
                		    table.deleteRow(tableHeaderRowCount);
                		}
                        var info = document.getElementById('searchVaccine').value;
                        var tbodyRef = document.getElementById('tableVac').getElementsByTagName('tbody')[0];
                        var z=0;
                        <% for(int i=0;i<listV.size();i++)
                        {%>
                        var text = '<%=listV.get(i).getName()%>' + '<%=listV.get(i).getIDVac()%>';
                        text=text.toLowerCase();
                        if(text.includes(info))
                        {
                            var newrow = tbodyRef.insertRow(z);
                            var newcell0 = newrow.insertCell(0);
                            var newcell1 = newrow.insertCell(1);
                            var newcell2 = newrow.insertCell(2);
                            var newcell3 = newrow.insertCell(3);
                            var newcell4 = newrow.insertCell(4);
                            newcell0.innerHTML = '<%= listV.get(i).getIDVac()%>';
                            newcell1.innerHTML = '<%= listV.get(i).getName()%>';
                            newcell2.innerHTML = '<%= listV.get(i).getSoMui()%>';
                            newcell3.innerHTML = '<%= listV.get(i).getNextDate()%>';
                            var newcheckbox = document.createElement('input');
                            newcheckbox.type = 'checkbox';
                            newcheckbox.setAttribute('name','ListDel');
                            newcheckbox.value = '<%= listV.get(i).getIDVac()%>';
                            newcell4.appendChild(newcheckbox);
                            newrow.ondblclick=function(){window.location='VaccineServlet?detailVac=<%=listV.get(i).getIDVac()%>';}
                            z=z+1;
                        }
                        
                        <%}%>
                    }
                </script>
</body>

</html>