package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import BEAN.Location;

public class CalScheduleDAO {
	public String CreateSchedule(String sdt , String idvac ,Date date , String idlocation)
	{
		String note = "Success";
		String cmnd = this.GetCMNDByPhone(sdt);
		try
		{
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
            //cmnd idvacxin date  idlocation
            PreparedStatement t = conn.prepareStatement("");  
            
            conn.close();
			}
			catch(Exception e)
			{
				System.out.print("khong ket noi dc sql list status");				
			}	
		return note;
	}
	public String GetCMNDByPhone(String phone)
	{
		String cmnd =null;
		try
		{
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
            //cmnd idvacxin date  idlocation
            PreparedStatement t = conn.prepareStatement("select Client.CMND from Client where SDT = ?");  
            t.setString(1, phone);
            ResultSet rs = t.executeQuery();
            rs.next();
            cmnd = rs.getString(1);
            conn.close();
			}
			catch(Exception e)
			{
				System.out.print("khong ket noi dc sql list status");				
			}	
		return cmnd;
	}
}
