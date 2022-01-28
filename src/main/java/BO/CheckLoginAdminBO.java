package BO;

import java.util.ArrayList;

import BEAN.AccountAdmin;
import DAO.CheckLoginAdminDAO;


public class CheckLoginAdminBO {
	CheckLoginAdminDAO checkLoginDAO = new CheckLoginAdminDAO();
	public boolean isValidUser(String username,String password)
	{
		return checkLoginDAO.isExisUser(username, password);
	}
	public void addAdmin(String user,String passw)
	{
		checkLoginDAO.addAdmin(user, passw);
	}
	public void DeleteAcc(String[] id)
	{
		checkLoginDAO.DeleteAcc(id);
	}
	public ArrayList<AccountAdmin> listacc(String user)
	{
		return checkLoginDAO.listacc(user);
	}
	public void ChangePass(String user,String newPass)
	{
		checkLoginDAO.ChangePass(user, newPass);
	}
}
