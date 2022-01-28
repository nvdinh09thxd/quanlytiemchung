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

import BEAN.Phuong;
import BEAN.Quan;
import BO.ScheAndHistBO;
import Model.bo.B_Login;
import Model.bean.Client;
@WebServlet("/C_Login")
public class C_Login extends HttpServlet{
	private static final long serialVersionUID =1L;
	public C_Login() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		B_Login login = new B_Login();
		ScheAndHistBO TrungBo = new ScheAndHistBO();
		if( request.getParameter("SubmitLogin") != null) {
			String SDT = request.getParameter("SDT") ;
			
		
			String PassWord = request.getParameter("PassWord");
			
			if((login.CheckLogin(SDT, PassWord))) {
			
				Client client;
				try {
					client = login.GetUserBySDT(SDT);
					String UserName = client.Ten;
					String SDTUser = client.SDT ;
					String CMND = client.CMND;
					request.setAttribute("UserName",UserName);
					request.setAttribute("SDTUser",SDTUser);
					request.setAttribute("CMND",CMND);
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/UserView/index.jsp");
					rd.forward(request, response);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				
			}
			else {
				String destination = "UserView/Login.jsp";
				response.sendRedirect(destination);		
				return;
			}
		}
		else
			if(request.getParameter("DangKyTK")!=null)
			{
				ArrayList<Phuong> listP = TrungBo.GetListPhuong();
				ArrayList<Quan> listQ = TrungBo.getlistQuan();
				request.setAttribute("listP",listP);
				request.setAttribute("listQ",listQ);
				String destination = "/UserView/DangKyTK.jsp";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(request, response);
				return;
			}
			else
				if(request.getParameter("registerAC")!=null) {
					String name = request.getParameter("Name");
					String sdt = request.getParameter("Sdt");
					String cmnd = request.getParameter("Cmnd");
					String idy = request.getParameter("Idy");
					String date = request.getParameter("Date");
					String addr = request.getParameter("addr");
					String idP = request.getParameter("PhuongSelect");
					String passw = request.getParameter("passw");
				
					if(login.CheckSDTExit(sdt))
					{
						login.addAC(sdt, name, cmnd, idy, date, addr, idP, passw);
						String destination = "UserView/Login.jsp";
						response.sendRedirect(destination);		
						return;
					}
					else
					{
						ArrayList<Phuong> listP = TrungBo.GetListPhuong();
						ArrayList<Quan> listQ = TrungBo.getlistQuan();
						request.setAttribute("listP",listP);
						request.setAttribute("listQ",listQ);
						request.setAttribute("notice", "true");
						String destination = "/UserView/DangKyTK.jsp";
						RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
						rd.forward(request, response);
						return;
					}
				}
	}
}
