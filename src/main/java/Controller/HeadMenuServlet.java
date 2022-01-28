package Controller;
import BO.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.AccountAdmin;
import BEAN.History;
import BEAN.Location;
import BEAN.Phuong;
import BEAN.Quan;
import BEAN.Schedule;
import BEAN.StatusLocation;
import BEAN.StatusSche;
import BEAN.Vaccine;
import BEAN.disease;


@WebServlet("/HeadMenuServlet")
public class HeadMenuServlet extends HttpServlet{
	private static final long  serialVersionUID =1L;
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		ScheAndHistBO Bo = new ScheAndHistBO();
		VaccineBO BoVac = new VaccineBO();
		CheckLoginAdminBO BoAdmin = new CheckLoginAdminBO();
		String destination =null;
		if(request.getParameter("schedule")!=null)
		{
			destination = "/Calendar/Schedule.jsp";
			ArrayList<Schedule> list = Bo.simpleScheBO("1","new");
			ArrayList<StatusSche> sta = Bo.GetListStateScheduleBO();
			request.setAttribute("listSchedule", list);
			request.setAttribute("status", sta);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(request, response);
			
			
			
		}
		else
			if(request.getParameter("address")!=null)
			{
				destination = "/Location/location.jsp";
				ArrayList<Location> listLocation = Bo.getListLocations();
				ArrayList<Phuong> listP = Bo.GetListPhuong();
				ArrayList<Quan> listQ = Bo.getlistQuan();
				ArrayList<StatusLocation> listS = Bo.getListStatusLocation();
				request.setAttribute("shortLocation", listLocation);
				request.setAttribute("listP", listP);
				request.setAttribute("listQ", listQ);
				request.setAttribute("listS", listS);
				RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(request, response);		
				return;
			}
			else
				if(request.getParameter("vaccine")!=null)
				{
					destination = "/Vaccine/Vaccine.jsp";
					ArrayList<Vaccine> listV = BoVac.listVac(); 
					ArrayList<disease> listB = BoVac.listBenh(); 
					request.setAttribute("listV", listV);
					//request.setAttribute("listB", listB);
					request.setAttribute("index", "1");
					RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
					rd.forward(request, response);		
					return;
				}
				else
					if(request.getParameter("history")!=null)
					{
						destination = "/History/history.jsp";
						ArrayList<History> list = Bo.GetListHistoryDetailBO();
						request.setAttribute("listHist", list);
						RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
						rd.forward(request, response);		
						return;
					}
					else
						if(request.getParameter("Admin")!=null)
						{
							destination = "/ManaAdmin/Admin.jsp";
							String userAdmin = request.getParameter("userAdmin");
							ArrayList<AccountAdmin> listA = BoAdmin.listacc(userAdmin);
							request.setAttribute("listA", listA);
							request.setAttribute("userAdmin", userAdmin);
							RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
							rd.forward(request, response);		
							return;
						}
						else
							if(request.getParameter("addAdmin")!=null)
							{
								String user = request.getParameter("user");
								String passw = request.getParameter("pass");
								String userAdmin = request.getParameter("userAdmin");
								
								BoAdmin.addAdmin(user, passw);
								destination = "/ManaAdmin/Admin.jsp";
								ArrayList<AccountAdmin> listA = BoAdmin.listacc(userAdmin);
								request.setAttribute("listA", listA);
								request.setAttribute("userAdmin", userAdmin);
								RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
								rd.forward(request, response);		
								return;
								
							}
							else
								if(request.getParameter("deleteAdmin")!=null)
								{
									String userAdmin = request.getParameter("userAdmin");
									String[] id = request.getParameterValues("listDel");
									BoAdmin.DeleteAcc(id);
									destination = "/ManaAdmin/Admin.jsp";
									ArrayList<AccountAdmin> listA = BoAdmin.listacc(userAdmin);
									request.setAttribute("listA", listA);
									request.setAttribute("userAdmin", userAdmin);
									RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
									rd.forward(request, response);		
									return;
								}
								else
									if(request.getParameter("changePass")!=null)
									{
										
										destination = "/ManaAdmin/changePass.jsp";
										String userAdmin = request.getParameter("userAdmin");
										request.setAttribute("userAdmin", userAdmin);
										RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
										rd.forward(request, response);		
										return;
	
									}
									else
										if(request.getParameter("changePassSub")!=null)
										{
											String userAdmin = request.getParameter("user");
											String oldpass = request.getParameter("oldpass");
											String newpass =request.getParameter("newpass");
											if(BoAdmin.isValidUser(userAdmin, oldpass))
											{
												BoAdmin.ChangePass(userAdmin, newpass);
												destination = "/Calendar/Schedule.jsp";
												ArrayList<Schedule> list = Bo.simpleScheBO("1","new");
												ArrayList<StatusSche> sta = Bo.GetListStateScheduleBO();
												request.setAttribute("listSchedule", list);
												request.setAttribute("status", sta);
												RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
												rd.forward(request, response);
											}
											else
											{
												destination = "/ManaAdmin/changePass.jsp";
												request.setAttribute("userAdmin", userAdmin);
												request.setAttribute("notice","true");
												RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
												rd.forward(request, response);		
												return;
											}
											
										}
					
		
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
		
	}
	
}