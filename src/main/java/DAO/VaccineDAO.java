package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import BEAN.PhongBenh;
import BEAN.Schedule;
import BEAN.Vaccine;
import BEAN.disease;

public class VaccineDAO {
	public  ArrayList<Vaccine> listVac()
	{
		ArrayList<Vaccine> list = new ArrayList<Vaccine>();
		try
		{
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement t = conn.prepareStatement("select * from Vacxin");
            ResultSet rs = t.executeQuery();
            while(rs.next())
            {
            	Vaccine a = new Vaccine(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
            	list.add(a);
            }
            conn.close();
			}
			catch(Exception e)
			{
				System.out.print("khong ket noi dc sql");
				
			}	
		return list;
	}
	public  Vaccine getVac(String ma)
	{
		Vaccine list = null;
		try
		{
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement t = conn.prepareStatement("select * from Vacxin where MaVacxin =?");
            t.setString(1, ma);
            ResultSet rs = t.executeQuery();
            rs.next();
            	list = new Vaccine(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
            conn.close();
			}
			catch(Exception e)
			{
				System.out.print("khong ket noi dc sql");
				
			}	
		return list;
	}
	public void UpdateVac(String id,String name,String num,String nextDate,String dec)
	{
		try
		{
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement t = conn.prepareStatement("UPDATE Vacxin set TenVacXin =?,SoMuiCanTiem=?,SoNgayTiepTheo=?,MoTaVacXin=? where MaVacxin=?");
            t.setString(5, id);
            t.setString(1, name);
            t.setString(2, num);
            t.setString(3, nextDate);
            t.setString(4, dec);
            t.executeUpdate();
            conn.close();
			}
			catch(Exception e)
			{
				System.out.print("khong ket noi dc sql:update");
				
			}	
	}
	public void DeleteVac(String[] id)
	{
		try
		{
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
            for(int i=0;i<id.length;i++)
            {
            PreparedStatement t = conn.prepareStatement("delete from Vacxin where MaVacxin=?");
            t.setString(1, id[i]);
            t.executeUpdate();
            }
            conn.close();
            
			}
			catch(Exception e)
			{
				System.out.print("khong ket noi dc sql: delete vac");
				
			}	
	}
	public void AddVac(String id,String name,String num,String nextDate,String dec)
	{
		try
		{
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement t = conn.prepareStatement("insert into Vacxin(MaVacxin,TenVacXin,SoMuiCanTiem,SoNgayTiepTheo,MoTaVacXin) values(?,?,?,?,?)");
            t.setString(1, id);
            t.setString(2, name);
            t.setString(3, num);
            t.setString(4, nextDate);
            t.setString(5, dec);
            t.executeUpdate();
            conn.close();
			}
			catch(Exception e)
			{
				System.out.print("khong ket noi dc sql:add vac");
				
			}	
	}
	public  ArrayList<disease> listBenh(String mavc)
	{
		ArrayList<disease> list = new ArrayList<disease>();
		try
		{
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement t = conn.prepareStatement("select Benh.MaBenh,Benh.TenBenh,Benh.MoTa "
            		+ "from PhongBenh inner join Benh on PhongBenh.MaBenh = Benh.MaBenh "
            		+ "where PhongBenh.MaVacxin = ?");
            t.setString(1, mavc);
            ResultSet rs = t.executeQuery();
            while(rs.next())
            {
            	disease a = new disease(rs.getString(1),rs.getString(2),rs.getString(3));
            	list.add(a);
            }
            conn.close();
			}
			catch(Exception e)
			{
				System.out.print("khong ket noi dc sql");
				
			}	
		return list;
	}
	public  ArrayList<disease> listBenh()
	{
		ArrayList<disease> list = new ArrayList<disease>();
		try
		{
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement t = conn.prepareStatement("select * from Benh");
            ResultSet rs = t.executeQuery();
            while(rs.next())
            {
            	disease a = new disease(rs.getString(1),rs.getString(2),rs.getString(3));
            	list.add(a);
            }
            conn.close();
			}
			catch(Exception e)
			{
				System.out.print("khong ket noi dc sql");
				
			}	
		return list;
	}
	public  ArrayList<PhongBenh> listPhongBenh()
	{
		ArrayList<PhongBenh> list = new ArrayList<PhongBenh>();
		try
		{
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement t = conn.prepareStatement("select Vacxin.MaVacxin,Vacxin.TenVacXin,Benh.MaBenh,Benh.TenBenh "
            		+ "from PhongBenh inner join Benh on PhongBenh.MaBenh = Benh.MaBenh  "
            		+ "inner join Vacxin on PhongBenh.MaVacxin = Vacxin.MaVacxin");
            ResultSet rs = t.executeQuery();
            while(rs.next())
            {
            	PhongBenh a = new PhongBenh(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
            	list.add(a);
            }
            conn.close();
			}
			catch(Exception e)
			{
				System.out.print("khong ket noi dc sql");
				
			}	
		return list;
	}
	public void AddPhongBenh(String idVac,String idBenh)
	{
		
		try
		{
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement t = conn.prepareStatement("insert into PhongBenh values(?,?)");
            t.setString(1, idVac);
            t.setString(2, idBenh);
            if(checkExitPB(idVac, idBenh))
            {
            t.executeUpdate();
            }
            conn.close();
			}
			catch(Exception e)
			{
				System.out.print("khong ket noi dc sql : add pb");
				
			}	

	}
	public boolean checkExitPB(String idVac , String idBenh)
	{
		try
		{
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement t = conn.prepareStatement("select * from PhongBenh where MaVacxin=? and MaBenh =?");
            t.setString(1, idVac);
            t.setString(2, idBenh);
            ResultSet rs = t.executeQuery();
            if(rs.next())
            {
            	return false;
            	
            }
            else
            {
            	return true;
            }
            
			}
			catch(Exception e)
			{
				System.out.print("khong ket noi dc sql : kiem tra pb");
				return false;
				
			}	
	}
	public void DeletePB(String[] listPBDel)
	{
		try
		{
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);          
            for(int i =0;i<listPBDel.length;i++)
            {
            PreparedStatement t = conn.prepareStatement("delete from PhongBenh where MaVacxin=? and MaBenh=?");
            String[] ma = listPBDel[i].split("&&");
            t.setString(1, ma[0]);
            t.setString(2, ma[1]);
            t.executeUpdate();
            }
            conn.close();
			}
			catch(Exception e)
			{
				System.out.print("khong ket noi dc sql : xoa pb");
				e.printStackTrace();
			}	
	}
	public disease GetBenh(String idbenh)
	{
		disease list = null;
		try
		{
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement t = conn.prepareStatement("select * from Benh where MaBenh =?");
            t.setString(1, idbenh);
            ResultSet rs = t.executeQuery();
            rs.next();
            	list = new disease(rs.getString(1),rs.getString(2),rs.getString(3));
            conn.close();
			}
			catch(Exception e)
			{
				System.out.print("khong ket noi dc sql");
				
			}	
		return list;
	}
	public void addBenh(String name,String mota)
	{
		try
		{
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement t = conn.prepareStatement("insert into Benh(TenBenh,MoTa) values(?,?)");
            t.setString(1, name);
            t.setString(2, mota);
            t.executeUpdate();
            conn.close();
			}
			catch(Exception e)
			{
				System.out.print("khong ket noi dc sql");
				
			}	
	}
	public void updateBenh(String idbenh,String name,String mota)
	{
		try
		{
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement t = conn.prepareStatement("update Benh set TenBenh =? , MoTa=? where MaBenh=?");
            t.setString(3, idbenh);
            t.setString(1, name);
            t.setString(2, mota);
            t.executeUpdate();
            conn.close();
			}
			catch(Exception e)
			{
				System.out.print("khong ket noi dc sql");
				
			}	
	}
	public void DeleteBenh(String[] id)
	{
		try
		{
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
            for(int i=0;i<id.length;i++)
            {
            PreparedStatement t = conn.prepareStatement("delete from Benh where MaBenh=?");
            t.setString(1, id[i]);
            t.executeUpdate();
            }
            conn.close();
            
			}
			catch(Exception e)
			{
				System.out.print("khong ket noi dc sql: delete benh");
				
			}	
	}
	
	
}
