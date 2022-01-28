package Model.bean;

public class DiaDiem {
	public int MaDiaDiem;
	public String TenDiaDiem;
	public String SoNha;
	public int MaPhuong;
	public String ThanhPho;
	public int MaTrangThai;
	public int SoLuong;
	public DiaDiem() {
		super();
		
	}
	public DiaDiem(int MaDiaDiem,String TenDiaDiem,String SoNha, int MaPhuong
				,String ThanhPho, int MaTrangThai,int SoLuong) {
		this.MaDiaDiem=MaDiaDiem;
		this.TenDiaDiem=TenDiaDiem;
		this.SoNha=SoNha;
		this.MaPhuong=MaPhuong;
		this.ThanhPho=ThanhPho;
		this.MaTrangThai=MaTrangThai;
		this.SoLuong=SoLuong;
	}
}
