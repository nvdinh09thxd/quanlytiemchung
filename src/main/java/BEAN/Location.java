package BEAN;

public class Location {
	private String IDLocation;
	public String getIDLocation() {
		return IDLocation;
	}
	public String getNameLocation() {
		return NameLocation;
	}
	public String getAddress() {
		return Address;
	}
	public String getIDPhuong() {
		return IDPhuong;
	}
	public String getNamePhuong() {
		return NamePhuong;
	}
	public String getIDQuan() {
		return IDQuan;
	}
	public String getNameQuan() {
		return NameQuan;
	}
	public String getCity() {
		return City;
	}
	public String getNum() {
		return num;
	}
	public String getIDStatus() {
		return IDStatus;
	}
	public String getNameStatus() {
		return NameStatus;
	}
	
	private String NameLocation;
	public Location(String iDLocation, String nameLocation, String address, String iDPhuong,String city,String idStatus, String num) {
		IDLocation = iDLocation;
		NameLocation = nameLocation;
		Address = address;
		IDPhuong = iDPhuong;
		this.num = num;
		IDStatus = idStatus;
	}
	public Location(String iDLocation, String nameLocation, String address, String iDPhuong, String namePhuong,
			String iDQuan, String nameQuan, String city, String num, String iDStatus, String nameStatus) {
		IDLocation = iDLocation;
		NameLocation = nameLocation;
		Address = address;
		IDPhuong = iDPhuong;
		NamePhuong = namePhuong;
		IDQuan = iDQuan;
		NameQuan = nameQuan;
		City = city;
		this.num = num;
		IDStatus = iDStatus;
		NameStatus = nameStatus;
	}

	private String Address;
	private String IDPhuong;
	private String NamePhuong;
	private String IDQuan;
	private String NameQuan;
	private String City;
	private String num;
	private String IDStatus;
	private String NameStatus;
}
