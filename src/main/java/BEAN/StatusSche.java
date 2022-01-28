package BEAN;

public class StatusSche {
	private String IdSta;
	public String getIdSta() {
		return IdSta;
	}
	public String getNameSta() {
		return NameSta;
	}
	
	private String NameSta;
	public StatusSche(String idSta, String nameSta) {
		IdSta = idSta;
		NameSta = nameSta;
	}
}
