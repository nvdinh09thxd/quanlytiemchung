package BEAN;

public class PhongBenh {

	private String IDVac;
	public String getIDVac() {
		return IDVac;
	}
	public String getNameVac() {
		return NameVac;
	}
	public String getIDBenh() {
		return IDBenh;
	}
	public String getNameBenh() {
		return NameBenh;
	}
	
	public PhongBenh(String iDVac, String nameVac, String iDBenh, String nameBenh) {
		IDVac = iDVac;
		NameVac = nameVac;
		IDBenh = iDBenh;
		NameBenh = nameBenh;
	}

	private String NameVac;
	private String IDBenh;
	private String NameBenh;

}
