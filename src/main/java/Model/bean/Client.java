package Model.bean;

import java.util.Date;

public class Client {
	public String SDT;
	public String Ten;
	public Date NgaySinh;
	public String CMND;
	public String MaBaoHiem;
	public String SoNha;
	public int MaPhuong;
	public String ThanhPho;
	public String MatKhau;
	public Client() {
		super();
		
	}
	public Client(String SDT , String Ten , Date NgaySinh , String CMND , String MaBaoHiem
					, String SoNha , int MaPhuong , String ThanhPho , String MatKhau) {
		this.SDT=SDT;
		this.Ten=Ten;
		this.NgaySinh = NgaySinh;
		this.CMND = CMND;
		this.MaBaoHiem = MaBaoHiem;
		this.SoNha = SoNha;
		this.MaPhuong = MaPhuong;
		this.ThanhPho = ThanhPho;
		this.MatKhau = MatKhau;
		
	}
}
