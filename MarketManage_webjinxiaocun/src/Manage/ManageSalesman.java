package Manage;

import java.util.Date;
import java.util.List;


import Model.Salesman;
import Operate.SalesmanOperate;

public class ManageSalesman {
	
	public  void  AddSalesman(Salesman salesman){
		
		SalesmanOperate salesmanOperate=new SalesmanOperate();
		if(salesmanOperate.QueryNumber(salesman.getNumber()) == 0)
		
		salesmanOperate.Add(salesman);
	}
	
	public  void  RemoveSalesman(String number){
		SalesmanOperate salesmanOperate=new SalesmanOperate();
		int id=salesmanOperate.QueryNumber(number);
		System.out.println(id);
		salesmanOperate.Remove(id);
	}
	
	public  void  UpdateSalesman(Salesman salesman){
		SalesmanOperate salesmanOperate=new SalesmanOperate();
		int id=salesmanOperate.QueryNumber(salesman.getNumber());
		System.out.println(id);
		salesmanOperate.Update(id, salesman);
	}
	
	public  List<Salesman>  QuerySalesman(Salesman salesman){
		List<Salesman> list=null;
		SalesmanOperate salesmanOperate=new SalesmanOperate();
		list=salesmanOperate.QueryName(salesman.getName());
		//System.out.println(id);
		//salesmanOperate.Search(id);
		return list;
	}
	
	
	
	
}
