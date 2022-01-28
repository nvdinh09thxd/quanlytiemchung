<%@page import="Model.bean.DiaDiem"%>
<%@page import="Model.bean.Vac_xin"%>
<%@page import="Model.bean.PhongBenh"%>
<%@page import="Model.bean.Phuong"%>
<%@page import="Model.bean.Benh"%>
<%@page import="Model.bean.Quan"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="<%=request.getContextPath()%>/UserView/U_Register.css">
</head>
</head>
<body>
 <%
 	ArrayList<Quan> quan = (ArrayList)  request.getAttribute("ListQuan");
 	ArrayList<Benh> Benh =(ArrayList)  request.getAttribute("ListBenh");
 	ArrayList<PhongBenh> Phongbenh =(ArrayList)  request.getAttribute("ListPhongBenh");
 	ArrayList<Vac_xin> Vacxin =(ArrayList)  request.getAttribute("ListVacxin");
	ArrayList<Phuong> phuong = (ArrayList) request.getAttribute("ListPhuong");
	ArrayList<DiaDiem> diadiem = (ArrayList) request.getAttribute("ListDiaDiem");
	String SDT = request.getParameter("IDRegister");
	String KQ = request.getParameter("name");
 %>
	<script language="javascript" type="text/javascript">

	function GetTenPhuongById(obj){
		
  		 var ID = obj.value;
  		 
			
			 var te = document.getElementById("DetailAddress"); 
					 <%
				      for (DiaDiem a : diadiem) {
							%>
								
								if(ID == <%=a.MaDiaDiem%>)
									{
									te.value = "<%=a.SoNha%>";
									
									}
								<%
								}
								%> 
  	}
    function GetPhuongByQuan(obj){
        var name = obj.value;
      var combobox = document.getElementById("SelectPhuong");  
      var length = combobox.options.length;
      for (i = length-1; i >= 0; i--) {
      	combobox.options[i] = null;
      	}
      <%
      for (Phuong a : phuong) {
			%>
			if(name == <%=a.MaQuan%> )
				{
					var opt = document.createElement('option');
					opt.value = '<%=a.MaPhuong%>';
					
					opt.appendChild(document.createTextNode('<%=a.TenPhuong%>'));
					combobox.appendChild(opt);
				}
				<%
				}
				%> 
    }
    function GetDiaDiemByPhuong(obj){
        var name = obj.value;
      var combobox = document.getElementById("SelectDiaDiem");  
      var length = combobox.options.length;
      for (i = length-1; i >= 0; i--) {
      	combobox.options[i] = null;
      	}
      <%
      for (DiaDiem a : diadiem) {
			%>
			if(name == <%=a.MaPhuong%> )
				{
					var opt = document.createElement('option');
					opt.value = '<%=a.MaDiaDiem%>';
					
					opt.appendChild(document.createTextNode('<%=a.TenDiaDiem%>'));
					combobox.appendChild(opt);
				}
				<%
				}
				%> 
    }
    	function GetVacXinByBenh(obj){

    		 var name = obj.value;
			
    	      var combobox = document.getElementById("SelectVacXin");  
    	      var length = combobox.options.length;
    	      for (i = length-1; i >= 0; i--) {
    	      	combobox.options[i] = null;
    	      	}
    	      
    	      <%
    	      for (PhongBenh a : Phongbenh) {
    				%>
    				
    				if(name == '<%=a.MaBenh%>' )
    					{
    					
    						<%
    						
    						for(Vac_xin b : Vacxin){ 
    						
    							%>
    							
    							if('<%=a.MaVacXin%>' == '<%=b.MaVacXin%>'){
    						
    							var opt = document.createElement('option');
        						opt.value = '<%=b.MaVacXin%>';
        					
        						opt.appendChild(document.createTextNode('<%=b.TenVacXin%>'));
        						combobox.appendChild(opt);
    							}
        					<%
        					}
        					%> 
    					
    					}
    					<%
    					}
    					%> }
    	
   	function checkDate() {
   		var valueDate = document.getElementById('date').value;
   		if ( valueDate== null || valueDate== '')
   		{
   		    alert('Hãy nhập ngày bạn muốn tiêm');
   		    return false;
   		}
	}
    
    </script>
	
	<div class="Data">
        <h1>ĐĂNG KÍ TIÊM  </h1>
    
        <form class="View_Register" action="<%=request.getContextPath()%>/C_Register" method="post" onsubmit="return checkDate();">
           <h4>ID:   </h4><input type="text" value=<%=SDT%> readonly="readonly" name="IDRegister1"> <br> <br>
  
	<h4>Bệnh đăng kí tiêm  :</h4> <select name="cbBenh" onchange="GetVacXinByBenh(this)">
        <%
         for (Benh a : Benh) {
			%>
		<option value=<%=a.MaBenh%> ><%=a.TenBenh%>  </option>
				<%
				}
				%>
		 </select><br><br>	
	 <h4>Loại Vacxin :</h4> <select name="cbVacXin" id="SelectVacXin"> 
	</select><br><br>
		
    <h4>Ngày Tiêm :</h4><input type="date" id="date"  name="NgayTiem" ><br>
      		 
    <br>	
   <h4>Địa chỉ tiêm  :</h4> <select name="cbDiaChi"  id="SelectDiaDiem" onclick="GetTenPhuongById(this)">
        <%
         for (DiaDiem a : diadiem) {
			%>
		<option value=<%=a.MaDiaDiem%> ><%=a.TenDiaDiem%>  </option>
				<%
				}
				%>
		 </select><br><br>	
		
		<h4>Địa chỉ chi tiết  :</h4> <input type="text"  id="DetailAddress" placeholder="Chọn địa điểm tiêm " readonly="readonly"><br><br><br>
		<input type="submit" id="SubmidRegister" value= "Đăng Kí Tiêm" name="Submit_Register">
        </form>
    </div>
</body>
</html>