package Model.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.bean.Client;

public class D_Login {

	public boolean CheckLogin(String SDT, String password) {
		// TODO Auto-generated method stub
		password = getMD5(password);
		try {
			String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=PBL;user=sa;password=1234";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(connectionUrl);
			PreparedStatement t = conn.prepareStatement("select * from Client where SDT=? and MatKhau =?");
			t.setString(1, SDT);
			t.setString(2, password);
			ResultSet rs = t.executeQuery();
			if (rs.next()) {

				return true;

			} else {

				return false;
			}

		} catch (Exception e) {
			System.out.print("khong ket noi dc sql de lay du lieu");
			return false;
		}
	}

	public Client GetUserBySDT(String sDT) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=PBL;user=sa;password=1234";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn = DriverManager.getConnection(connectionUrl);
		PreparedStatement t = conn.prepareStatement("select * from Client where SDT=? ");
		t.setString(1, sDT);

		ResultSet rs = t.executeQuery();
		rs.next();
		Client client = new Client();
		client.SDT = rs.getString(1);
		client.Ten = rs.getString(2);
		client.NgaySinh = rs.getDate(3);
		client.CMND = rs.getString(4);
		client.MaBaoHiem = rs.getString(5);
		client.SoNha = rs.getString(6);
		client.MaPhuong = rs.getInt(7);
		client.ThanhPho = rs.getString(8);
		client.MatKhau = rs.getString(9);
		return client;
	}

	public boolean CheckSDTExit(String sdt) {
		try {
			String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=PBL;user=sa;password=1234";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(connectionUrl);
			PreparedStatement t = conn.prepareStatement("select * from Client where SDT = ?");
			t.setString(1, sdt);
			ResultSet rs = t.executeQuery();

			if (rs.next()) {
				return false;
			} else {
				return true;
			}

		} catch (Exception e) {
			System.out.print("khong ket noi dc sql:check tk");
			return false;
		}

	}

	public void addAC(String sdt, String name, String cmnd, String idy, String date, String addr, String idp,
			String passw) {
		try {
			String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=PBL;user=sa;password=1234";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(connectionUrl);
			PreparedStatement t = conn.prepareStatement(
					"insert into Client(SDT,Ten,NgaySinh,CMND,MaBaoHiem,SoNha,MaPhuong,ThanhPho,MatKhau) "
							+ " values(?,?,?,?,?,?,?,'Đà Nẵng',?)");
			t.setString(1, sdt);
			t.setString(2, name);
			t.setString(3, date);
			t.setString(4, cmnd);
			t.setString(5, idy);
			t.setString(6, addr);
			t.setString(7, idp);
			t.setString(8, getMD5(passw));
			t.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.print("khong ket noi dc sql:add tai khoan");

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
