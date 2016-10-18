package Manage;

import Model.Password;
import Operate.PasswordOperate;
import Operate.SalesmanOperate;

public class ManagePassword {
	
	public void Set(Password temp){
		PasswordOperate passwordOperate=new PasswordOperate();
		passwordOperate.Add(temp);
		
	}
	
	public void Reset(String newPassword,Password temp2){         //String oldPassword,
			PasswordOperate passwordOperate=new PasswordOperate();
			int id=passwordOperate.QueryAccount(temp2.getAccount());
			
			passwordOperate.Update(id,newPassword);
		
	}
	
	public boolean Load(String tempAccount ,String tempPassword){
		int id=0;
		Password password=null;
		PasswordOperate passwordOperate=new PasswordOperate();
		id=passwordOperate.QueryAccount(tempAccount);
		password=passwordOperate.Query(id);
		if(tempPassword==password.getPassword())
			return true;
		else
			return false;
	}
	
	public  void  RemovePassword(String tempAccount){
		PasswordOperate passwordOperate=new PasswordOperate();
		int id=passwordOperate.QueryAccount((tempAccount));
		System.out.println(id);
		passwordOperate.Remove(id);
	}
	
}
