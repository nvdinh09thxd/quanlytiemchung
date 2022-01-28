<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/UserView/Register_OK.css">
</head>
<body>
	<%
	 String TB = request.getAttribute("KQ").toString();
	%>
	

	<div class="rs">
        <h1><%=TB %>
	</h1>
    </div>

	
</body>
</html>