package Model.bo;


import java.sql.SQLException;

import Model.bean.Client;
import Model.dao.D_Login;

public class B_Login {
	D_Login login = new D_Login();
	public boolean CheckLogin(String SDT, String pass) {
		
		return login.CheckLogin(SDT ,pass);
	}
	public Client GetUserBySDT(String SDT) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return login.GetUserBySDT(SDT);
	}
	public  boolean CheckSDTExit(String sdt) 
	{
		return login.CheckSDTExit(sdt);
	}
	public void addAC(String sdt,String name,String cmnd,String idy,String date,String addr,String idp,String passw)
	 {
		login.addAC(sdt, name, cmnd, idy, date, addr, idp, passw);
	 }

}
