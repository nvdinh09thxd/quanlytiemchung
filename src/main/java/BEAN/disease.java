package BEAN;

public class disease {
	
	public String getIDdise() {
		return IDdise;
	}
	public String getName() {
		return Name;
	}
	public String getDisc() {
		return disc;
	}
	
	private String IDdise;
	public disease(String iDdise, String name, String disc) {
		IDdise = iDdise;
		Name = name;
		this.disc = disc;
	}

	private String Name;
	private String disc;

}
