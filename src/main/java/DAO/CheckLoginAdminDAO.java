package DAO;
import BEAN.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class CheckLoginAdminDAO {

	public boolean isExisUser(String username,String password)
	{
		try
		{
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement t = conn.prepareStatement("select * from taikhoan where username = ? and passw= ?");
            t.setString(1, username);
            t.setString(2, getMD5(password));
            ResultSet rs = t.executeQuery();
            
			if(rs.next())
			{
				conn.close();
				t.close();
				return true;
			
			}
			else
			{
				conn.close();
				t.close();
				return false;
			}
			}
			catch(Exception e)
			{
				System.out.print("khong ket noi dc sql");
				return false;
			}
            
            
		
	}
	public ArrayList<AccountAdmin> listacc(String user)
	{
		ArrayList<AccountAdmin> list = new  ArrayList<AccountAdmin>();
		try
		{
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement t = conn.prepareStatement("select taikhoan.username from taikhoan where username != ?");
            t.setString(1, user);
            ResultSet rs = t.executeQuery();
            while(rs.next())
            {
            	AccountAdmin a = new AccountAdmin(rs.getString(1));
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
	public void DeleteAcc(String[] id)
	{
		try
		{
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
            for(int i=0;i<id.length;i++)
            {
            PreparedStatement t = conn.prepareStatement("delete from taikhoan where username=?");
            t.setString(1, id[i]);
            t.executeUpdate();
            }
            conn.close();
            
			}
			catch(Exception e)
			{
				System.out.print("khong ket noi dc sql: delete taikhoan");
				
			}
		
	}
	public void addAdmin(String user,String passw)
	{
		try
		{
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement t = conn.prepareStatement("insert into taikhoan(username,passw) values(?,?)");
            t.setString(1, user);
            t.setString(2, getMD5(passw));
            t.executeUpdate();
            conn.close();
			}
			catch(Exception e)
			{
				System.out.print("khong ket noi dc sql");
				
			}	
	}
	public void ChangePass(String user,String newPass)
	{
		newPass = getMD5(newPass);
		try
		{
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement t = conn.prepareStatement("update taikhoan set passw = ? where username =?");
            t.setString(2, user);
            t.setString(1, newPass);
            t.executeUpdate();
            conn.close();
		}
			catch(Exception e)
			{
				System.out.print("khong ket noi dc sql");
				
			}	
	}
	 public static String getMD5(String input) {
		    try {
		      MessageDigest md = MessageDigest.getInstance("MD5");
		      byte[] messageDigest = md.digest(input.getBytes());
		      return convertByteToHex(messageDigest);
		    } catch (NoSuchAlgorithmException e) {
		      throw new RuntimeException(e);
		    }
		  }
	 public static String convertByteToHex(byte[] data) {
		    StringBuffer sb = new StringBuffer();
		    for (int i = 0; i < data.length; i++) {
		      sb.append(Integer.toString((data[i] & 0xff) + 0x100, 16).substring(1));
		    }
		    return sb.toString();
		  }
}
