package Model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Model.bean.Benh;
import Model.bean.DiaDiem;
import Model.bean.LichSuTiem;
import Model.bean.PhongBenh;
import Model.bean.Phuong;
import Model.bean.Quan;
import Model.bean.Vac_xin;

public class D_Register {

	public ArrayList<Quan> GetListQuan() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
	
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
				PreparedStatement t= conn.prepareStatement("select * from Quan");
				ArrayList<Quan> list = new ArrayList<Quan>();
				
				ResultSet rs= t.executeQuery();	
			while(rs.next()) {
				int MaQuan = rs.getInt(1);
				String TenQuan = rs.getString(2);
				list.add(new Quan(MaQuan,TenQuan));
				
			}
			return list;
	}

	public ArrayList<Benh> GetListBenh() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=PBL;user=sa;password=1234";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection(connectionUrl);
			PreparedStatement t= conn.prepareStatement("select * from Benh");
			ArrayList<Benh> list = new ArrayList<Benh>();
			
			ResultSet rs= t.executeQuery();	
		while(rs.next()) {
			int MaBenh = rs.getInt(1);
			String TenBenh = rs.getString(2);
			String Mota = rs.getString(3);
			
			list.add(new Benh(MaBenh,TenBenh,Mota));
		}
		return list;
	}

	public ArrayList<Phuong> GetListPhuong() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=PBL;user=sa;password=1234";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection(connectionUrl);
			PreparedStatement t= conn.prepareStatement("select * from Phuong");
			ArrayList<Phuong> list = new ArrayList<Phuong>();
			
			ResultSet rs= t.executeQuery();	
		while(rs.next()) {
			int MaPhuong = rs.getInt(1);
			String TenPhuong = rs.getString(2);
			int MaQuan = rs.getInt(3);
			list.add(new Phuong(MaPhuong,TenPhuong,MaQuan));
		
		}
		return list;
	}

	public ArrayList<PhongBenh> GetListPhongBenh() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=PBL;user=sa;password=1234";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection(connectionUrl);
			PreparedStatement t= conn.prepareStatement("select * from PhongBenh");
			ArrayList<PhongBenh> list = new ArrayList<PhongBenh>();
			
			ResultSet rs= t.executeQuery();	
		while(rs.next()) {
			String MaVacXin = rs.getString(1);
			int MaBenh = rs.getInt(2);
		
			list.add(new PhongBenh(MaVacXin,MaBenh));
		
		}
		return list;
	}

	public ArrayList<Vac_xin> GetListVac_Xin() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=PBL;user=sa;password=1234";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection(connectionUrl);
			PreparedStatement t= conn.prepareStatement("select * from Vacxin");
			ArrayList<Vac_xin> list = new ArrayList<Vac_xin>();
			
			ResultSet rs= t.executeQuery();	
		while(rs.next()) {
			String MaVacXin = rs.getString(1);
			String TenVacXin = rs.getString(2);
			String MoTaVacXin = rs.getString(3);
			int SoMuiCanTiem = rs.getInt(4);
			int SoNgayTiepTheo = rs.getInt("SoNgayTiepTheo");
			list.add(new Vac_xin(MaVacXin,TenVacXin,MoTaVacXin,SoMuiCanTiem,SoNgayTiepTheo));
			
		}
		return list;
	}

	public ArrayList<DiaDiem> getListDiaDiem() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=PBL;user=sa;password=1234";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection(connectionUrl);
			PreparedStatement t= conn.prepareStatement("select * from DiaDiem");
			ArrayList<DiaDiem> list = new ArrayList<DiaDiem>();
			
			ResultSet rs= t.executeQuery();	
		while(rs.next()) {
			int MaDiaDiem = rs.getInt(1);
			String TenDiaDiem = rs.getString(2);
			String SoNha = rs.getString(3);
			int MaPhuong = rs.getInt(4);
			String ThanhPho = rs.getString(5);
			int MaTrangThai = rs.getInt(6);
			int SoLuong = rs.getInt(7);
			
			list.add(new DiaDiem(MaDiaDiem,TenDiaDiem,SoNha,MaPhuong,
					ThanhPho,MaTrangThai,SoLuong));
		
		}
		return list;
	}

	public String GetCMNDBySDT(String sDT) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=PBL;user=sa;password=1234";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection(connectionUrl);
			PreparedStatement t= conn.prepareStatement("select * from Client where SDT=?");
			t.setString(1,sDT);
			ResultSet rs= t.executeQuery();	
			String CMND= null;
			if(rs.next()) {
				CMND = rs.getString(4);
	
				
			}
			else {
				System.out.print("Khong co ban ghi ");
			}
			
			
		return CMND;
	}

	public String GetSoMuiByVacXin(String iDVacXin) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=PBL;user=sa;password=1234";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection(connectionUrl);
			PreparedStatement t= conn.prepareStatement("select * from Vacxin where MaVacxin=?");
			t.setString(1, iDVacXin);
			ResultSet rs= t.executeQuery();	
			rs.next();
			String KQ = rs.getString("SoMuiCanTiem");
			
		return KQ;
	}

	public String GetSoMuiDaTiem(String SDT, String MaVacXin) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=PBL;user=sa;password=1234";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection(connectionUrl);
        
			PreparedStatement t= conn.prepareStatement("select count(*) from LichSuTiem where SDT=? AND MaVacxin = ?");
			t.setString(1,SDT);
			t.setString(2, MaVacXin);
			ResultSet rs= t.executeQuery();	
			rs.next();
			int KQ = rs.getInt(1);
		
			
		return String.valueOf(KQ);
	}

	public void TaoLichTiem(String sDT, String iDVacXin, String date, String maDiaDiem, int i, String soMuiDaTiem,
			String iDBenh) throws ClassNotFoundException, SQLException, ParseException {
		// TODO Auto-generated method stub
		String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=PBL;user=sa;password=1234";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection(connectionUrl);
        Date date1 =  Date.valueOf(date);;
    	
        int SoMuiTiemMoi = Integer.parseInt(soMuiDaTiem);
        SoMuiTiemMoi ++;
        
			PreparedStatement t= conn.prepareStatement("INSERT INTO LichTiem (SDT,NgayHen,MaDiaDiem,MaTrangThaiLichTiem,MuiThu,MaVacXin,MaBenh) VALUES (?,?,?,?,?,?,?)");
			t.setString(1,sDT);
			t.setDate(2,date1);
			t.setString(3,maDiaDiem);
			t.setInt(4,1);
			t.setString(5,String.valueOf(SoMuiTiemMoi));
			t.setString(6,iDVacXin);
			t.setString(7,iDBenh);
			t.executeUpdate();
		
	}

	public String GetSoNgayByVacXin(String iDVacXin) throws SQLException, ClassNotFoundException {

		String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=PBL;user=sa;password=1234";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection(connectionUrl);
			PreparedStatement t= conn.prepareStatement("select * from Vacxin where MaVacxin=?");
			t.setString(1, iDVacXin);
			ResultSet rs= t.executeQuery();	
			rs.next();
			String KQ = rs.getString("SoNgayTiepTheo");
		
		return KQ;
		
	}

	public String GetSoNgayGanNhat(String sDT, String iDVacXin) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=PBL;user=sa;password=1234";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection(connectionUrl);
        
			PreparedStatement t= conn.prepareStatement("select * from LichSuTiem where SDT=? AND MaVacxin = ? Order by MaLichSuTiem DESC ");
			t.setString(1,sDT);
			t.setString(2, iDVacXin);
			ResultSet rs= t.executeQuery();	
		
			while(rs.next()) {
				Date KQ = rs.getDate("NgayTiem");
				return KQ.toString();
			}
			return "0";
		
		
	}

	public boolean CheckVacXinDaTiem(String iDBenh, String iDVacXin, String sDT) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=PBL;user=sa;password=1234";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection(connectionUrl);
        
			PreparedStatement t= conn.prepareStatement("select MaVacxin from LichSuTiem where SDT=? AND MaBenh = ?  ");
			t.setString(1,sDT);
			t.setString(2, iDBenh);
			ResultSet rs= t.executeQuery();	
			System.out.print("9");
			if(rs.next())
			{
				if( rs.getString("MaVacxin").equals(iDVacXin))
				{
					return true;
				}
				else {
					return false;
				}
			}else
			{
				
				return true ; 
			}
			
	
	}

	public ArrayList<LichSuTiem> getVacXinCu(String iDBenh, String iDVacXin, String sDT) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=PBL;user=sa;password=1234";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection(connectionUrl);
        
			PreparedStatement t= conn.prepareStatement("select * from LichSuTiem where SDT=? AND MaBenh = ?  ");
			t.setString(1,sDT);
			t.setString(2, iDBenh);
			ResultSet rs= t.executeQuery();	
			ArrayList<LichSuTiem> list = new ArrayList<LichSuTiem>();
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

	public boolean CheckTrangThaiLich(String sDT, String iDVacXin, String iDBenh) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=PBL;user=sa;password=1234";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection(connectionUrl);
        
			PreparedStatement t= conn.prepareStatement("select * from LichTiem  where SDT=? AND MaVacxin = ? AND MaBenh = ? AND MaTrangThaiLichTiem ='1' ");
			t.setString(1,sDT);
			t.setString(2, iDVacXin);
			t.setString(3,iDBenh);
			
			ResultSet rs= t.executeQuery();	
		
			if(rs.next())
			{
				
					return true;
				
				
			}else
			{
				
				return false ; 
			}
	}

}
