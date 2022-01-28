package BEAN;

import java.sql.Date;

public class Schedule {

	private String ID;
	public String getID() {
		return ID;
	}
	public String getPhone() {
		return Phone;
	}
	public Date getDate() {
		return date;
	}
	public String getAddr() {
		return Addr;
	}
	public String getStatus() {
		return Status;
	}
	public String getIDVaccine() {
		return IDVaccine;
	}
	public String getNameVaccine() {
		return NameVaccine;
	}
	public String getDescVaccine() {
		return DescVaccine;
	}
	
	private String Phone;
	private Date date;
	private String Addr;
	private String Status;
	private String IDVaccine;
	private String NameVaccine;
	private String DescVaccine;
	public int getNextDate() {
		return NextDate;
	}

	public int getNumVaccine() {
		return numVaccine;
	}

	private int numVaccine;
	private int NextDate;
	private String NameGuest;
	private String CMNDGuest;
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
	private String IDAdd;
	private int indexVac;
	public int getIndexVac() {
		return indexVac;
	}
	public String getIDAdd() {
		return IDAdd;
	}
	public String getCMNDGuest() {
		return CMNDGuest;
	}
	public Schedule() {}
	public Schedule(String ID ,String Phone, String name, Date date, String add, String Status,int indexVac)
	{
		this.ID = ID ; 
		this.Phone = Phone;
		this.NameVaccine = name;
		this.date = date;
		this.Addr = add;
		this.Status = Status;
		this.indexVac = indexVac;
	}
	public Schedule(String ID ,String Phone, String name, Date date, String add, String Status,String idvac,String desvac,String cmnd,
			String idbenh,String namebenh,String motabenh,int numVac,int NextDate,String idAdd,int muithu)
	{
		this.ID = ID ; 
		this.Phone = Phone;
		this.NameVaccine = name;
		this.date = date;
		this.Addr = add;
		this.Status = Status;
		this.IDVaccine = idvac;
		this.DescVaccine = desvac;
		this.CMNDGuest= cmnd;
		this.IDBenh = idbenh;
		this.NameBenh = namebenh;
		this.DescBenh = motabenh;
		this.numVaccine = numVac;
		this.NextDate = NextDate;
		this.IDAdd = idAdd;
		this.indexVac = muithu;
	}
	public Schedule(String iD, String phone, Date date, String addr, String status, String iDVaccine,
			String nameVaccine, String descVaccine, String nameGuest, String cMNDGuest, String iDBenh, String nameBenh,
			String descBenh) {
		ID = iD;
		Phone = phone;
		this.date = date;
		Addr = addr;
		Status = status;
		IDVaccine = iDVaccine;
		NameVaccine = nameVaccine;
		DescVaccine = descVaccine;
		NameGuest = nameGuest;
		CMNDGuest = cMNDGuest;
		IDBenh = iDBenh;
		NameBenh = nameBenh;
		DescBenh = descBenh;
	}
	
}
