package Controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.Schedule;
import BEAN.StatusSche;
import BO.ScheAndHistBO;

@WebServlet("/ScheduleBodyServlet")
public class ScheduleBodyServlet extends HttpServlet{
	private static final long  serialVersionUID =1L;
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		String destination =null;
		ScheAndHistBO bo = new ScheAndHistBO();
		if(request.getParameter("detailSche")!=null)
		{
			destination ="/Calendar/DetailSche.jsp";
			String a = request.getParameter("detailSche");
			Schedule item = bo.DetailScheBO(a);
			request.setAttribute("schedule", item);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(request, response);
			return;
		}
		else
			if(request.getParameter("updateDate")!=null)
			{
				 String date = request.getParameter("bdate");
				 String id = request.getParameter("IDSche");
				 String option="";
					if(request.getParameter("selectOption2")!=null)
					option = request.getParameter("selectOption2");
				 bo.UpdateScheBO(id, java.sql.Date.valueOf(date));
				 ArrayList<StatusSche> sta = bo.GetListStateScheduleBO();
				 destination = "/Calendar/Schedule.jsp";
				ArrayList<Schedule> list = bo.simpleScheBO("1",option);
				request.setAttribute("option", option);
				request.setAttribute("listSchedule", list);
				request.setAttribute("status", sta);
				RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(request, response);
				return;
			}
			else
				if(request.getParameter("selectOption")!=null)
				{
					String idsta = request.getParameter("selectOption");
					String option="";
					if(request.getParameter("selectOption2")!=null)
					option = request.getParameter("selectOption2");
					ArrayList<Schedule> list = bo.simpleScheBO(idsta,option);
					request.setAttribute("option", option);
					destination = "/Calendar/Schedule.jsp";
					ArrayList<StatusSche> sta = bo.GetListStateScheduleBO();
					
					request.setAttribute("index", idsta);
					request.setAttribute("status", sta);
					request.setAttribute("listSchedule", list);
					RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
					rd.forward(request, response);
					return;
				}
				else
					if(request.getParameter("DeleteSche")!=null)
					{
						String[] listidSche = request.getParameterValues("CheckboxList");
						String option="";
						if(request.getParameter("selectOption2")!=null)
						option = request.getParameter("selectOption2");
						bo.DeleteScheBO(listidSche);
						ArrayList<StatusSche> sta = bo.GetListStateScheduleBO();
						ArrayList<Schedule> list = bo.simpleScheBO("1",option);
						destination = "/Calendar/Schedule.jsp";
						request.setAttribute("option", option);
						request.setAttribute("listSchedule", list);
						request.setAttribute("status", sta);
						RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
						rd.forward(request, response);
						return;
					}
					else
						if(request.getParameter("DoneSche")!=null)
						{
							String[] listidSche = request.getParameterValues("CheckboxList");
							bo.UpdateStatusScheBO(listidSche,"5");					
							String option="";
							if(request.getParameter("selectOption2")!=null)
							option = request.getParameter("selectOption2");
							destination = "/Calendar/Schedule.jsp";
							ArrayList<StatusSche> sta = bo.GetListStateScheduleBO();
							ArrayList<Schedule> list = bo.simpleScheBO("1",option);
							request.setAttribute("option", option);
							request.setAttribute("listSchedule", list);
							request.setAttribute("status", sta);
							RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
							rd.forward(request, response);
							return;
						}
						else
							if(request.getParameter("AcceptSche")!=null)
							{
								String[] listidSche = request.getParameterValues("CheckboxList");
								bo.UpdateStatusScheBO(listidSche,"4");		
								String option ="";
								if(request.getParameter("selectOption2")!=null)
								option = request.getParameter("selectOption2");
								destination = "/Calendar/Schedule.jsp";
								ArrayList<StatusSche> sta = bo.GetListStateScheduleBO();
								ArrayList<Schedule> list = bo.simpleScheBO("1",option);
								request.setAttribute("option", option);
								request.setAttribute("listSchedule", list);
								request.setAttribute("status", sta);
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
