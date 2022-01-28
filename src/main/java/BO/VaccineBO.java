package BO;

import java.util.ArrayList;

import BEAN.PhongBenh;
import BEAN.Vaccine;
import BEAN.disease;
import DAO.VaccineDAO;

public class VaccineBO {
	VaccineDAO a = new VaccineDAO();
	public  ArrayList<Vaccine> listVac()
	{
		return a.listVac();
	}
	public  ArrayList<disease> listBenh()
	{
		return a.listBenh();
	}
	public  ArrayList<PhongBenh> listPhongBenh()
	{
		return a.listPhongBenh();
	}
	public void AddPhongBenh(String idVac,String idBenh)
	{
		a.AddPhongBenh(idVac, idBenh);
	}
	public void DeletePB(String[] listPBDel)
	{
		a.DeletePB(listPBDel);
	}
	public  ArrayList<disease> listBenh(String mavc)
	{
		return a.listBenh(mavc);
	}
	public  Vaccine getVac(String ma)
	{
		return a.getVac(ma);
	}
	public void UpdateVac(String id,String name,String num,String nextDate,String dec)
	{
		a.UpdateVac(id, name, num, nextDate, dec);
	}
	public void AddVac(String id,String name,String num,String nextDate,String dec)
	{
		a.AddVac(id, name, num, nextDate, dec);
	}
	public void DeleteVac(String[] id)
	{
		a.DeleteVac(id);
	}
	public disease GetBenh(String idbenh)
	{
		return a.GetBenh(idbenh);
	}
	public void addBenh(String name,String mota)
	{
		a.addBenh(name, mota);
	}
	public void DeleteBenh(String[] id)
	{
		a.DeleteBenh(id);
	}
	public void updateBenh(String idbenh,String name,String mota)
	{
		a.updateBenh(idbenh, name, mota);
	}
	
}
