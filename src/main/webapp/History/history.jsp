<%@page import="BEAN.History"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="styleSheet" href="<%= request.getContextPath() %>/History/history.css">
</head>

<body>
    <div class="title_schedule">
    <img alt="" src="<%=request.getContextPath()%>/image/history.png">
        <h2>Lịch sử tiêm</h2>
    </div>

    <div class="content">

        <form action="HistoryBody" method="get">
            <div class="search">
                <input type="submit" name="searchButton" value="Tìm kiếm" class="">
                <input type="text" name="info" value="" class="" placeholder="Thông tin tìm kiếm">
                <input type="date" name="dateInput" value="" class="datePicker">
            </div>
        </form>
        <form class="form_schedule" action="HistoryBody" method="get">
            <div class="submitbutton">
                <input type="submit" value="Xóa" class="deletebutton" name="deletebutton">
            </div>
            <br>
            <br>
            <table class="table_accountUser">

                <thead>

                    <tr class="head_table">
                        <th>Mã</th>
                        <th>Số điện thoại</th>
                        <th>Tên vaccine</th>
                        <th>Ngày tiêm</th>
                        <th>Mũi thứ</th>
                        <th>Chọn</th>

                    </tr>

                </thead>

                <tbody>
                <%	ArrayList<History> list = (ArrayList<History>)request.getAttribute("listHist");
                for(int i=0;i<list.size();i++)
                {
                %>
                    <tr class="detail_schedule" >
                        <td><%= list.get(i).getIDHist() %></td>
                        <td><%= list.get(i).getCMND() %></td>
                        <td><%= list.get(i).getNameVac() %></td>
                        <td><%= list.get(i).getDate() %>/2021</td>
                        <td><%= list.get(i).getNum() %></td>
                        <td><input type="checkbox" value="<%=list.get(i).getIDHist() %>" name="checkboxHist"></td>
                    </tr>
			  <%} %>
                </tbody>
            </table>
        </form>
    </div>
</body>

</html>