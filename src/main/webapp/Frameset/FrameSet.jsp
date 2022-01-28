<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<frameset rows="125,*" frameborder="0">
<%String user = request.getAttribute("username").toString();%>
    <frame name="header" scrolling="no" noressize target="contents" src="${pageContext.request.contextPath}/Frameset/HeadFrameSet.jsp?userAdmin=<%=user%>">
    
    <frame name="BODYFrame" scrolling ="" src="${pageContext.request.contextPath}/Frameset/mainAdmin.jsp">
</frameset>
<noframes>

</noframes>
</html>