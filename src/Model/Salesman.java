package Model;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Salesman {
	
	private Integer id;
	private String number;
	private String name;
	private String gender;
	private Date birthDate;
	private String phone;
	private String address;
	private Date employedDate;
	
	
	public void setId(Integer i)
	{
		id=i;
	}
	
	public Integer getId()
	{
		return id;
	}
	
	public void setNumber(String num)
	{
		number=num;
	}
	
	public String getNumber()
	{
		return number;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String n)
	{
		name=n;
	}
	
	public void setGender(String g)
	{
		gender=g;
	}
	
	public String getGender()
	{
		return gender;
	}
	
	
	
	public Date getbirthDate()
	{
		return birthDate;
	}
	
	public void setbirthDate(Date str)
	{
		birthDate=str;
	}
	
	public String getPhone()
	{
		return phone;
	}
	
	
	public void setPhone(String p)
	{
		phone=p;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public void setAddress(String a)
	{
		address=a;
	}
	
	public Date getemployedDate()
	{
		return employedDate;
	}
	
	public void setemployedDate(Date e)
	{
		employedDate=e;
	}

	
	
	public Salesman(String t_number,String t_name, String t_gender,Date t_birthDate, 
					String t_phone,String t_address,Date t_employedDate)
	{
		number=t_number;
		name=t_name;
		gender=t_gender;
		birthDate=t_birthDate;
		phone=t_phone;
		address=t_address;
		employedDate=t_employedDate;
		
	}
	
	
	
	public Salesman() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Salesman [Id=" + id  + ", number=" + number + ", name="
				+ name + ", gender=" + gender + ", birthday=" + birthDate + ", phone="
				+ phone + ", address=" + address + ", employedDate=" + employedDate + "]";
	}
	
	/*public boolean equals(Object obj) 
	{  
		 if(this == obj) 
		 {  
		   return true;  
		 }  
		 
		 if(null == obj) 
		 {  
		   return false;  
		 }  
		 
		 if(getClass() != obj.getClass())
		 {  
		   return false;  
		 }  
		  
		 Salesman rhs = (Salesman) obj;  
		 if(!number.equals(rhs.number)) 
		 {  
		  return false;  
		 }  
		 
		  return true;  
		
	
	}
	*/
	
}


