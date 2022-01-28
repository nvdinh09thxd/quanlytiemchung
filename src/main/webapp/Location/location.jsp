<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="BEAN.StatusLocation"%>
<%@page import="BEAN.Phuong"%>
<%@page import="BEAN.Quan"%>
<%@page import="BEAN.Location"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>Đăng nhập SSKDT</title>
    <meta charset="UTF-8">
    <link rel="styleSheet" href="<%= request.getContextPath() %>/Location/location.css">
    <script>
        function activea(tena) {
            document.getElementById(tena).click();

        }
        
    </script>
</head>

<body class="background_body">
    <div class="title">
        <h2>Địa điểm tiêm vaccine</h2>
    </div>
    <div class="row">
    <%	ArrayList<Location> listLo = (ArrayList<Location>)request.getAttribute("shortLocation");
		String ida = null;
		if(request.getAttribute("IDLocation")!=null)
			ida=request.getAttribute("IDLocation").toString();
		ArrayList<Phuong> listP = null;
		if((ArrayList<Phuong>)request.getAttribute("listP")!=null)
			listP = (ArrayList<Phuong>)request.getAttribute("listP");
		ArrayList<Quan> listQ = null;
		if((ArrayList<Quan>)request.getAttribute("listQ")!=null)
			listQ=(ArrayList<Quan>)request.getAttribute("listQ");
		ArrayList<StatusLocation> listS = null;
		if((ArrayList<StatusLocation>)request.getAttribute("listS")!=null)
			listS = (ArrayList<StatusLocation>)request.getAttribute("listS");
		Location locationItem=null;
		if(ida!=null&&ida!="")
		{
			for(Location a :listLo)
			{
				if(a.getIDLocation().equals(ida))
					{locationItem = a;
					break;
					}
			}
		}
        %>
        <div class="column left">

            <div class="location">
            <div class="location_item_button">
                    <button onclick="AddLocation()"><img src="<%= request.getContextPath() %>/image/location.png"></button>     
                </div> 
            <%for(int i =0;i<listLo.size();i++)
            	{
            	String active ="";
            	if(ida!=null&&ida.equals(listLo.get(i).getIDLocation()))
            	{
            	 active ="active";            	 
            	}
            	%>
                <div class="location_item <%=active %>" onclick="activea('a<%= listLo.get(i).getIDLocation()%>')">
                    <img src="<%= request.getContextPath() %>/image/map.png">
                    <div></div>
                    <a class='<%=active %>a' href="LocationServlet?detailLocation=<%= listLo.get(i).getIDLocation() %>" id="a<%= listLo.get(i).getIDLocation()%>"><%= listLo.get(i).getNameLocation() %></a>
                </div> 
                <%} %>     
            </div>
        </div>
        <div class="column right" id="right">
        <% if(locationItem!=null)
        	{%>
            <form class="form_location" id="formlocation" name="formsubmit" action="LocationServlet" method="get" onsubmit="CheckFormIsValid(event)">
                <h2 id="titleLoc"><%= locationItem.getNameLocation() %></h2>
                
                <div class="item">
                    <label for="name" id="labelforIDLocation">Mã địa điểm <span>*</span></label>
                    <div class="input_form">
                        <input class="input_form_input" type="text" value="<%= locationItem.getIDLocation() %>" id="idlocation" name="idlocation" placeholder="Để trống" readonly />
                    </div>
                </div>
                <div class="item">
                    <label for="name">Tên<span>*</span></label>
                    <div class="input_form">
                        <input class="input_form_input" type="text" value="<%= locationItem.getNameLocation() %>" name="namelocation" placeholder="Tên địa điểm" />
                    </div>
                </div>
                <div class="item">
                    <label for="name">Đường/Số nhà<span>*</span></label>
                    <div class="input_form">
                        <input class="input_form_input" type="text" value="<%= locationItem.getAddress() %>" name="Addrlocation" placeholder="Tên đường , số nhà ..." />
                    </div>
                </div>
                <div class="item">
                    <label for="name">Quận<span>*</span></label>
                    <div class="input_form">
                        <select class="input_form_select" name="QuanSelect" id="QuanSelect" onchange="lastLoad(document.getElementById('QuanSelect').value)">
                        <% for(int i =0 ;i<listQ.size();i++)
                        	{
                        	String select="";
                        	if(listQ.get(i).getIDQuan().equals(locationItem.getIDQuan()))
                        		select="selected";
                        	%>
                            <option value="<%=listQ.get(i).getIDQuan()%>" <%=select %>><%=listQ.get(i).getNameQuan() %></option>
                            <%} %>
                        </select>
                    </div>
                </div>
                <div class="item">
                    <label for="name">Phường<span>*</span></label>
                    <div class="input_form">
                        <select class="input_form_select" name="PhuongSelect" id="PhuongSelect">
                        <% for(int i=0;i<listP.size();i++)
                        	{
                        		String check = "";
                        		if(listP.get(i).getIDQuan().equals(locationItem.getIDQuan()))
                        		{
                        			if(listP.get(i).getIDPhuong().equals(locationItem.getIDPhuong()))
                        				check ="selected";
                        	%>
                        		<option value="<%= listP.get(i).getIDPhuong()%>" <%=check %>><%=listP.get(i).getNamePhuong() %></option>
                        	<%}} %>
                        </select>
                    </div>
                </div>
                <script type="text/javascript">
                   	function lastLoad(idQ)
                   	{
                   		var sel = document.getElementById('PhuongSelect');
                        while(sel.lastChild)
                        {
                            sel.removeChild(sel.lastChild);
                        }
                        <% 
							for(int i =0;i<listP.size();i++)
							{
							
							%>
							if(idQ==<%=listP.get(i).getIDQuan()%>)
								{
								var opt = document.createElement('option');
  					          	opt.value = '<%= listP.get(i).getIDPhuong()%>'; 
  					            opt.appendChild( document.createTextNode('<%=listP.get(i).getNamePhuong()%>') );
  							    sel.appendChild(opt);
								}
							<%}%>
                        
                   	}
                   	function AddLocation() {
                   		var elementform = document.forms["formsubmit"].getElementsByTagName("input");
                        for( i =0;i<elementform.length;i++)
                        {
                            if(elementform[i].type=='text'||elementform[i].type=='number')
                            {
                                elementform[i].value="";
                            }
                        }
                        document.getElementById('City').value = 'Đà Nẵng';
                        var buttonsm = document.getElementById("updateLocation");
                        buttonsm.setAttribute('name','AddLocation');
                        buttonsm.value ='Thêm địa điểm';
                        document.getElementById('DeleteLocation').remove();
                        document.getElementById('idlocation').remove();
                        document.getElementById('labelforIDLocation').remove();
                        document.getElementById('titleLoc').removeChild(document.getElementById('titleLoc').lastChild);
                        document.getElementById('titleLoc').appendChild( document.createTextNode('Location') );
            		}
                   	function CheckFormIsValid(event)
                   	{
                         var elementform = document.forms["formsubmit"].getElementsByTagName("input");
                         for( i =0;i<elementform.length;i++)
                         {
                             if(null==elementform[i].value||''==elementform[i].value)
                             {
                                alert('Hãy nhập đầy đủ thông tin cần thiết cho địa điểm');
                                event.preventDefault();
                                break;
                             }
                         }

                        
                   	}
                   	function ConfirmDel()
                   	{
                   		var agree=confirm("Are you sure you wish to continue?");
                   		if (agree)
                   		 return true ;
                   		else
                   		 return false ;
                   	}
						</script>
						
                <div class="item">
                    <label for="name">Thành phố<span>*</span></label>
                    <div class="input_form">
                        <input class="input_form_input" type="text" value="<%= locationItem.getCity() %>" id="City" name="City" placeholder="" readonly/>
                    </div>
                </div>
                
                <% for(int i = 0 ;i<listS.size();i++)
                	{
                		String select="";
                		if(listS.get(i).getIDStatus().equals(locationItem.getIDStatus()))
                			select="checked";
                	%>
                	<div class="item_radio">
                    <div>
                    <label><%=listS.get(i).getNameStatus() %></label>
                    <input type="radio" name="status" value="<%=listS.get(i).getIDStatus()%>" <%=select %>>
                    </div>
                    </div>
                    <%} %>
                    <div class="item">
                    <label for="name">Số lượt đăng ký/Ngày<span>*</span></label>
                    <div class="input_form">
                        <input class="input_form_input" type="number" value="<%=Integer.parseInt(locationItem.getNum()) %>" name="num" />
                    </div>
                </div>
                <div class="item_submit">
                    <input type="submit" value="Cập nhật địa điểm" id="updateLocation" name="updateLocation" class="item_submit_s" >
                    <input type="submit" value="Xóa" id="DeleteLocation" name="DeleteLocation" class="item_submit_del" onclick="return ConfirmDel()">
                </div>
            </div>
            </form>
            <%} 
            else
            {%>
            <form onsubmit="CheckFormIsValid(event)" class="form_location" id="formlocation" name="formsubmit" action="LocationServlet" method="get" >
                <h2>Location</h2>
                
                
                <div class="item">
                    <label for="name">Tên<span>*</span></label>
                    <div class="input_form">
                        <input class="input_form_input" type="text" value="" name="namelocation" placeholder="Tên địa điểm" />
                    </div>
                </div>
                <div class="item">
                    <label for="name">Đường/Số nhà<span>*</span></label>
                    <div class="input_form">
                        <input class="input_form_input" type="text" value="" name="Addrlocation" placeholder="Tên đường , số nhà ..." />
                    </div>
                </div>
                <div class="item">
                    <label for="name">Quận<span>*</span></label>
                    <div class="input_form">
                        <select class="input_form_select" name="QuanSelect" id="QuanSelect" onchange="lastLoad(document.getElementById('QuanSelect').value)">
                        <% for(int i =0 ;i<listQ.size();i++)
                        	{
                        	%>
                            <option value="<%=listQ.get(i).getIDQuan()%>" ><%=listQ.get(i).getNameQuan() %></option>
                            <%} %>
                        </select>
                    </div>
                </div>
                <div class="item">
                    <label for="name">Phường<span>*</span></label>
                    <div class="input_form">
                        <select class="input_form_select" name="PhuongSelect" id="PhuongSelect">
                        <% for(int i=0;i<listP.size();i++)
                        	{
                        	%>
                        		<option value="<%= listP.get(i).getIDPhuong()%>"><%=listP.get(i).getNamePhuong() %></option>
                        	<%
                        	}
                        	%>
                        </select>
                    </div>
                </div>
         <script type="text/javascript">
                   	function lastLoad(idQ)
                   	{
                   		var sel = document.getElementById('PhuongSelect');
                        while(sel.lastChild)
                        {
                            sel.removeChild(sel.lastChild);
                        }
                        <% 
							for(int i =0;i<listP.size();i++)
							{
							
							%>
							if(idQ==<%=listP.get(i).getIDQuan()%>)
								{
								var opt = document.createElement('option');
  					          	opt.value = '<%= listP.get(i).getIDPhuong()%>'; 
  					            opt.appendChild( document.createTextNode('<%=listP.get(i).getNamePhuong()%>') );
  							    sel.appendChild(opt);
								}
							<%}%>
                        
                   	}
                   	function AddLocation() {
                   		var elementform = document.forms["formsubmit"].getElementsByTagName("input");
                        for( i =0;i<elementform.length;i++)
                        {
                            if(elementform[i].type=='text'||elementform[i].type=='number')
                            {
                                elementform[i].value="";
                            }
                        }
                        document.getElementById('City').value = 'Đà Nẵng';
                        var buttonsm = document.getElementById("updateLocation");
                        buttonsm.setAttribute('name','AddLocation');
                        buttonsm.value ='Thêm địa điểm';
                        document.getElementById('DeleteLocation').remove();
                        document.getElementById('idlocation').remove();
                        document.getElementById('labelforIDLocation').remove();
                        document.getElementById('titleLoc').removeChild(document.getElementById('titleLoc').lastChild);
                        document.getElementById('titleLoc').appendChild( document.createTextNode('Location') );
            		}
                   	function CheckFormIsValid(event)
                   	{
                         var elementform = document.forms["formsubmit"].getElementsByTagName("input");
                         for( i =0;i<elementform.length;i++)
                         {
                             if(null==elementform[i].value||''==elementform[i].value)
                             {
                                alert('Hãy nhập đầy đủ thông tin cần thiết cho địa điểm');
                                event.preventDefault();
                                break;
                             }
                         }

                        
                   	}
                   	
						</script>
                <div class="item">
                    <label for="name">Thành phố<span>*</span></label>
                    <div class="input_form">
                        <input class="input_form_input" type="text" value="Đà Nẵng" id="City" name="City" placeholder="" readonly/>
                    </div>
                </div>
                
                <% for(int i = 0 ;i<listS.size();i++)
                	{
                	%>
                	<div class="item_radio">
                    <div>
                    <label><%=listS.get(i).getNameStatus() %></label>
                    <input type="radio" name="status" value="<%=listS.get(i).getIDStatus() %>" >
                    </div>
                    </div>
                    <%
                    } 
                    %>
                    <div class="item">
                    <label for="name">Số lượt đăng ký/Ngày<span>*</span></label>
                    <div class="input_form">
                        <input class="input_form_input" type="number" value="" name="num" />
                    </div>
                </div>
                <div class="item_submit">
                    <input type="submit" value="Thêm địa điểm" id="updateLocation" name="AddLocation" class="item_submit_s" >
    
                </div>
            </div>
            </form>
            <%} %>
        </div>
    </div>
</body>

</html>