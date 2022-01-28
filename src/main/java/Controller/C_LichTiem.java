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

import Model.bean.LichTiem;
import Model.bean.TrangThaiLichTiem;
import Model.bean.Vac_xin;
import Model.bo.B_LichTiem;
@WebServlet("/C_LichTiem")
public class C_LichTiem extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public C_LichTiem() {
	    super();
	    // TODO Auto-generated constructor stub
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		B_LichTiem lichtiem = new B_LichTiem();
		if(request.getParameter("IDSchedule") != null) {
			
			String SDT = request.getParameter("IDSchedule");
			ArrayList<LichTiem> lt;
			try {
				
				lt = lichtiem.GetLichTiemBySDT(SDT);
				ArrayList<String> Namevx = new ArrayList<String>() ;
				ArrayList<String> Namediadiem = new ArrayList<String>() ;
				ArrayList<String> Nametrangthai = new ArrayList<String>() ;
				ArrayList<TrangThaiLichTiem> AllTrangThai = new ArrayList<TrangThaiLichTiem>() ;
				for(LichTiem a : lt) {
					String Name = lichtiem.GetVacXinByID((a.MaVacXin).toString());
					Namevx.add(Name);
					
					
				}
			
				for(LichTiem a : lt) {
					String Name = lichtiem.GetDiaDiemByID((a.MaDiaDiem));
					Namediadiem.add(Name);
					
				}
			
				for(LichTiem a : lt) {
					String Name = lichtiem.GetTrangThaiByID((a.MaTrangThaiLichTiem));
					Nametrangthai.add(Name);
					
				}
				AllTrangThai = lichtiem.getALLTrangThai();
				request.setAttribute("ListDiaDiem", Namediadiem);
				request.setAttribute("ListTrangThai", Nametrangthai);
				request.setAttribute("ListNameVacxin", Namevx);
				request.setAttribute("ListLichTiem", lt);
				request.setAttribute("SDT",SDT);
				request.setAttribute("AllTrangThai", AllTrangThai);
				RequestDispatcher rd1 = getServletContext().getRequestDispatcher("/UserView/U_ViewSchedule.jsp");
				rd1.forward(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		else if(request.getParameter("Submit_Lich") != null) {
			String SDT = request.getParameter("SDT_Schedule");
			String Trangthai = request.getParameter("cbLich");
			ArrayList<LichTiem> lt;
			
			try {
				
				lt = lichtiem.GetLichTiemBySDTandTT(SDT,Trangthai);
				ArrayList<String> Namevx = new ArrayList<String>() ;
				ArrayList<String> Namediadiem = new ArrayList<String>() ;
				ArrayList<String> Nametrangthai = new ArrayList<String>() ;
				ArrayList<TrangThaiLichTiem> AllTrangThai = new ArrayList<TrangThaiLichTiem>() ;
				for(LichTiem a : lt) {
					String Name = lichtiem.GetVacXinByID((a.MaVacXin).toString());
					Namevx.add(Name);
					
					
				}
				System.out.print("OK Lich");
				for(LichTiem a : lt) {
					String Name = lichtiem.GetDiaDiemByID((a.MaDiaDiem));
					Namediadiem.add(Name);
					
				}
			
				for(LichTiem a : lt) {
					String Name = lichtiem.GetTrangThaiByID((a.MaTrangThaiLichTiem));
					Nametrangthai.add(Name);
					
				}
				AllTrangThai = lichtiem.getALLTrangThai();
				request.setAttribute("ListDiaDiem", Namediadiem);
				request.setAttribute("ListTrangThai", Nametrangthai);
				request.setAttribute("ListNameVacxin", Namevx);
				request.setAttribute("ListLichTiem", lt);
				request.setAttribute("AllTrangThai", AllTrangThai);
				request.setAttribute("SDT",SDT);
				RequestDispatcher rd1 = getServletContext().getRequestDispatcher("/UserView/U_ViewSchedule.jsp");
				rd1.forward(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}else if( request.getParameter("ID_DelLich")!= null) {
			String ID = request.getParameter("ID_DelLich");
			
		
		
			
			try {
				lichtiem.DelLich(ID);
				String KQ= "Xoa Thanh Cong";
				request.setAttribute("KQ", KQ);
				RequestDispatcher rd1 = getServletContext().getRequestDispatcher("/UserView/Register_OK.jsp");
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
