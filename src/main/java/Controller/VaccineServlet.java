package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.PhongBenh;
import BEAN.Vaccine;
import BEAN.disease;
import BO.VaccineBO;

@WebServlet("/VaccineServlet")
public class VaccineServlet extends HttpServlet{
	private static final long  serialVersionUID =1L;
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		VaccineBO BoVac = new VaccineBO();
		String destination =null;
		if(request.getParameter("PhongBenh")!=null)
		{
			ArrayList<PhongBenh> listPB = BoVac.listPhongBenh();
			ArrayList<Vaccine> listV = BoVac.listVac(); 
			ArrayList<disease> listB = BoVac.listBenh(); 
			destination = "/PhongBenh/PhongBenh.jsp";
			request.setAttribute("listB", listB);
			request.setAttribute("listV", listV);
			request.setAttribute("listPB", listPB);
			request.setAttribute("index", "3");
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(request, response);		
			return;
		}
		else
			if(request.getParameter("Benh")!=null)
			{
				ArrayList<disease> listB = BoVac.listBenh();
				destination = "/Vaccine/Benh.jsp";
				request.setAttribute("listB", listB);
				request.setAttribute("index", "2");
				RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(request, response);		
				return;
			
			}
			else
				if(request.getParameter("Vaccine")!=null)
				{
					destination = "/Vaccine/Vaccine.jsp";
					ArrayList<Vaccine> listV = BoVac.listVac(); 
					ArrayList<disease> listB = BoVac.listBenh(); 
					request.setAttribute("listV", listV);
					request.setAttribute("index", "1");
					RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
					rd.forward(request, response);		
					return;
				}
				else
					if(request.getParameter("addPhongBenh")!=null)
					{
						String IDVac = request.getParameter("CBVac");
						String IDB = request.getParameter("CBB");
						BoVac.AddPhongBenh(IDVac, IDB);
						ArrayList<PhongBenh> listPB = BoVac.listPhongBenh();
						ArrayList<Vaccine> listV = BoVac.listVac(); 
						ArrayList<disease> listB = BoVac.listBenh(); 
						destination = "/PhongBenh/PhongBenh.jsp";
						request.setAttribute("listB", listB);
						request.setAttribute("listV", listV);
						request.setAttribute("listPB", listPB);
						request.setAttribute("index", "3");
						RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
						rd.forward(request, response);		
						return;
					}
					else
						if(request.getParameter("deletePB")!=null)
						{
							String[] listPBDel= request.getParameterValues("listPBDel"); 
							BoVac.DeletePB(listPBDel);
							ArrayList<PhongBenh> listPB = BoVac.listPhongBenh();
							ArrayList<Vaccine> listV = BoVac.listVac(); 
							ArrayList<disease> listB = BoVac.listBenh(); 
							destination = "/PhongBenh/PhongBenh.jsp";
							request.setAttribute("listB", listB);
							request.setAttribute("listV", listV);
							request.setAttribute("listPB", listPB);
							request.setAttribute("index", "3");
							RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
							rd.forward(request, response);		
							return;
						}
						else
							if(request.getParameter("detailVac")!=null)
							{
								destination = "/Vaccine/DetailVaccine.jsp";
								String mavc = request.getParameter("detailVac");
								Vaccine list = BoVac.getVac(mavc);
								ArrayList<disease> listB = BoVac.listBenh(mavc);
								request.setAttribute("list", list);
								request.setAttribute("listB", listB);
								request.setAttribute("index", "1");
								RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
								rd.forward(request, response);		
								return;
							}
							else
								if(request.getParameter("updateVac")!=null)
								{
									String id = request.getParameter("id");
									String name = request.getParameter("name");
									String num = request.getParameter("num").toString();
									String nextday = request.getParameter("nextdate").toString();
									String dec = request.getParameter("dec");
									BoVac.UpdateVac(id, name, num, nextday, dec);
									destination = "/Vaccine/Vaccine.jsp";
									ArrayList<Vaccine> listV = BoVac.listVac(); 
									ArrayList<disease> listB = BoVac.listBenh(); 
									request.setAttribute("listV", listV);
									request.setAttribute("index", "1");
									RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
									rd.forward(request, response);		
									return;
								}
								else
									if(request.getParameter("addvaccine")!=null)
									{
										destination = "/Vaccine/AddVaccine.jsp";
										ArrayList<Vaccine> listV = BoVac.listVac(); 
										request.setAttribute("listV", listV);
										request.setAttribute("index", "1");
										RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
										rd.forward(request, response);		
										return;
									}
									else
										if(request.getParameter("addVac")!=null)
										{
											String id = request.getParameter("id").toUpperCase();
											String name = request.getParameter("name");
											String num = request.getParameter("num").toString();
											String nextday = request.getParameter("next").toString();
											String dec = request.getParameter("dec");
											BoVac.AddVac(id, name, num, nextday, dec);
											destination = "/Vaccine/Vaccine.jsp";
											ArrayList<Vaccine> listV = BoVac.listVac(); 
											ArrayList<disease> listB = BoVac.listBenh(); 
											request.setAttribute("listV", listV);
											request.setAttribute("index", "1");
											RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
											rd.forward(request, response);		
											return;
										}
										else
											if(request.getParameter("deleteVac")!=null)
											{
												String[] id = request.getParameterValues("ListDel");
												BoVac.DeleteVac(id);
												destination = "/Vaccine/Vaccine.jsp";
												ArrayList<Vaccine> listV = BoVac.listVac(); 
												ArrayList<disease> listB = BoVac.listBenh(); 
												request.setAttribute("listV", listV);
												request.setAttribute("index", "1");
												RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
												rd.forward(request, response);		
												return;
											}
											else
												if(request.getParameter("addBenh")!=null)
												{
													ArrayList<disease> listB = BoVac.listBenh();
													destination = "/Vaccine/AddBenh.jsp";
													request.setAttribute("listB", listB);
													request.setAttribute("index", "2");
													RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
													rd.forward(request, response);		
													return;
												}
												else
													if(request.getParameter("detailBenh")!=null)
													{
														String id =request.getParameter("detailBenh");
														ArrayList<disease> listB = BoVac.listBenh();
														disease B = BoVac.GetBenh(id);
														destination = "/Vaccine/AddBenh.jsp";
														request.setAttribute("B", B);
														request.setAttribute("listB", listB);
														request.setAttribute("index", "2");
														RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
														rd.forward(request, response);		
														return;
													}
													else
														if(request.getParameter("ADDBENH")!=null)
														{
															String name = request.getParameter("nameBenh");
															String des = request.getParameter("decBenh");
															BoVac.addBenh(name, des);
															ArrayList<disease> listB = BoVac.listBenh();
															destination = "/Vaccine/Benh.jsp";
															request.setAttribute("listB", listB);
															request.setAttribute("index", "2");
															RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
															rd.forward(request, response);		
															return;
														}
														else
															if(request.getParameter("updateBenh")!=null)
															{
																String id = request.getParameter("idBenh");
																String name = request.getParameter("nameBenh");
																String des = request.getParameter("decBenh");
																BoVac.updateBenh(id, name, des);
																ArrayList<disease> listB = BoVac.listBenh();
																destination = "/Vaccine/Benh.jsp";
																request.setAttribute("listB", listB);
																request.setAttribute("index", "2");
																RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
																rd.forward(request, response);		
																return;
															}
															else
																if(request.getParameter("deleteBenh")!=null)
																{
																	String[] id = request.getParameterValues("ListDelBenh");
																	BoVac.DeleteBenh(id);
																	ArrayList<disease> listB = BoVac.listBenh();
																	destination = "/Vaccine/Benh.jsp";
																	request.setAttribute("listB", listB);
																	request.setAttribute("index", "2");
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
