package Controller;
import BO.*;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CheckLoginAdminServlet")
public class CheckLoginAdminServlet extends HttpServlet{
	private static final long  serialVersionUID =1L;
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
		
		
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		String destination =null;
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		if(userName==""||passWord=="")
		{
			destination = "Login/LoginAdmin.jsp";
			
			response.sendRedirect(destination);		
			return;
		}
		CheckLoginAdminBO checkLoginBO = new CheckLoginAdminBO();
		if(checkLoginBO.isValidUser(userName, passWord))
		{
			destination = "/Frameset/FrameSet.jsp";
			request.setAttribute("username", userName);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(request, response);
			
		}
		else {
			destination = "Login/LoginAdmin.jsp";
			response.sendRedirect(destination);		
			return;
		}
		
	}
	
}
