package BO;
import java.sql.Date;
import java.util.ArrayList;

import BEAN.History;
import BEAN.Location;
import BEAN.Phuong;
import BEAN.Quan;
import BEAN.Schedule;
import BEAN.StatusLocation;
import BEAN.StatusSche;
import DAO.ScheAndHistDAO;
public class ScheAndHistBO {
	ScheAndHistDAO a = new ScheAndHistDAO();
	public  ArrayList<Schedule> simpleScheBO(String idsta,String option)
	{
		return a.simpleSche(idsta,option);
	}
	public  Schedule DetailScheBO(String malich)
	{
		return a.DetailSche(malich);
	}
	public  void UpdateScheBO(String MaVaccine,Date date)
	{
		a.UpdateScheDate(MaVaccine,date);
	}
	public  void UpdateStatusScheBO(String[] MaLichTiem,String MaTrangThai)
	{
		a.UpdateStatusSche(MaLichTiem, MaTrangThai);
	}
	public void DeleteScheBO(String[] MalichTiem)
	{
		a.DeleteSche(MalichTiem);
	}
	public  ArrayList<StatusSche> GetListStateScheduleBO()
	{
		return a.GetListStateSchedule();
	}
	public  ArrayList<History> GetListHistorySimpleBO()
	{
		return a.GetListHistorySimple();
	}
	public  ArrayList<History> GetListHistoryDetailBO()
	{
		return a.GetListHistoryDetail();
	}
	public  ArrayList<History> GetListHistoryDetailBO(Date d)
	{
		return a.GetListHistoryDetail(d);
	}
	public  ArrayList<History> GetListHistoryDetailBO(String d)
	{
		return a.GetListHistoryDetail(d);
	}
	public  ArrayList<History> GetListHistoryDetailBO(String t,Date d)
	{
		return a.GetListHistoryDetail(t,d);
	}
	public  void DeleteHist(String t[])
	{
		a.DeleteHist(t);
	}
	public ArrayList<Phuong> GetListPhuong(String idquan)
	{
		return a.GetListPhuong(idquan);
	}
	public ArrayList<Phuong> GetListPhuong()
	{
		return a.GetListPhuong();
	}
	public ArrayList<Quan> getlistQuan()
	{
		return a.GetListQuan();
	}
	public ArrayList<Location> getListLocations()
	{
		return a.GetListLocation();
	}
	public ArrayList<Location> getListLocations(String t)
	{
		return a.GetListLocation(t);
	}
	public ArrayList<StatusLocation> getListStatusLocation()
	{
		return a.GetListStatusLocation();
	}
	public void UpdateLocation(Location temp)
	{
		a.UpdateLocation(temp);
	}
	public void AddLocation(Location temp)
	{
		a.AddLocation(temp);
	}
	public void DeleteLocation(String idlocation)
	{
		a.DeleteLocation(idlocation);
	}
}
