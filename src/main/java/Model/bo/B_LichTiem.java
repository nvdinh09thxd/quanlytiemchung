package Model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.bean.LichTiem;
import Model.bean.TrangThaiLichTiem;
import Model.bean.Vac_xin;
import Model.dao.D_LichTIem;

public class B_LichTiem {
	D_LichTIem lt = new D_LichTIem();
	public ArrayList<LichTiem> GetLichTiemBySDT(String sDT) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return lt.GetLichTiemBySDT(sDT);
	}
	public String GetVacXinByID(String maVacXin) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return lt.GetNameVacXin(maVacXin);
	}
	public String GetDiaDiemByID(int i) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return lt.GetDiaDiemByID(i);
	}
	public String GetTrangThaiByID(int i) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return lt.GetTrangThaiByID(i);
	}
	public ArrayList<LichTiem> GetLichTiemBySDTandTT(String sDT, String trangthai) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return lt. GetLichTiemBySDTandTT( sDT, trangthai);
	}
	public ArrayList<TrangThaiLichTiem> getALLTrangThai() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return lt.GetAllTrangThai();
	}
	public void DelLich(String iD) throws ClassNotFoundException, SQLException {
		lt.delLich(iD);
		
	}

}
