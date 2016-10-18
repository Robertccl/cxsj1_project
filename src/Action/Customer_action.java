package Action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import Model.Customer;
import Operate.Customer_operate;

public class Customer_action {
	public void add(Customer temp) throws Exception{
		Customer_operate sales=new Customer_operate();
		sales.addCustomer(temp);
	}

	
	public void edit(Customer temp) throws Exception{
		Customer_operate sales=new Customer_operate();
		sales.updateCustomer(temp);
	}
	public void del(Integer id) throws Exception{
		Customer_operate sales=new Customer_operate();
		sales.deleteCustomer(id);
	}
	
	public List<Customer>  query(String num) throws Exception{
		Customer_operate sales=new Customer_operate();
		return sales.query(num);
		
	}
	public List<Customer> query(List<Map<String, Object>> params) throws Exception{
		Customer_operate sales=new Customer_operate();
		return sales.query(params);
	}
	
	
	public Customer get(Integer id) throws SQLException{
		Customer_operate sales=new Customer_operate();
		return sales.get(id);
	}

}
