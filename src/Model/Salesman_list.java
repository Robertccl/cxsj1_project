package Model;
/*
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Salesman_list {
	LinkedList <Salesman> list=new LinkedList<Salesman>();
	public Scanner cin=new Scanner(System.in);
	
	public Salesman_list()
	{}
	
	
	public void Input(Salesman node)
	{
		System.out.println("请输入编号");
		node.number=cin.next();
		System.out.println("请输入姓名");
		node.name=cin.next();
		System.out.println("请输入性别");
		node.gender=cin.next();
		System.out.println("请输入出生日期");
		node.birthDate=cin.next();
		System.out.println("请输入电话");
		node.phone=cin.next();
		System.out.println("请输入地址");
		node.address=cin.next();
		System.out.println("请输入入职时间");
		node.employedDate=cin.next();
	}
	
	public void InputNumber(Salesman node)
	{
		System.out.println("请输入编号");
		node.number=cin.next();
	}
	
	public void Add()
	{
		int chose=1;
		System.out.println("请输入添加信息");
		while(chose>0)
		{
			Salesman tempNode=new Salesman();
			Input(tempNode);
			list.add(tempNode);
			System.out.println("是否继续添加！1.是        0.否");
			chose=cin.nextInt();
		}
		
	}
	
	public int Search()
	{
		System.out.println("输入查找内容");
		Salesman temprhs=new Salesman();
		Input(temprhs);
		int chose=1;
		int index=0;
		
		while(chose>0)
		{
			index=list.indexOf(temprhs);
			Display(index);
			System.out.println("是否继续查找！1.是       0 .否");
			chose=cin.nextInt();
		}
		return index;
	}
	
	public void Remove()
	{
		System.out.println("输入查找内容");
		Salesman temprhs=new Salesman();
		Input(temprhs);
		
		int chose=1;
		int index=0;
		
		while(chose>0)
		{
			index=Search();
			if(!list.isEmpty())
			{
				list.remove(index);
			}
			System.out.println("是否继续删除！1.是        0.否");
			chose=cin.nextInt();
		}
	}
	
	
	
	public void Update()
	{
		System.out.println("输入查找内容");
		Salesman temprhs=new Salesman();
		Input(temprhs);
		int index;
		String chose=null;
		String tempData=null;
		
		index=Search();
		
		Display(index);
		Salesman rhs=new Salesman();
		rhs=list.get(index);
		
		System.out.println("请输入修改选项：number,name,gender,birthDate,phone,address,employedData");
		chose=cin.next();
		switch(chose)
		{
			case "number": System.out.println("输入内容"); rhs.number=cin.next(); break;
			case "name": System.out.println("输入内容"); rhs.name=cin.next(); break;
			case "gender": System.out.println("输入内容"); rhs.gender=cin.next(); break;
			case "birthDate": System.out.println("输入内容"); rhs.birthDate=cin.next(); break;
			case "phone": System.out.println("输入内容"); rhs.phone=cin.next(); break;
			case "address": System.out.println("输入内容"); rhs.address=cin.next(); break;
			case "employedDate": System.out.println("输入内容"); rhs.employedDate=cin.next(); break;
			default :;
		}
		
	}
	
	public void Display(int index)
	{
		Salesman rhs=new Salesman();
		rhs=list.get(index);
		System.out.println("编号："+rhs.number);
		System.out.println("姓名："+rhs.name);
		System.out.println("性别"+rhs.gender);
		System.out.println("出生日期："+rhs.birthDate);
		System.out.println("电话："+rhs.phone);
		System.out.println("地址："+rhs.address);
		System.out.println("入职时间："+rhs.employedDate);
	}
	
	public void Run()
	{
		String chose=null;
	
		String chose_num = null;
		
		while(true)
		{
			System.out.println("请输入操作：add,search,update,delete");
			chose=cin.next();
		if(chose.equals("add"))
		{
			Add();
		} 
		else if(chose.equals("search"))
		{
			System.out.println("输入查找内容");
			int index;
			index=Search();
			Display(index);
		}
		else if(chose.equals("update"))
		{
			//chose_num=cin.next();
			Update();
		}
		else if(chose.equals("delete"))
		{
			
			Remove();
		}
		}
		
	}
		
		
		public static void main(String[] args)
		{
			Salesman_list list=new Salesman_list();
			list.Run();
		}
	
	 
	
}
*/