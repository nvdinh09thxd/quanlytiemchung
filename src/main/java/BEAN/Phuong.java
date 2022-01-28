package BEAN;

public class Phuong {

	
	public String getIDPhuong() {
		return IDPhuong;
	}
	public String getNamePhuong() {
		return NamePhuong;
	}
	public String getIDQuan() {
		return IDQuan;
	}
	private String IDPhuong;
	private String NamePhuong;
	private String IDQuan;
	public Phuong(String iDPhuong, String namePhuong, String iDQuan) {
		IDPhuong = iDPhuong;
		NamePhuong = namePhuong;
		IDQuan = iDQuan;
	}

}
