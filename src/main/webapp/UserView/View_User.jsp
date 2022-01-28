<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
     <link rel="stylesheet" href="View_User.css">
     
</head>
<body>
	<%	
		String Ten = request.getParameter("Ten");
		String SDT = request.getParameter("SDT");
	/* 	String CMND = request.getParameter("CMND").toString(); */
	%>
 <div class="program">
        <div class="header">
         <div class="Information">
                <h1 style="text-align:center;">  Xin chào   : <%=Ten %> </h1>
               
            </div>
          <a href="../index/main.jsp" target="_top" >
            <div class="avatar">

            </div>
			</a>
           
          
        </div>
        <div class="function">
            <a href="<%=request.getContextPath()%>/C_Register?IDRegister=<%=SDT%>" target="main_page" >
                <div class="Register col_function " >
    				
                    <h3>ĐĂNG KÍ TIÊM</h3>
                   
                </div>
            </a>
            <a href="<%=request.getContextPath()%>/C_LichTiem?IDSchedule=<%=SDT%>" target="main_page" >
            	
                <div class="View_Schedule col_function">
               	<h3>XEM LỊCH TIÊM</h3>
                </div>
            </a>
            <a href="<%=request.getContextPath()%>/C_ViewVacXin?IDViewVacXin=<%=SDT%>" target="main_page"  >
            	
                <div class="View_Vacxin col_function">
                <h3> VAC-XIN ĐÃ TIÊM </h3>
                </div>
            </a>
            
            
            <div class="View_Address col_function">
				<h3> ĐANG NÂNG CẤP </h3>
            </div>

            <div class="View_Certifition col_function">
				 <h3> ĐANG NÂNG CẤP  </h3>	
            </div>
        </div>
</body>
</html>