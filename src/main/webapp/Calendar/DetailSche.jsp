<%@page import="BEAN.Schedule"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>Chi tiết lịch tiêm</title>
    <meta charset="UTF-8">
    <link rel="styleSheet" href="<%= request.getContextPath() %>/Calendar/DetailSche.css">
</head>

<body>
<% Schedule item = (Schedule)request.getAttribute("schedule"); %>
    <div class="testbox">
      <form action="ScheduleBodyServlet" method="get">
        <div class="item">
          <label for="name">Mã lịch tiêm <span>*</span></label>
          <div class="name-item">
            <input id="name" type="text" name="IDSche" placeholder="First" readonly value="<%= item.getID() %>" />
          </div>
        </div>
        <div class="item">
          <label for="email">Mã khách hàng<span>*</span></label>
          <br>
          <input id="email" type="text" name="email" value="<%= item.getPhone() %>" readonly />
        </div>
        <div class="item">
          <label for="bdate">Ngày hẹn</label>
          <br>
          <input id="bdate" type="date" name="bdate" value="<%= item.getDate() %>"  required/>
          <i class="fas fa-calendar-alt"></i>
        </div>
        
        <div class="item">
          <div class="name-item">
            <div>
              <label for="monday">Mã vaccine<span>*</span></label>
              <input id="monday" type="text" name="name" value="<%= item.getIDVaccine() %>" readonly />
            </div>
            <div>
              <label for="tuesday">Địa chỉ<span>*</span></label>
              <input id="tuesday" type="text" name="name" value="<%= item.getAddr() %>" readonly />
            </div>
          </div>
        </div>
        <div class="item">
          <div class="name-item">
            <div>
              <label for="wednesday">Trạng thái lịch tiêm</label>
              <input id="wednesday" type="text" name="name" value="<%= item.getStatus() %>" readonly />
            </div>
            <div>
              <label for="thursday">Tên vaccine</label>
              <input id="thursday" type="text" name="name" value="<%= item.getNameVaccine() %>" readonly />
            </div>
          </div>
        </div>
        
        <div class="item">
          <label for="comment">Mô tả vaccine</label>
          <textarea id="comment" rows="3" readonly><%= item.getDescVaccine() %></textarea>
        </div>
        <div class="btn-block">
          <button type="submit" name="updateDate">Cập nhật ngày hẹn</button>
        </div>
      </form>
    </div>
  </body>

</html>