package BEAN;

public class StatusLocation {
	private String IDStatus;
	public String getIDStatus() {
		return IDStatus;
	}
	public String getNameStatus() {
		return nameStatus;
	}
	
	private String nameStatus;
	public StatusLocation(String iDStatus, String nameStatus) {
		IDStatus = iDStatus;
		this.nameStatus = nameStatus;
	}
}
