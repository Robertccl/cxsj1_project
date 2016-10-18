package Operate;

import Model.Users;

public class UserDAO {
	public boolean userLogin(Users u)
	{
		if("admin".equals(u.getUsername())&&"admin".equals(u.getPassword()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	

}
