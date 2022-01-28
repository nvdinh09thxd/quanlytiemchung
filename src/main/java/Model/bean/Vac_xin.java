package Model.bean;

public class Vac_xin {
	public String MaVacXin;
	public String TenVacXin;
	public String MoTaVacXin;
	public int SoMuiCanTiem;
	public int SoNgayTiepTheo;
	public Vac_xin() {
		super();
	}
	public Vac_xin(String MaVacXin , String TenVacXin,String MoTaVacXin, int SoMuiCanTiem,int SoNgayTiepTheo) {
		super();
		this.MaVacXin = MaVacXin;
		this.TenVacXin= TenVacXin;
		this.MoTaVacXin= MoTaVacXin;
		this.SoMuiCanTiem = SoMuiCanTiem;
		this.SoNgayTiepTheo= SoNgayTiepTheo;
	}
}
