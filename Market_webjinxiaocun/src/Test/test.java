package Test;

import java.util.Date;
import java.util.List;

import Manage.ManageSalesman;
import Model.Salesman;

public class test {

	public static void main(String[] args) {
		List<Salesman> list=null;
		ManageSalesman manageSalesman=new ManageSalesman();
		//SalesmanOperate salesmanOperate=new SalesmanOperate();
		Salesman salesman=new Salesman("1106", "³Â´æÁ¸" ,"ÄÐ","1996-1-1","1234567890","º¼µç",new Date().toString());
		//UpdateSalesman(salesman);
		//manageSalesman.AddSalesman(salesman);
		//manageSalesman.RemoveSalesman("000");
		list=manageSalesman.QueryAllSalesman();
		//manageSalesman.QuerySalesman(salesman);
		System.out.println(list.get(1));
	}


}
