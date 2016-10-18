package Model;

import java.util.Date;

public class Market {
	private Integer id;
	private Integer amount; //amount,unitPrice£¬saleDate£¬_salesman£¬_customer£¬customerphone
	private float unitPrice;
	private Date saleDate;
	private String _salesman;//productName,productNumber,notes
	
	private String _customer;
	private String customerphone;
	private String productName;
	private String productNumber;
	private String notes;
	
	
	public void setId(Integer i)
	{
		id=i;
	}
	
	public Integer getId()
	{
		return id;
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
	
	public Date getsaleDate()
	{
		return saleDate;
	}
	
	public void setsaleDate(Date str)
	{
		saleDate=str;
	}
	
	public String get_salesman()
	{
		return _salesman;
	}
	
	
	public void set_salesman(String p)
	{
		_salesman=p;
	}
	
	public String get_customer()
	{
		return _customer;
	}
	
	
	public void set_customer(String p)
	{
		_customer=p;
	}
	
	public void setcustomerPhone(String p)
	{
		customerphone=p;
	}
	
	public String getcustomerPhone()
	{
		return customerphone;
	}
	
	
	public void setproductName(String p)
	{
		productName=p;
	}
	
	public String getproductName()
	{
		return productName;
	}
	
	
	public void setproductNumber(String p)
	{
		productNumber=p;
	}
	
	public String getproductNumber()
	{
		return productNumber;
	}
	
	
	public void setnotes(String p)
	{
		notes=p;
	}
	
	public String getnotes()
	{
		return notes;
	}
	
	public Market() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Market [Id=" + id  + "amount"+ amount + "unitPrice" + unitPrice +
				"saleDate" + saleDate + "_salesman" + _salesman + "_customer" + 
				_customer + "customerphone" + customerphone + "productName" +  
				productName +"productNumber" + productNumber + "notes" +   notes
				+  "]";
	}
	
}
