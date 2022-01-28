package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.bean.LichSuTiem;
import Model.bo.B_LichTiem;
import Model.bo.B_ViewVacXin;

@WebServlet("/C_ViewVacXin")
public class C_ViewVacXin extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public C_ViewVacXin() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		B_ViewVacXin vacxin = new  B_ViewVacXin();
		B_LichTiem lichtiem = new B_LichTiem();
		if(request.getParameter("IDViewVacXin") != null) {
			String SDT = request.getParameter("IDViewVacXin");
			ArrayList<LichSuTiem> vx ;
			ArrayList<LichSuTiem> vx1 ;
			try {
				vx = vacxin.GetLichSuVacXinBySDT(SDT);
				vx1 = vacxin.GetLichSuVacXinBySDT(SDT);
				ArrayList<String> Namevx = new ArrayList<String>();
				ArrayList<String> Namevxall = new ArrayList<String>();
				ArrayList<String> idvac	= new ArrayList<String>();
				for(LichSuTiem a : vx) {
					String Name = lichtiem.GetVacXinByID((a.MaVacXin).toString());					
					Namevx.add(Name);
				
				}
				for(LichSuTiem a : vx1) {
					String Name = lichtiem.GetVacXinByID((a.MaVacXin).toString());
					boolean check = true;
					for(int i =0 ; i<Namevxall.size();i++)
					{
						if(Name.equals(Namevxall.get(i)))
						{
							check = false;
						}
						
					}
					if(check)
						Namevxall.add(Name);
				
				}
				for(LichSuTiem a : vx1) {
					String Name = a.MaVacXin;
					boolean check = true;
					for(int i =0 ; i<idvac.size();i++)
					{
						if(Name.equals(idvac.get(i)))
						{
							check = false;
						}
						
					}
					if(check)
						idvac.add(Name);
				
				}
				
				request.setAttribute("idvac", idvac);
				request.setAttribute("ListNameVacxin", Namevx);
				request.setAttribute("ListVacXin", vx);
				request.setAttribute("SDT", SDT);
				request.setAttribute("ListVacXin1", vx1);
				request.setAttribute("ListNameVacxinall", Namevxall);
				RequestDispatcher rd1 = getServletContext().getRequestDispatcher("/UserView/U_ViewVacxin.jsp");
				rd1.forward(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}else if(request.getParameter("Submit_VacXin") != null) {
			String SDT = request.getParameter("SDT_Schedule");
			String Trangthai = request.getParameter("cbLich");
			ArrayList<LichSuTiem> vx ;
			ArrayList<LichSuTiem> vx1 ;
			try {
				vx = vacxin.GetLichSuVacXinBySDTandTT(SDT,Trangthai);
				vx1 = vacxin.GetLichSuVacXinBySDT(SDT);
				ArrayList<String> Namevx = new ArrayList<String>() ;
				ArrayList<String> Namevxall = new ArrayList<String>() ;
				ArrayList<String> idvac	= new ArrayList<String>();
				for(LichSuTiem a : vx) {
					String Name = lichtiem.GetVacXinByID((a.MaVacXin).toString());
					Namevx.add(Name);
				
				}
				for(LichSuTiem a : vx1) {
					String Name = lichtiem.GetVacXinByID((a.MaVacXin).toString());
					boolean check = true;
					for(int i =0 ; i<Namevxall.size();i++)
					{
						if(Name.equals(Namevxall.get(i)))
						{
							check = false;
						}
						
					}
					if(check)
						Namevxall.add(Name);
				
				}
				for(LichSuTiem a : vx1) {
					String Name = a.MaVacXin;
					boolean check = true;
					for(int i =0 ; i<idvac.size();i++)
					{
						if(Name.equals(idvac.get(i)))
						{
							check = false;
						}
						
					}
					if(check)
						idvac.add(Name);
				
				}
				
				request.setAttribute("idvac", idvac);
				request.setAttribute("ListNameVacxin", Namevx);
				request.setAttribute("ListNameVacxinall", Namevxall);
				request.setAttribute("ListVacXin", vx);
				request.setAttribute("ListVacXin1", vx1);
				request.setAttribute("SDT", SDT);
				RequestDispatcher rd1 = getServletContext().getRequestDispatcher("/UserView/U_ViewVacxin.jsp");
				rd1.forward(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
}
