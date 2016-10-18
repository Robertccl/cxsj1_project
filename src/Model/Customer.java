package Model;

public class Customer {
	private Integer id;
	private String name;
	private String phone;
	private String address;
	
	public void setId(Integer i)
	{
		id=i;
	}
	
	public Integer getId()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String n)
	{
		name=n;
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
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Customer [Id=" + id  + ", name="
				+ name + ", phone="
				+ phone + ", address=" + address +  "]";
	}
 
}
