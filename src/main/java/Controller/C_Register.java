package Controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.bean.Benh;
import Model.bean.DiaDiem;
import Model.bean.LichSuTiem;
import Model.bean.PhongBenh;
import Model.bean.Phuong;
import Model.bean.Quan;
import Model.bean.Vac_xin;
import Model.bo.B_Register;
import Model.dao.D_LichTIem;

@WebServlet("/C_Register")
public class C_Register extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	public C_Register() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException,IOException
	{
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		B_Register rd = new B_Register();
		if (request.getParameter("IDRegister") != null) {
			// Nguoi dung chon quan thi load ra phuogn
			ArrayList<Quan> quan;
			ArrayList<Phuong> phuong;
			try {
				quan = rd.GetListQuan();
				ArrayList<Benh> benh = rd.getListBenh();
				phuong = rd.getListPhuong();
				ArrayList<PhongBenh> phongbenh = rd.getListPB();
				ArrayList<Vac_xin> vacxin = rd.getListVac_Xin();
				ArrayList<DiaDiem> diadiem = rd.getListDiaDiem();

				request.setAttribute("ListQuan", quan);
				request.setAttribute("ListPhuong", phuong);
				request.setAttribute("ListBenh", benh);
				request.setAttribute("ListVacxin", vacxin);
				request.setAttribute("ListPhongBenh", phongbenh);
				request.setAttribute("ListDiaDiem", diadiem);
				String KQ = " XIN CHAO ";
				RequestDispatcher rd1 = getServletContext().getRequestDispatcher("/UserView/U_Register.jsp");
				rd1.forward(request, response);
				return;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (request.getParameter("Submit_Register") != null) {
			System.out.print(1);
			try {
				
				String SDT = request.getParameter("IDRegister1");

				String IDQuan = request.getParameter("cbQuan");
				String IDBenh = request.getParameter("cbBenh");
				String IDVacXin = request.getParameter("cbVacXin");
				String CBDiaChi = request.getParameter("cbDiaChi");
				String date = request.getParameter("NgayTiem");
				String MaDiaDiem = request.getParameter("cbDiaChi");
				String SoMuiCanTiem = rd.GetSoMuiByVacXin(IDVacXin);
				String SoMuiDaTiem = rd.GetSoMuiDaTiem(SDT, IDVacXin);
				String SoNgayVacXin = rd.GetSoNgayByVacXin(IDVacXin);
				String SoNgayGanNhat = rd.GetSoNgayGanNhat(SDT, IDVacXin);
				int SoNgayTiepTheo = Integer.parseInt(SoNgayVacXin);
				
			
				 
		
				 
				if(rd.CheckTrangThaiLich(SDT,IDVacXin,IDBenh) ==false) {
					if( rd.CheckVacXinDaTiem(IDBenh,IDVacXin,SDT) == true) {
						if (Integer.parseInt(SoMuiDaTiem) < Integer.parseInt(SoMuiCanTiem)) {
							// Neu trong lich su tiem chua co lan tiem nao
							if (SoNgayGanNhat.equals("0") == false) {
								Calendar c1 = Calendar.getInstance();
							
								Date time = Date.valueOf(SoNgayGanNhat);
								c1.setTime(time);
								c1.add(Calendar.DATE, SoNgayTiepTheo);
						
								java.sql.Date check = new java.sql.Date(c1.getTimeInMillis());
							
								long longmillis = System.currentTimeMillis();
								java.sql.Date date12 = new java.sql.Date(longmillis);
								
								if (date12.compareTo(check) > 0) {
									try {
										rd.TaoLichTiem(SDT, IDVacXin, date, MaDiaDiem, 1, SoMuiDaTiem, IDBenh);
										String KQ = " TAO LICH TIEM THANH CONG ! ";
										request.setAttribute("KQ", KQ);
										RequestDispatcher rd1 = getServletContext().getRequestDispatcher("/UserView/Register_OK.jsp");
										rd1.forward(request, response);
									} catch (ParseException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}

								} else {
									String KQ = " TAO LICH TIEM THAT BAI CHUA DU SO NGAY CAN TIEM ! ";
									request.setAttribute("KQ", KQ);
									RequestDispatcher rd1 = getServletContext().getRequestDispatcher("/UserView/Register_OK.jsp");
									rd1.forward(request, response);
								}
							}
							 
								if (Integer.parseInt(SoMuiDaTiem) == 0) {
									try {

										rd.TaoLichTiem(SDT, IDVacXin, date, MaDiaDiem, 1, SoMuiDaTiem, IDBenh);
										String KQ = " TAO LICH TIEM THANH CONG ! ";
										request.setAttribute("KQ", KQ);
										RequestDispatcher rd1 = getServletContext().getRequestDispatcher("/UserView/Register_OK.jsp");
										rd1.forward(request, response);
									} catch (ParseException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}

							
						} else {
							String KQ = " TAO LICH TIEM THAT BAI , VUOT QUA SO MUI QUY DINH  ! ";
							request.setAttribute("KQ", KQ);
							RequestDispatcher rd1 = getServletContext().getRequestDispatcher("/UserView/Register_OK.jsp");
							rd1.forward(request, response);
						}}
					else {
						ArrayList<LichSuTiem> ls = rd.getVacXinCu(IDBenh,IDVacXin,SDT);
						D_LichTIem lt = new D_LichTIem();
						String MVX = ls.get(0).MaVacXin;
						String Ten = lt.GetNameVacXin(MVX);
						
						String KQ = " TAO LICH THAT BAI , VAC XIN KHONG CUNG LOAI , LOAI DA TIEM LA : " + Ten;
						request.setAttribute("KQ", KQ);
						RequestDispatcher rd1 = getServletContext().getRequestDispatcher("/UserView/Register_OK.jsp");
						rd1.forward(request, response);
					}}
				else {
					String KQ = " TAO LICH TIEM THAT BAI , LICH HEN DANG CHO XU LI  ! ";
					request.setAttribute("KQ", KQ);
					RequestDispatcher rd1 = getServletContext().getRequestDispatcher("/UserView/Register_OK.jsp");
					rd1.forward(request, response);
				}
					
			

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			

		}

	}
}
