package BEAN;

import java.sql.Date;

public class Vaccine {
	private String IDVac;
	
	
	public String getIDVac() {
		return IDVac;
	}
	public String getName() {
		return Name;
	}
	public String getDesc() {
		return Desc;
	}
	
	private String Name;
	

	private String Desc;
	public int getSoMui() {
		return SoMui;
	}
	public int getNextDate() {
		return NextDate;
	}
	private int SoMui;
	private int NextDate;


	public Vaccine(String iDVac, String name, String desc, int SoMui, int nextDate) {
		IDVac = iDVac;
		Name = name;
		Desc = desc;
		this.SoMui = SoMui;
		NextDate = nextDate;
	}
	
}
