package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import BEAN.*;

public class ScheAndHistDAO {
	public  ArrayList<Schedule> simpleSche(String IDstatus,String option)
	{
		String op="";
		if(option.equals("new"))
		{
			op="order by NgayHen desc";
		}
		else
			if(option.equals("old"))
			{
				op="order by NgayHen asc";
			}
			else
			{
				op="order by Vacxin.TenVacXin";
			}
												
		ArrayList<Schedule> list = new ArrayList<Schedule>();
		try
		{
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement t = conn.prepareStatement("select LichTiem.MaLichTiem, LichTiem.SDT,"
            		+ " Vacxin.TenVacXin,LichTiem.NgayHen,DiaDiem.SoNha,"
            		+ " Phuong.TenPhuong,Quan.TenQuan,TrangThaiLichTiem.TenTrangThaiLichTiem,LichTiem.MuiThu"
            		+ " from LichTiem inner join Vacxin on LichTiem.MaVacxin = Vacxin.MaVacxin"
            		+ " inner join DiaDiem on DiaDiem.MaDiaDiem = LichTiem.MaDiaDiem"
            		+ " inner join TrangThaiLichTiem on TrangThaiLichTiem.MaTrangThaiLichTiem = LichTiem.MaTrangThaiLichTiem "
            		+ " inner join Phuong on DiaDiem.MaPhuong = Phuong.Maphuong "
            		+ " inner join Quan on Phuong.MaQuan = Quan.MaQuan"
            		+ " where LichTiem.MaTrangThaiLichTiem=? "+op);
            t.setString(1, IDstatus);
            ResultSet rs = t.executeQuery();
            while(rs.next())
            {
            	String add = rs.getString(5)+","+rs.getString(6)+","+rs.getString(7);
            	Schedule a = new Schedule(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), add, rs.getString(8),rs.getInt(9));
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
	public  Schedule DetailSche(String malich)
	{
		Schedule item = new Schedule();
		try
		{
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + " databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement t = conn.prepareStatement("select LichTiem.MaLichTiem, LichTiem.SDT, "
            		+ "Vacxin.TenVacXin,LichTiem.NgayHen,DiaDiem.SoNha, "
            		+ "Phuong.TenPhuong,Quan.TenQuan,TrangThaiLichTiem.TenTrangThaiLichTiem, "
            		+ "Vacxin.MaVacxin,Vacxin.MoTaVacXin,Client.CMND,Benh.MaBenh,Benh.TenBenh,Benh.MoTa "
            		+ ",Vacxin.SoMuiCanTiem , Vacxin.SoNgayTiepTheo,LichTiem.MaDiaDiem,LichTiem.MuiThu "
            		+ "from LichTiem inner join Vacxin on LichTiem.MaVacxin = Vacxin.MaVacxin "
            		+ "inner join Benh on LichTiem.MaBenh = Benh.MaBenh "
            		+ "inner join DiaDiem on DiaDiem.MaDiaDiem = LichTiem.MaDiaDiem "
            		+ "inner join TrangThaiLichTiem on TrangThaiLichTiem.MaTrangThaiLichTiem = LichTiem.MaTrangThaiLichTiem "
            		+ "inner join Client on LichTiem.SDT = Client.SDT "
            		+ "inner join Phuong on DiaDiem.MaPhuong = Phuong.Maphuong "
            		+ "inner join Quan on Phuong.MaQuan = Quan.MaQuan "
            		+ "where LichTiem.MaLichTiem = ?"
            		);
            t.setString(1, malich);
            ResultSet rs = t.executeQuery();
            if(rs.next())
            {
            	String add = rs.getString(5)+","+rs.getString(6)+","+rs.getString(7);
            	item = new Schedule(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), add, 
            			rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12)
            			,rs.getString(13),rs.getString(14),rs.getInt(15),rs.getInt(16),rs.getString(17),rs.getInt(18));           	
            	
            	
            }
            conn.close();
			}
			catch(Exception e)
			{
				System.out.print("khong ket noi dc sql : detailschedule");
				
			}	
		return item;
	}
	public  void UpdateScheDate(String MaLichTiem,Date date)
	{
		try
		{
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement t = conn.prepareStatement("update LichTiem set NgayHen=? where MaLichTiem=?");
            t.setDate(1, date);
            t.setString(2, MaLichTiem);

            t.executeUpdate();
            conn.close();
			}
			catch(Exception e)
			{
				System.out.print("khong ket noi dc sql");
				
			}	
	}
	public  void UpdateStatusSche(String[] MaLichTiem,String MaTrangThai)
	{
		try
		{
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement t;
            for(int i =0 ;i<MaLichTiem.length;i++)
            {
            t = conn.prepareStatement("update LichTiem set MaTrangThaiLichTiem=? where MaLichTiem=?");
            t.setString(1, MaTrangThai);
            t.setString(2, MaLichTiem[i]);
            t.executeUpdate();
            Schedule temp = this.DetailSche(MaLichTiem[i]);
            t= conn.prepareStatement("select COUNT(*) as total from LichSuTiem where MaVacxin=? and SDT=?");
            t.setString(1,temp.getIDVaccine());
            t.setString(2,temp.getPhone());
            ResultSet rs = t.executeQuery();
            rs.next();
            int indexVac = rs.getInt(1);
            if(MaTrangThai=="5")
            {
            History his = new History(temp.getIDVaccine(),temp.getPhone(),temp.getDate(),indexVac+1,temp.getIDVaccine(),temp.getIDBenh());
            this.addHist(his);
            if(temp.getNumVaccine()>1&&(temp.getNumVaccine()>indexVac))
            {           	
            	this.addScheduleAgain(temp);   
            	System.out.print("num vacxin : "+temp.getIndexVac());
            }
            }
            }
            conn.close();
			}
			catch(Exception e)
			{
				System.out.print("khong ket noi dc sql : updatesstatussche");
				
			}	
	}
	public void addScheduleAgain(Schedule temp)
	{
		try
		{
			String date = temp.getDate().toString();
			SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd" );
			Calendar cal = Calendar.getInstance();
			cal.setTime( dateFormat.parse( date ) );
			cal.add( Calendar.DATE, temp.getNextDate() );
			java.util.Date datE = cal.getTime();
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement t = conn.prepareStatement("insert into LichTiem(SDT,NgayHen,MaDiaDiem,MaTrangThaiLichTiem,MuiThu,MaVacxin,MaBenh) "
            		+ " values(?,?,?,?,?,?,?)");
            t.setString(1,temp.getPhone() );
            t.setDate(2,new java.sql.Date(datE.getTime()));
            t.setString(3,temp.getIDAdd() );
            t.setString(4,"4");
            t.setInt(5,(temp.getIndexVac()+1));
            System.out.print(""+(temp.getIndexVac()+1));
            t.setString(6,temp.getIDVaccine());
            t.setString(7,temp.getIDBenh());
            t.executeUpdate();
            conn.close();
            }
			catch(Exception e)
			{
				System.out.print("khong ket noi dc sql : add schedule");
				
			}	
	}
	public void DeleteSche(String[] MalichTiem)
	{
		try
		{
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
            for(int i =0;i<MalichTiem.length;i++)
            {
            PreparedStatement t = conn.prepareStatement("delete from LichTiem where MaLichTiem=?");
            t.setString(1, MalichTiem[i]);
            t.executeUpdate();
			}
            conn.close();
            }
			catch(Exception e)
			{
				System.out.print("khong ket noi dc sql");
				
			}	
	}
	public  ArrayList<StatusSche> GetListStateSchedule()
	{
		ArrayList<StatusSche> list = new ArrayList<StatusSche>();
		try
		{
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement t = conn.prepareStatement("select * from TrangThaiLichTiem");
            ResultSet rs = t.executeQuery();
            while(rs.next())
            {
            	StatusSche a = new StatusSche(rs.getString(1), rs.getString(2));
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
	public  ArrayList<History> GetListHistorySimple()
	{
		ArrayList<History> list = new ArrayList<History>();
		try
		{
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement t = conn.prepareStatement("select * from LichSuTiem");
            ResultSet rs = t.executeQuery();
            while(rs.next())
            {
            	History a = new History(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getInt(5));
            	list.add(a);
            }
            conn.close();
			}
			catch(Exception e)
			{
				System.out.print("khong ket noi dc sql history");
				
			}
		
		return list;
	}
	public  ArrayList<History> GetListHistoryDetail()
	{
		ArrayList<History> list = new ArrayList<History>();
		try
		{
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement t = conn.prepareStatement("select LichSuTiem.MaLichSuTiem,LichSuTiem.SDT, "
            		+ "LichSuTiem.NgayTiem,LichSuTiem.MuiThu,Vacxin.MaVacxin, "
            		+ "Vacxin.TenVacXin,Vacxin.MoTaVacXin,Benh.MaBenh,Benh.TenBenh,Benh.mota "
            		+ "from LichSuTiem inner join Vacxin on  "
            		+ "LichSuTiem.MaVacxin = Vacxin.MaVacxin "
            		+ "inner join Benh on LichSuTiem.MaBenh = Benh.MaBenh");
            ResultSet rs = t.executeQuery();
            
            while(rs.next())
            {
            	History a = new History(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getString(5)
            			,rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
            	list.add(a);
            }
            
            conn.close();
			}
			catch(Exception e)
			{
				System.out.print("khong ket noi dc sql : getlistdetailHist");
				
			}	
		System.out.print("so row history:"+list.size());
		return list;
	}
	public  void DeleteHist(String a[])
	{
		try
		{
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
            for(int i =0;i< a.length;i++)
            {
            PreparedStatement t = conn.prepareStatement("delete from LichSuTiem where MaLichSuTiem=?");
            t.setString(1, a[i]);
            t.executeUpdate();
            }
            conn.close();
			}
			catch(Exception e)
			{
				System.out.print("khong ket noi dc sql");
				
			}	
	}
	public void addHist(History a)
	{
		try
		{
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement t = conn.prepareStatement("insert into LichSuTiem(SDT,NgayTiem,MuiThu,MaVacxin,MaBenh)"
            		+ " values(?,?,?,?,?)");
            t.setString(1, a.getCMND());
            t.setDate(2, a.getDate());
            t.setInt(3, a.getNum());
            t.setString(4, a.getIDVac());
            t.setString(5, a.getIDBenh());
            t.executeUpdate();
            conn.close();
			}
			catch(Exception e)
			{
				System.out.print("khong ket noi dc sql : addhist");				
			}	
			
	}
	public  ArrayList<History> GetListHistoryDetail(String like)
	{
		like = "%"+like.trim()+"%";
		ArrayList<History> list = new ArrayList<History>();
		try
		{
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement t = conn.prepareStatement("select LichSuTiem.MaLichSuTiem,LichSuTiem.SDT, "
            		+ "LichSuTiem.NgayTiem,LichSuTiem.MuiThu,Vacxin.MaVacxin, "
            		+ "Vacxin.TenVacXin,Vacxin.MoTaVacXin,Benh.MaBenh,Benh.TenBenh,Benh.mota "
            		+ "from LichSuTiem inner join Vacxin on  "
            		+ "LichSuTiem.MaVacxin = Vacxin.MaVacxin "
            		+ "inner join Benh on LichSuTiem.MaBenh = Benh.MaBenh "
            		+ "where (LichSuTiem.SDT like ? or TenVacXin like ? or LichSuTiem.MaVacxin like ? or LichSuTiem.MuiThu like ?)");
            t.setString(1, like);
            t.setString(2, like);
            t.setString(3, like);
            t.setString(4, like);
            ResultSet rs = t.executeQuery();
            
            while(rs.next())
            {
            	History a = new History(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getString(5)
            			,rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
            	list.add(a);
            }
            
            conn.close();
			}
			catch(Exception e)
			{
				System.out.print("khong ket noi dc sql");
				
			}	
		System.out.print("so row history:"+list.size());
		return list;
	}
	public  ArrayList<History> GetListHistoryDetail(Date date)
	{
		ArrayList<History> list = new ArrayList<History>();
		try
		{
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement t = conn.prepareStatement("select LichSuTiem.MaLichSuTiem,LichSuTiem.SDT, "
            		+ "LichSuTiem.NgayTiem,LichSuTiem.MuiThu,Vacxin.MaVacxin, "
            		+ "Vacxin.TenVacXin,Vacxin.MoTaVacXin,Benh.MaBenh,Benh.TenBenh,Benh.mota "
            		+ "from LichSuTiem inner join Vacxin on  "
            		+ "LichSuTiem.MaVacxin = Vacxin.MaVacxin "
            		+ "inner join Benh on LichSuTiem.MaBenh = Benh.MaBenh "
            		+ "where NgayTiem=?");
            t.setDate(1, date);
            ResultSet rs = t.executeQuery();
            
            while(rs.next())
            {
            	History a = new History(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getString(5),
            			rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
            	list.add(a);
            }
            
            conn.close();
			}
			catch(Exception e)
			{
				System.out.print("khong ket noi dc sql");
				
			}	
		System.out.print("so row history:"+list.size());
		return list;
	}
	public  ArrayList<History> GetListHistoryDetail(String like,Date date)
	{
		like = "%"+like+"%";
		ArrayList<History> list = new ArrayList<History>();
		try
		{
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement t = conn.prepareStatement("select LichSuTiem.MaLichSuTiem,LichSuTiem.SDT, "
            		+ "LichSuTiem.NgayTiem,LichSuTiem.MuiThu,Vacxin.MaVacxin, "
            		+ "Vacxin.TenVacXin,Vacxin.MoTaVacXin,Benh.MaBenh,Benh.TenBenh,Benh.mota "
            		+ "from LichSuTiem inner join Vacxin on  "
            		+ "LichSuTiem.MaVacxin = Vacxin.MaVacxin "
            		+ "inner join Benh on LichSuTiem.MaBenh = Benh.MaBenh "
            		+ "where NgayTiem=? and (LichSuTiem.CMND like ? or TenVacXin like ? or LichSuTiem.MaVacxin like ? or LichSuTiem.MuiThu like ?)");
            t.setDate(1, date);
            t.setString(2, like);
            t.setString(3, like);
            t.setString(4, like);
            t.setString(5, like);
            ResultSet rs = t.executeQuery();
            
            while(rs.next())
            {
            	History a = new History(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getString(5)
            			,rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
            	list.add(a);
            }
            
            conn.close();
			}
			catch(Exception e)
			{
				System.out.print("khong ket noi dc sql");
				
			}	
		System.out.print("so row history:"+list.size());
		return list;
	}
	public  ArrayList<Phuong> GetListPhuong(String idQuan)
	{
		ArrayList<Phuong> list = new ArrayList<Phuong>();
		try
		{
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement t = conn.prepareStatement("select * from Phuong where MaQuan=?");
            t.setString(1, idQuan);
            ResultSet rs = t.executeQuery();
            while(rs.next())
            {
            	Phuong a = new Phuong(rs.getString(1), rs.getString(2), rs.getString(3));
            	list.add(a);
            }
            conn.close();
			}
			catch(Exception e)
			{
				System.out.print("khong ket noi dc sql list phuong");				
			}	
		return list;
	}
	public  ArrayList<Phuong> GetListPhuong()
	{
		ArrayList<Phuong> list = new ArrayList<Phuong>();
		try
		{
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement t = conn.prepareStatement("select * from Phuong");
            ResultSet rs = t.executeQuery();
            while(rs.next())
            {
            	Phuong a = new Phuong(rs.getString(1), rs.getString(2), rs.getString(3));
            	list.add(a);
            }
            conn.close();
			}
			catch(Exception e)
			{
				System.out.print("khong ket noi dc sql list phuong");				
			}	
		return list;
	}
	public  ArrayList<Quan> GetListQuan()
	{
		ArrayList<Quan> list = new ArrayList<Quan>();
		try
		{
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement t = conn.prepareStatement("select * from Quan");
            ResultSet rs = t.executeQuery();
            while(rs.next())
            {
            	Quan a = new Quan(rs.getString(1), rs.getString(2));
            	list.add(a);
            }
            conn.close();
			}
			catch(Exception e)
			{
				System.out.print("khong ket noi dc sql list quan");				
			}	
		return list;
	}
	public ArrayList<Location> GetListLocation()
	{
		ArrayList<Location> list = new ArrayList<Location>();
		try
		{
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement t = conn.prepareStatement("select DiaDiem.MaDiaDiem,DiaDiem.TenDiaDiem,DiaDiem.SoNha, "
            		+ "DiaDiem.MaPhuong,Phuong.TenPhuong,Phuong.MaQuan,Quan.TenQuan "
            		+ ",DiaDiem.ThanhPho,DiaDiem.Soluong,DiaDiem.MaTrangThai, "
            		+ "TrangThaiHoatDong.TenTrangThai "
            		+ "from DiaDiem inner join TrangThaiHoatDong on DiaDiem.MaTrangThai = TrangThaiHoatDong.MaTrangThai "
            		+ "inner join Phuong on DiaDiem.MaPhuong = Phuong.Maphuong "
            		+ "inner join Quan on Phuong.MaQuan = Quan.MaQuan");
            ResultSet rs = t.executeQuery();
            while(rs.next())
            {
            	Location a = new Location(rs.getString(1), rs.getString(2), rs.getString(3), 
            			 rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7), rs.getString(8),
            			 rs.getString(9), rs.getString(10), rs.getString(11));
            	list.add(a);
            }
            conn.close();
			}
			catch(Exception e)
			{
				System.out.print("khong ket noi dc sql list dia diem");				
			}	
		return list;
	}
	public ArrayList<Location> GetListLocation(String ID)
	{
		ArrayList<Location> list = new ArrayList<Location>();
		try
		{
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement t = conn.prepareStatement("select DiaDiem.MaDiaDiem,DiaDiem.TenDiaDiem,DiaDiem.SoNha, "
            		+ "DiaDiem.MaPhuong,Phuong.TenPhuong,Phuong.MaQuan,Quan.TenQuan "
            		+ ",DiaDiem.ThanhPho,DiaDiem.Soluong,DiaDiem.MaTrangThai, "
            		+ "TrangThaiHoatDong.TenTrangThai "
            		+ "from DiaDiem inner join TrangThaiHoatDong on DiaDiem.MaTrangThai = TrangThaiHoatDong.MaTrangThai "
            		+ "inner join Phuong on DiaDiem.MaPhuong = Phuong.Maphuong "
            		+ "inner join Quan on Phuong.MaQuan = Quan.MaQuan"
            		+ " where Quan.MaQuan=?");
            t.setString(1, ID);
            ResultSet rs = t.executeQuery();
            while(rs.next())
            {
            	Location a = new Location(rs.getString(1), rs.getString(2), rs.getString(3), 
            			 rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7), rs.getString(8),
            			 rs.getString(9), rs.getString(10), rs.getString(11));
            	list.add(a);
            }
            conn.close();
			}
			catch(Exception e)
			{
				System.out.print("khong ket noi dc sql list dia diem");				
			}	
		return list;
	}
	public  ArrayList<StatusLocation> GetListStatusLocation()
	{
		ArrayList<StatusLocation> list = new ArrayList<StatusLocation>();
		try
		{
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement t = conn.prepareStatement("select * from TrangThaiHoatDong");
            ResultSet rs = t.executeQuery();
            while(rs.next())
            {
            	StatusLocation a = new StatusLocation(rs.getString(1), rs.getString(2));
            	list.add(a);
            }
            conn.close();
			}
			catch(Exception e)
			{
				System.out.print("khong ket noi dc sql list status");				
			}	
		return list;
	}
	public void UpdateLocation(Location temp)
	{
		try
		{
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement t = conn.prepareStatement("update DiaDiem set TenDiaDiem = ? , SoNha=?,MaPhuong=?,MaTrangThai=?,Soluong=? "
            		+ "where MaDiaDiem =?");  
            t.setString(1, temp.getNameLocation());
            t.setString(2, temp.getAddress());
            t.setString(3, temp.getIDPhuong());
            t.setString(4, temp.getIDStatus());
            t.setString(5, temp.getNum());
            t.setString(6, temp.getIDLocation());
            t.executeUpdate();
            conn.close();
			}
			catch(Exception e)
			{
				System.out.print("khong ket noi dc sql list status");				
			}	
	}
	public void AddLocation(Location temp)
	{
		try
		{
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement t = conn.prepareStatement("insert into DiaDiem(TenDiaDiem,SoNha,MaPhuong,ThanhPho,MaTrangThai,Soluong) "
            		+ "values(?,?,?,'Da Nang',?,?)"); 
            
            t.setString(1, temp.getNameLocation());
            t.setString(2, temp.getAddress());
            t.setString(3, temp.getIDPhuong());
            t.setString(4, temp.getIDStatus());
            t.setString(5, temp.getNum());
            t.executeUpdate();
            conn.close();
			}
			catch(Exception e)
			{
				System.out.print("khong ket noi dc sql list status");				
			}
	}
	public void DeleteLocation(String idLocation)
	{
		try
		{
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PBL;user=sa;password=1234";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement t = conn.prepareStatement("delete from DiaDiem where MaDiaDiem=?");            
            t.setInt(1, Integer.parseInt(idLocation));
            t.executeUpdate();
            conn.close();
			}
			catch(Exception e)
			{
				System.out.print("khong ket noi dc sql list status");				
			}
	}
	
	
	
}
