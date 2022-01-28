package Controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.History;
import BO.*;

@WebServlet("/HistoryBody")
public class HistoryBody extends HttpServlet{
	private static final long  serialVersionUID =1L;
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		String destination =null;
		ScheAndHistBO bo = new ScheAndHistBO();
		if(request.getParameter("deletebutton")!=null)
		{
			String[] a = request.getParameterValues("checkboxHist");
			bo.DeleteHist(a);
			destination = "/History/history.jsp";
			ArrayList<History> list = bo.GetListHistoryDetailBO();
			request.setAttribute("listHist", list);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(request, response);	
			
		}
		else
			if(request.getParameter("searchButton")!=null)
			{
				String info=null;
				String  date=null;
				destination = "/History/history.jsp";
				if(request.getParameter("info")!=null&&request.getParameter("info")!="")
				{
					info = request.getParameter("info");
				}
				if(request.getParameter("dateInput")!=null)
				{
					date = request.getParameter("dateInput");
				}
				 
				if(info!=null&&date!=null&&info!=""&&date!="")
				{
					ArrayList<History> list = bo.GetListHistoryDetailBO(info,java.sql.Date.valueOf(date));
					request.setAttribute("listHist", list);
					RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
					rd.forward(request, response);
				}
				else
					if(date!=null&&date!="")
					{
						ArrayList<History> list = bo.GetListHistoryDetailBO(java.sql.Date.valueOf(date));
						request.setAttribute("listHist", list);
						RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
						rd.forward(request, response);
					}
					else
						if(info!=null&&info!="")
						{
							ArrayList<History> list = bo.GetListHistoryDetailBO(info);
							request.setAttribute("listHist", list);
							RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
							rd.forward(request, response);
						}
						else
						{
							ArrayList<History> list = bo.GetListHistoryDetailBO();
							request.setAttribute("listHist", list);
							RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
							rd.forward(request, response);
						}
				
			}
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
}
