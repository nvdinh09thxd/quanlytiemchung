package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.Location;
import BEAN.Phuong;
import BEAN.Quan;
import BEAN.StatusLocation;
import BO.ScheAndHistBO;

@WebServlet("/LocationServlet")
public class LocationServlet extends HttpServlet{
	private static final long serialVersionUID =1L;
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		ScheAndHistBO Bo = new ScheAndHistBO();
		String destination =null;
		if(request.getParameter("detailLocation")!=null)
		{
			String idLocation = request.getParameter("detailLocation");
			destination = "/Location/location.jsp";
			ArrayList<Phuong> listP = Bo.GetListPhuong();
			ArrayList<Quan> listQ = Bo.getlistQuan();
			ArrayList<Location> listLocation = Bo.getListLocations();
			ArrayList<StatusLocation> status = Bo.getListStatusLocation();
			request.setAttribute("listP", listP);
			request.setAttribute("listQ", listQ);
			request.setAttribute("IDLocation", idLocation);
			request.setAttribute("listS", status);
			request.setAttribute("shortLocation", listLocation);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(request, response);		
			return;
		}
		else
			if(request.getParameter("updateLocation")!=null)
			{
				destination = "/Location/location.jsp";
				String idLocation = request.getParameter("idlocation");
				String nameLocation = request.getParameter("namelocation");
				String addLocation = request.getParameter("Addrlocation");
				String idP = request.getParameter("PhuongSelect");
				String idsta = request.getParameter("status");
				String num =request.getParameter("num");
				Location temp = new Location(idLocation, nameLocation, addLocation, idP,"", idsta, num);
				Bo.UpdateLocation(temp);
				ArrayList<Phuong> listP = Bo.GetListPhuong();
				ArrayList<Quan> listQ = Bo.getlistQuan();
				ArrayList<Location> listLocation = Bo.getListLocations();
				ArrayList<StatusLocation> status = Bo.getListStatusLocation();
				request.setAttribute("listP", listP);
				request.setAttribute("listQ", listQ);
				request.setAttribute("IDLocation", idLocation);
				request.setAttribute("listS", status);
				request.setAttribute("shortLocation", listLocation);
				RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(request, response);	
				return;
			}
			else
				if(request.getParameter("AddLocation")!=null)
				{
					destination = "/Location/location.jsp";
					String nameLocation = request.getParameter("namelocation");
					String addLocation = request.getParameter("Addrlocation");
					String idP = request.getParameter("PhuongSelect");
					String idsta = request.getParameter("status");
					String City = request.getParameter("City");
					String num = request.getParameter("num");
					Location temp = new Location( "",nameLocation, addLocation, idP,City, idsta, num);
					Bo.AddLocation(temp);
					ArrayList<Phuong> listP = Bo.GetListPhuong();
					ArrayList<Quan> listQ = Bo.getlistQuan();
					ArrayList<Location> listLocation = Bo.getListLocations();
					ArrayList<StatusLocation> status = Bo.getListStatusLocation();
					request.setAttribute("listP", listP);
					request.setAttribute("listQ", listQ);
					request.setAttribute("listS", status);
					request.setAttribute("shortLocation", listLocation);
					RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
					rd.forward(request, response);	
					return;
				}
				else
					if(request.getParameter("DeleteLocation")!=null)
					{
						destination = "/Location/location.jsp";
						String idLocation = request.getParameter("idlocation").toString();		
						Bo.DeleteLocation(idLocation);
						ArrayList<Phuong> listP = Bo.GetListPhuong();
						ArrayList<Quan> listQ = Bo.getlistQuan();
						ArrayList<Location> listLocation = Bo.getListLocations();
						ArrayList<StatusLocation> status = Bo.getListStatusLocation();
						request.setAttribute("listP", listP);
						request.setAttribute("listQ", listQ);
						request.setAttribute("IDLocation", idLocation);
						request.setAttribute("listS", status);
						request.setAttribute("shortLocation", listLocation);
						RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
						rd.forward(request, response);	
						return;
					}
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
}
