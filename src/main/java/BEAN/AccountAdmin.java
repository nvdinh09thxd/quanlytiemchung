package BEAN;

public class AccountAdmin {
	private String username;
	private String password;
	public AccountAdmin(String username)
	{
		this.username = username;
		
	}
	public String getUsername()
	{
		return this.username;
	}
	public String getPassword()
	{
		return this.password;
	}
}
