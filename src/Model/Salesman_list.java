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
		System.out.println("��������");
		node.number=cin.next();
		System.out.println("����������");
		node.name=cin.next();
		System.out.println("�������Ա�");
		node.gender=cin.next();
		System.out.println("�������������");
		node.birthDate=cin.next();
		System.out.println("������绰");
		node.phone=cin.next();
		System.out.println("�������ַ");
		node.address=cin.next();
		System.out.println("��������ְʱ��");
		node.employedDate=cin.next();
	}
	
	public void InputNumber(Salesman node)
	{
		System.out.println("��������");
		node.number=cin.next();
	}
	
	public void Add()
	{
		int chose=1;
		System.out.println("�����������Ϣ");
		while(chose>0)
		{
			Salesman tempNode=new Salesman();
			Input(tempNode);
			list.add(tempNode);
			System.out.println("�Ƿ������ӣ�1.��        0.��");
			chose=cin.nextInt();
		}
		
	}
	
	public int Search()
	{
		System.out.println("�����������");
		Salesman temprhs=new Salesman();
		Input(temprhs);
		int chose=1;
		int index=0;
		
		while(chose>0)
		{
			index=list.indexOf(temprhs);
			Display(index);
			System.out.println("�Ƿ�������ң�1.��       0 .��");
			chose=cin.nextInt();
		}
		return index;
	}
	
	public void Remove()
	{
		System.out.println("�����������");
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
			System.out.println("�Ƿ����ɾ����1.��        0.��");
			chose=cin.nextInt();
		}
	}
	
	
	
	public void Update()
	{
		System.out.println("�����������");
		Salesman temprhs=new Salesman();
		Input(temprhs);
		int index;
		String chose=null;
		String tempData=null;
		
		index=Search();
		
		Display(index);
		Salesman rhs=new Salesman();
		rhs=list.get(index);
		
		System.out.println("�������޸�ѡ�number,name,gender,birthDate,phone,address,employedData");
		chose=cin.next();
		switch(chose)
		{
			case "number": System.out.println("��������"); rhs.number=cin.next(); break;
			case "name": System.out.println("��������"); rhs.name=cin.next(); break;
			case "gender": System.out.println("��������"); rhs.gender=cin.next(); break;
			case "birthDate": System.out.println("��������"); rhs.birthDate=cin.next(); break;
			case "phone": System.out.println("��������"); rhs.phone=cin.next(); break;
			case "address": System.out.println("��������"); rhs.address=cin.next(); break;
			case "employedDate": System.out.println("��������"); rhs.employedDate=cin.next(); break;
			default :;
		}
		
	}
	
	public void Display(int index)
	{
		Salesman rhs=new Salesman();
		rhs=list.get(index);
		System.out.println("��ţ�"+rhs.number);
		System.out.println("������"+rhs.name);
		System.out.println("�Ա�"+rhs.gender);
		System.out.println("�������ڣ�"+rhs.birthDate);
		System.out.println("�绰��"+rhs.phone);
		System.out.println("��ַ��"+rhs.address);
		System.out.println("��ְʱ�䣺"+rhs.employedDate);
	}
	
	public void Run()
	{
		String chose=null;
	
		String chose_num = null;
		
		while(true)
		{
			System.out.println("�����������add,search,update,delete");
			chose=cin.next();
		if(chose.equals("add"))
		{
			Add();
		} 
		else if(chose.equals("search"))
		{
			System.out.println("�����������");
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