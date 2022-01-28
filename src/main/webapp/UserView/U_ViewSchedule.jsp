<%@page import="Model.bean.TrangThaiLichTiem"%>
<%@page import="Model.bean.Vac_xin"%>
<%@page import="Model.bean.LichTiem"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/UserView/U_ViewSchedule.css">
</head>
<body>
	
    <%	
		
	ArrayList<LichTiem> list  = (ArrayList)request.getAttribute("ListLichTiem");
    ArrayList<String> listnamevx  = (ArrayList)request.getAttribute("ListNameVacxin");
    ArrayList<String> listnamediadiem  = (ArrayList)request.getAttribute("ListDiaDiem");
    ArrayList<String> listnametrangthai  = (ArrayList)request.getAttribute("ListTrangThai");
	String SDT = request.getAttribute("SDT").toString();
    ArrayList<TrangThaiLichTiem> AllTrangThai  = (ArrayList)request.getAttribute("AllTrangThai");
	%>
	
	<form action="<%=request.getContextPath()%>/C_LichTiem" method="post">
	<h1 id="textcb">SDT:   </h1><input type="text" value=<%=SDT%> readonly="readonly" name="SDT_Schedule" class="input_cb" > 
	  <h1 id="textcb" >Tìm kiếm lịch tiêm :</h1> <select name="cbLich" id="selectcb" >
	  
        <%
        int k = 0 ;
         for (TrangThaiLichTiem a : AllTrangThai) {
			%>
			       
		<option value=<%=a.MaTrangThaiLichTiem%> ><%=a.TenTrangThaiLichTiem%>  </option>
				<%
				k++;}
				%>
		 </select>
		 		<input class="input_cb" type="submit" id="SubmitLich" value= "Tìm kiếm " name="Submit_Lich">	
	</form>
	
	<%
	int i = 0 ;
	for(LichTiem a : list)
	{
	%>
		<a href="<%=request.getContextPath()%>/C_LichTiem?ID_DelLich=<%=a.MaLichTiem%>" target="main_page">
        <div class="del">
       
           
        </div>
    </a>
		 <a href="">
        <div class="container">
       
            <div class="two-rows">
                <h2>
    				 Địa điểm : <%=listnamediadiem.get(i) %>
                </h2>
                  <h2>
    				 Ten Vacxin : <%=listnamevx.get(i) %>
                </h2>
            </div>
            <div  id="the-day">
               
                  
                <h2>
                    Ngày hẹn : 
                </h2>
                <h2>
                   <%= a.NgayHen %> 
                </h2>
            </div>
            <div class="two-rows" id="trangthai">
                <h2>
             		 Trạng thái : <%=listnametrangthai.get(i)%>
                </h2>
            </div>
        </div>
       
		
    <br><br><br>
     
		<%
		i++;} %>
		

</body>
</html>