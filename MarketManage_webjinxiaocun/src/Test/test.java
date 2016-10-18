package Test;

import java.util.Date;

import Manage.ManagePassword;
import Model.Password;
import Model.Salesman;

public class test {

	public static void main(String[] args) {
		
		//SalesmanOperate salesmanOperate=new SalesmanOperate();
		Salesman salesman=new Salesman("1004", "³Â´æÁ¸" ,"ÄÐ","1996-1-1","1234567890","º¼µç",new Date().toString());
		//UpdateSalesman(salesman);
		//AddSalesman(salesman);
		//RemoveSalesman("1004");
		ManagePassword managePassword=new ManagePassword();
		Password password=new Password("1234","1","What is you name?","g u n");
		//managePassword.Set(password);
		managePassword.Reset("abc", password);
		//managePassword.RemovePassword(tempAccount);
		
	}


}
