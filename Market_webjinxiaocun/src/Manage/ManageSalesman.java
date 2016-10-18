package Manage;

import java.util.Date;
import java.util.List;


import Model.Salesman;
import Operate.SalesmanOperate;

public class ManageSalesman {
	
	public  void  AddSalesman(Salesman salesman){
		System.out.println("nihao");
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
	
	public  void  RemoveSalesman(int id){
		SalesmanOperate salesmanOperate=new SalesmanOperate();
		System.out.println(id);
		salesmanOperate.Remove(id);
	}
	
	public  void  UpdateSalesman(int id,Salesman salesman){
		SalesmanOperate salesmanOperate=new SalesmanOperate();
		//int id=salesmanOperate.QueryNumber(salesman.getNumber());
		System.out.println(id);
		salesmanOperate.Update(id, salesman);
	}
	
	public  List<Salesman>  QuerySalesman(Salesman salesman){
		List<Salesman> list=null;
		SalesmanOperate salesmanOperate=new SalesmanOperate();
		list=salesmanOperate.QueryName(salesman.getName());
		//System.out.println(id);
		//salesmanOperate.Search(id);
		System.out.println(list.size());
		return list;
	}
	
	public  List<Salesman>  QueryName(String name){
		List<Salesman> list=null;
		SalesmanOperate salesmanOperate=new SalesmanOperate();
		list=salesmanOperate.LikeName(name);
		//System.out.println(id);
		//salesmanOperate.Search(id);
		System.out.println(list.size());
		return list;
	}
	
	public	Salesman  QueryId(int id){
		Salesman s=null;
		SalesmanOperate salesmanOperate=new SalesmanOperate();
		s=salesmanOperate.Search(id);;
		
		return s;
	}
	
	public  List<Salesman>  QueryAllSalesman(){
		List<Salesman> list=null;
		SalesmanOperate salesmanOperate=new SalesmanOperate();
		list=salesmanOperate.QueryAll();
		//System.out.println(list.size());
		//salesmanOperate.Search(id);
		return list;
	}
	
	
	
	
}
