package Model.bean;

import java.sql.Date;

public class LichTiem {
	public int MaLichTiem;
	public String SDT;
	public String MaVacXin;
	public Date NgayHen;
	public int MaDiaDiem;
	public int MaTrangThaiLichTiem;
	public int MuiThu;
	public int MaBenh;
	public LichTiem() {
		super();
	
	}
	public LichTiem(int MaLichTiem,String SDT,String MaVacXin,Date NgayHen
			,int MaDiaDiem, int MaTrangThaiLichTiem,int MuiThu,int MaBenh) {
		this.MaLichTiem=MaLichTiem;
		this.SDT=SDT;
		this.MaVacXin=MaVacXin;
		this.NgayHen=NgayHen;
		this.MaDiaDiem=MaDiaDiem;
		this.MaTrangThaiLichTiem=MaTrangThaiLichTiem;
		this.MuiThu=MuiThu;
		this.MaBenh=MaBenh;
	}
}
