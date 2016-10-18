
package Model;

import java.util.Date;

public class Product {
	
	private Integer id;
	private String name;
	private String number;
	private Integer amount; 
	private float unitPrice;
	private String _producer;
	private Date stockDate;

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
	
	public void setAmount(Integer i)
	{
		amount=i;
	}
	
	public Integer getAmount()
	{
		return amount;
	}
	
	public void setunitPrice(float f)
	{
		unitPrice=f;
	}
	
	public float getunitPrice()
	{
		return unitPrice;
	}
	
	public Date getstockDate()
	{
		return stockDate;
	}
	
	public void setstockDate(Date str)
	{
		stockDate=str;
	}
	
	public String get_producer()
	{
		return _producer;
	}
	
	
	public void set_producer(String p)
	{
		_producer=p;
	}
	
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Product [Id=" + id  + ", number=" + number + ", name="
				+ name + ", amount=" + amount + ", unitPrice=" + unitPrice + ", _producer="
				+ _producer +  ", stockDate=" + stockDate + "]";
	}
	
	
	
	
}
