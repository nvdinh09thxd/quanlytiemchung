package Model.bean;

import java.sql.Date;

public class LichSuTiem {
	public int MaLichSuTiem;
	public String MaVacXin;
	public String SDT;
	public Date NgayTiem;
	public int MuiThu;
	public int MaBenh;
	public LichSuTiem() {
		super();
		
	}
	public LichSuTiem(int MaLichSuTiem, String MaVacXin , String SDT,
			Date NgayTiem, int MuiThu , int MaBenh) {
		super();
		this.MaLichSuTiem= MaLichSuTiem;
		this.MaVacXin= MaVacXin;
		this.SDT= SDT;
		this.MaBenh=MaBenh;
		this.NgayTiem = NgayTiem;
		this.MuiThu = MuiThu;
		
	}
}
