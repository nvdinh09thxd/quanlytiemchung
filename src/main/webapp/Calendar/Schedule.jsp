<%@page import="BEAN.StatusSche"%>
<%@page import="BEAN.Schedule"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link href="<%= request.getContextPath() %>/Calendar/Schedule.css" rel="styleSheet" >
     
</head>

<body>
    <div class="title_schedule">
    	<img alt="" src="<%=request.getContextPath()%>/image/schedule.png">
        <h2>Lịch tiêm vaccine</h2>

    </div>
	<br>
	<br>
    <div class="content">
    	<form action="ScheduleBodyServlet" method="get">
        		<div>
        		<img alt="" src="<%=request.getContextPath()%>/image/filter.png" class="filter">
                <select name="selectOption" id="selectOption" onchange="this.form.submit()" class="selectForm">
                <% ArrayList<StatusSche> listsche  = (ArrayList<StatusSche>)request.getAttribute("status");
                String id =null;
                if(request.getAttribute("index")!=null)
                	id = request.getAttribute("index").toString();
                for(int i =0;i<listsche.size();i++)
                {String temp =listsche.get(i).getIdSta(); 
                String select ="";
                if(temp.equals(id)&&id!=null) 
                	select="selected";
                %>
                    <option value="<%=temp%>" <%=select %>><%= listsche.get(i).getNameSta() %></option>
                    <%} %>
                </select>
                <% String option="";
                if(request.getAttribute("option")!=null)
                option = request.getAttribute("option").toString();
                String New="";
                String Old="";
                String Vac="";
                if(option.equals("new")||option=="")
                	New = "selected";
                else
                if(option.equals("old"))
                	Old = "selected";
                else
                if(option.equals("vac"))
                	Vac = "selected";
                else
                	New ="selected";
                %>
                <select name="selectOption2" id="selectOption" onchange="this.form.submit()" class="selectForm select2">
                <option value="new" <%=New %>>Mới nhất</option>
                <option value="old" <%=Old %>>Cũ nhất</option>
                <option value="vac" <%=Vac %>>Tên vaccine</option>
                </select>
            </div>    	
    	</form>
        <form action="ScheduleBodyServlet" method="get">
        	<div>
        		<input type="submit" value="Xác nhận" name="DoneSche" id="btsubmit" class="compl_row_button">
        		<input type="submit" value="Xóa lịch hẹn" name="DeleteSche" class="delete_row_button">
        	</div>
        	<script>
        function SwapButton() {
            var idstastus = document.getElementById('selectOption').value;
			var bt = document.getElementById('btsubmit');
			if(idstastus=='1')
				{
				bt.setAttribute('name','AcceptSche');
				bt.value="Xác nhận";
				}
			else
			if(idstastus=='4')
				{
				bt.setAttribute('name','DoneSche');
				bt.value= "Đã tiêm";
				}
			else
				bt.remove();
        	}
        SwapButton();
    		</script>
            <table class="table_accountUser">

                <thead>

                    <tr class="head_table">
                        <th>STT</th>
                        <th>SĐT</th>
                        <th>Tên vaccine</th>
                        <th>Ngày hẹn</th>
                        <th>Địa điểm tiêm</th>
                        <th>Mũi tiêm thứ</th>
                        <th>Chọn</th>
                    </tr>

                </thead>
				
                <tbody>
                	<%
                	ArrayList<Schedule> list = (ArrayList<Schedule>)request.getAttribute("listSchedule"); 
                	for(int i =0;i< list.size();i++) 
                	{%>
                    <tr class="detail_schedule" ondblclick="window.location='ScheduleBodyServlet?detailSche=<%=list.get(i).getID()%>';">
                        <td> <%= list.get(i).getID()%></td>
                        <td> <%= list.get(i).getPhone() %></td>
                        <td> <%= list.get(i).getNameVaccine() %></td>
                        <td> <%= list.get(i).getDate() %></td>
                        <td> <%= list.get(i).getAddr() %></td>
                        <td> <%= list.get(i).getIndexVac() %></td>
                        <td><input type="checkbox" name="CheckboxList" value=<%= list.get(i).getID()%>></td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </form>
    </div>
</body>

</html>