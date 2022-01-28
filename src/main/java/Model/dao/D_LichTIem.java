package Model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.bean.LichTiem;
import Model.bean.Quan;
import Model.bean.TrangThaiLichTiem;
import Model.bean.Vac_xin;

public class D_LichTIem {

	public ArrayList<LichTiem> GetLichTiemBySDT(String sDT) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=PBL;user=sa;password=1234";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection(connectionUrl);
			PreparedStatement t= conn.prepareStatement("select * from LichTiem where SDT=? ORDER BY NGAYHEN ASC");
			t.setString(1, sDT);
	
			ArrayList<LichTiem> list = new ArrayList<LichTiem>();
			ResultSet rs= t.executeQuery();	
			while(rs.next()) {
				int MaLichTiem = rs.getInt("MaLichTiem");
				String SDT = rs.getString("SDT");
				String MaVacXin = rs.getString("MaVacxin");
				Date NgayHen = rs.getDate("NgayHen");
				int MaDiaDiem = rs.getInt("MaDiaDiem");
				int MaTrangThai = rs.getInt("MaTrangThaiLichTiem");
				int MuiThu = rs.getInt("MuiThu");
				int MaBenh = rs.getInt("MaBenh");
				list.add(new LichTiem(MaLichTiem,SDT,MaVacXin,NgayHen,MaDiaDiem,MaTrangThai,MuiThu,MaBenh));

			}
			return list;

	}

	public String GetNameVacXin(String maVacXin) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=PBL;user=sa;password=1234";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection(connectionUrl);
			PreparedStatement t= conn.prepareStatement("select * from Vacxin where MaVacxin=?");
			t.setString(1, maVacXin);
	
			String TenVacXin = null;
			ResultSet rs= t.executeQuery();	
			while(rs.next()) {
			
			 TenVacXin = rs.getString("TenVacXin");
			
			
				
			}
			return TenVacXin;
	}

	public String GetDiaDiemByID(int i) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=PBL;user=sa;password=1234";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection(connectionUrl);
			PreparedStatement t= conn.prepareStatement("select * from DiaDiem where MaDiaDiem=?");
			t.setInt(1, i);
	
			String TenDiaDiem = null;
			ResultSet rs= t.executeQuery();	
			while(rs.next()) {
			
				TenDiaDiem = rs.getString(2);
			
			
				
			}
			return TenDiaDiem;
	}

	public String GetTrangThaiByID(int i) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=PBL;user=sa;password=1234";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection(connectionUrl);
			PreparedStatement t= conn.prepareStatement("select * from TrangThaiLichTiem where MaTrangThaiLichTiem=?");
			t.setInt(1, i);
	
			String TenTrangThai = null;
			ResultSet rs= t.executeQuery();	
			while(rs.next()) {
			
				TenTrangThai = rs.getString(2);
			
			
				
			}
			return TenTrangThai;
	}

	public ArrayList<LichTiem> GetLichTiemBySDTandTT(String sDT, String trangthai) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=PBL;user=sa;password=1234";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection(connectionUrl);
			PreparedStatement t= conn.prepareStatement("select * from LichTiem where SDT=? And MaTrangThaiLichTiem=? ORDER BY NGAYHEN ASC");
			t.setString(1, sDT);
			t.setString(2, trangthai);
			ArrayList<LichTiem> list = new ArrayList<LichTiem>();
			ResultSet rs= t.executeQuery();	
			while(rs.next()) {
				int MaLichTiem = rs.getInt("MaLichTiem");
				String SDT = rs.getString("SDT");
				String MaVacXin = rs.getString("MaVacxin");
				Date NgayHen = rs.getDate("NgayHen");
				int MaDiaDiem = rs.getInt("MaDiaDiem");
				int MaTrangThai = rs.getInt("MaTrangThaiLichTiem");
				int MuiThu = rs.getInt("MuiThu");
				int MaBenh = rs.getInt("MaBenh");
				list.add(new LichTiem(MaLichTiem,SDT,MaVacXin,NgayHen,MaDiaDiem,MaTrangThai,MuiThu,MaBenh));

			}
			return list;
	}

	public ArrayList<TrangThaiLichTiem> GetAllTrangThai() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=PBL;user=sa;password=1234";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        ArrayList<TrangThaiLichTiem> list = new ArrayList<TrangThaiLichTiem>();
        Connection conn = DriverManager.getConnection(connectionUrl);
			PreparedStatement t= conn.prepareStatement("select * from TrangThaiLichTiem ");
			ResultSet rs= t.executeQuery();	
			while(rs.next()) {
			
				int MaTrangThaiLichTiem=rs.getInt("MaTrangThaiLichTiem");
				String TenTrangThaiLichTiem=rs.getString("TenTrangThaiLichtiem");
			
			list.add(new TrangThaiLichTiem(MaTrangThaiLichTiem,TenTrangThaiLichTiem));
				
			}
			return list;
	}

	public void delLich(String iD) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=PBL;user=sa;password=1234";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
  
        Connection conn = DriverManager.getConnection(connectionUrl);
			PreparedStatement t= conn.prepareStatement("Delete  from LichTiem where MaLichTiem = ? ");
			t.setString(1, iD);
		t.executeUpdate();	
			
		
	}

}
