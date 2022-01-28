package Model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.bean.LichSuTiem;
import Model.bean.LichTiem;
import Model.bean.Vac_xin;

public class D_ViewVacXin {

	public ArrayList<LichSuTiem> GetListVacXinBySDT(String SDT) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=PBL;user=sa;password=1234";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection(connectionUrl);
			PreparedStatement t= conn.prepareStatement("select * from LichSuTiem where SDT=?");
			t.setString(1, SDT);
	
			ArrayList<LichSuTiem> list = new ArrayList<LichSuTiem>();
			ResultSet rs= t.executeQuery();	
			while(rs.next()) {
				int MaLichSuTiem = rs.getInt("MaLichSuTiem");
				String MaVacXin = rs.getString("MaVacxin");
				String CMND1 = rs.getString("SDT");
				Date NgayTiem = rs.getDate("NgayTiem");
				int MuiThu = rs.getInt("Muithu");
				int MaBenh = rs.getInt("MaBenh");
				list.add(new LichSuTiem(MaLichSuTiem,MaVacXin,CMND1,NgayTiem,MuiThu,MaBenh));
				
			}
			return list;
	}

	public ArrayList<LichSuTiem> GetListVacXinBySDT(String sDT, String trangthai) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=PBL;user=sa;password=1234";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection(connectionUrl);
			PreparedStatement t= conn.prepareStatement("select * from LichSuTiem where SDT=? and MaVacxin = ?");
			t.setString(1, sDT);
			t.setString(2, trangthai);
			ArrayList<LichSuTiem> list = new ArrayList<LichSuTiem>();
			ResultSet rs= t.executeQuery();	
			while(rs.next()) {
				int MaLichSuTiem = rs.getInt("MaLichSuTiem");
				String MaVacXin = rs.getString("MaVacxin");
				String CMND1 = rs.getString("SDT");
				Date NgayTiem = rs.getDate("NgayTiem");
				int MuiThu = rs.getInt("Muithu");
				int MaBenh = rs.getInt("MaBenh");
				list.add(new LichSuTiem(MaLichSuTiem,MaVacXin,CMND1,NgayTiem,MuiThu,MaBenh));
				
			}
			return list;
	}
	

}
