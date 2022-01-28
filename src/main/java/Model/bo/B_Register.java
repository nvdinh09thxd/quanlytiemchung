package Model.bo;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import Model.bean.Benh;
import Model.bean.DiaDiem;
import Model.bean.LichSuTiem;
import Model.bean.PhongBenh;
import Model.bean.Phuong;
import Model.bean.Quan;
import Model.bean.Vac_xin;
import Model.dao.D_Register;

public class B_Register {

	D_Register rg = new D_Register();
	public ArrayList<Quan> GetListQuan() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return rg.GetListQuan();
	}
	public ArrayList<Benh> getListBenh() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return rg.GetListBenh();
	}
	public ArrayList<Phuong> getListPhuong() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return rg.GetListPhuong();
	}
	public ArrayList<PhongBenh> getListPB() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return rg.GetListPhongBenh();
	}
	public ArrayList<Vac_xin> getListVac_Xin() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return rg.GetListVac_Xin();
	}
	public ArrayList<DiaDiem> getListDiaDiem() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return rg.getListDiaDiem();
	}
	public String GetCMNDBySDT(String sDT) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return rg.GetCMNDBySDT(sDT);
	}
	public String GetSoMuiByVacXin(String iDVacXin) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return rg.GetSoMuiByVacXin(iDVacXin);
	}
	public String GetSoMuiDaTiem(String SDT,String MaVacXin) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return rg.GetSoMuiDaTiem(SDT,MaVacXin);
	}
	public void TaoLichTiem(String sDT, String iDVacXin, String date, String maDiaDiem, int i, String soMuiDaTiem,
			String iDBenh) throws ClassNotFoundException, SQLException, ParseException {
		// TODO Auto-generated method stub
		rg.TaoLichTiem(sDT,iDVacXin,date,maDiaDiem,i,soMuiDaTiem,iDBenh);
	}
	public String GetSoNgayByVacXin(String iDVacXin) throws ClassNotFoundException, SQLException {
		return rg.GetSoNgayByVacXin(iDVacXin);
	}
	public String GetSoNgayGanNhat(String sDT, String iDVacXin) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return rg.GetSoNgayGanNhat( sDT,  iDVacXin);
	}
	public boolean CheckVacXinDaTiem(String iDBenh, String iDVacXin, String sDT) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return rg.CheckVacXinDaTiem( iDBenh,  iDVacXin,  sDT);
	}
	public ArrayList<LichSuTiem> getVacXinCu(String iDBenh, String iDVacXin, String sDT) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return rg.getVacXinCu( iDBenh,  iDVacXin,  sDT);
	}
	public boolean CheckTrangThaiLich(String sDT, String iDVacXin, String iDBenh) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return rg.CheckTrangThaiLich( sDT,iDVacXin,iDBenh);
	}
	

}
