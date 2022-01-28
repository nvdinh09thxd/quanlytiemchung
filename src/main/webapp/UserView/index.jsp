<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

    </head>
  	<%	
		String Ten = request.getAttribute("UserName").toString();
		String SDT = request.getAttribute("SDTUser").toString();
	
	%>

     <frameset rows="35%,65%" frameborder="0" scrolling="">
        <frame src="UserView/View_User.jsp?Ten=<%=Ten%>&SDT=<%=SDT%> "  name="head_page">

        <frame src="UserView/View.html" name="main_page">
    </frameset>
    <noframes>
        <body>
            
        </body>
    </noframes>
    
</html>