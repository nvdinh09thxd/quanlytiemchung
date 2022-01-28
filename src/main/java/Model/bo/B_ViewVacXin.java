package Model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.bean.LichSuTiem;
import Model.bean.Vac_xin;
import Model.dao.D_ViewVacXin;

public class B_ViewVacXin {
	D_ViewVacXin vacxin = new D_ViewVacXin();
	public ArrayList<LichSuTiem> GetLichSuVacXinBySDT(String SDT) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return vacxin.GetListVacXinBySDT(SDT);
	}
	public ArrayList<LichSuTiem> GetLichSuVacXinBySDTandTT(String sDT, String trangthai) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return vacxin.GetListVacXinBySDT(sDT,trangthai);
	}

}
