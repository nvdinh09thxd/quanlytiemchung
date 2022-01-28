<%@page import="Model.bean.LichSuTiem"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/UserView/U_ViewVacxin.css">
</head>
<body>
      <%	
      ArrayList<String> listnamevx  = (ArrayList)request.getAttribute("ListNameVacxin");	
      ArrayList<String> listnamevxall  = (ArrayList)request.getAttribute("ListNameVacxinall");
	ArrayList<LichSuTiem> list  = (ArrayList)request.getAttribute("ListVacXin");
	ArrayList<LichSuTiem> list1  = (ArrayList)request.getAttribute("ListVacXin1");
	ArrayList<String> idvac = (ArrayList)request.getAttribute("idvac");
	
	String SDT = request.getAttribute("SDT").toString();
	%>
	<form action="<%=request.getContextPath()%>/C_ViewVacXin" method="post">
	<h1 id="textcb">SDT:   </h1><input type="text"  value="<%=SDT%>" readonly="readonly" name="SDT_Schedule" class="input_cb" > 
	  <h1 id="textcb" >Tìm kiếm lịch tiêm :</h1> <select name="cbLich" id="selectcb" >
	  
        <%
        if(idvac != null){
        for(int i =0;i<idvac.size();i++)
        {
			%>
			       
		<option value=<%=idvac.get(i)%> ><%=listnamevxall.get(i) %></option>
				<%
				}}
				%>
		 </select>
		 		<input class="input_cb" type="submit" id="SubmitLich" value= "Tìm kiếm " name="Submit_VacXin">	
	</form>
	<%
	int i = 0 ;
	for(LichSuTiem a : list)
	{
	%>
		    <a href="">
        <div class="container">
       
            <div class="two-rows">
                <h2>
                  Tên Vắc Xin:  <%=listnamevx.get(i)%>
                </h2>
            </div>
            <div  id="the-day">
                <h1>
                  
                <h2>
                     Ngày Tiêm : 
                </h2>
                <h2>
                    <%=a.NgayTiem%>
                </h2>
            </div>
            <div class="two-rows" id="trangthai" >
                <h2>
                   Mũi thứ :  <%=a.MuiThu %>
                </h2>
            </div>
        </div>
    </a>
    <br><br><br>
		<%
		i++;} %>
	
</body>
</html>