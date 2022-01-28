package BEAN;

import java.sql.Date;

public class History {

	
	public String getIDHist() {
		return IDHist;
	}
	public String getCMND() {
		return CMND;
	}
	public Date getDate() {
		return date;
	}
	public int getNum() {
		return num;
	}
	public String getIDVac() {
		return IDVac;
	}
	public String getNameVac() {
		return NameVac;
	}
	public String getDescVac() {
		return DescVac;
	}
	private String IDHist;
	private String CMND;
	private Date date;
	private int num;
	private String IDVac;
	private String NameVac;
	private String DescVac;
	public String getIDBenh() {
		return IDBenh;
	}
	public String getNameBenh() {
		return NameBenh;
	}
	public String getDescBenh() {
		return DescBenh;
	}
	
	private String IDBenh;
	private String NameBenh;
	private String DescBenh;

	public History(String iDHist, String cMND, Date date, int num, String iDVac, String nameVac, String descVac,
			String iDBenh, String nameBenh, String descBenh) {
		IDHist = iDHist;
		CMND = cMND;
		this.date = date;
		this.num = num;
		IDVac = iDVac;
		NameVac = nameVac;
		DescVac = descVac;
		IDBenh = iDBenh;
		NameBenh = nameBenh;
		DescBenh = descBenh;
	}
	public History(String iDHist , String MaVac,String CMND,Date date,int MuiThu)
	{
		this.IDHist = iDHist;
		this.IDVac = MaVac;
		this.CMND = CMND;
		this.date = date;
		this.num = MuiThu;
		
	}
	public History( String MaVac,String CMND,Date date,int MuiThu,String idvac,String idbenh)
	{
		
		this.IDVac = MaVac;
		this.CMND = CMND;
		this.date = date;
		this.num = MuiThu;
		this.IDVac = idvac;
		this.IDBenh = idbenh;
	}
}
