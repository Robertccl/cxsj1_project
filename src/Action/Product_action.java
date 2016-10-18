package Action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import Model.Product;
import Operate.Product_operate;

public class Product_action {
	
	public void add(Product temp) throws Exception{
		Product_operate sales=new Product_operate();
		sales.addProduct(temp);
	}

	
	public void edit(Product temp) throws Exception{
		Product_operate sales=new Product_operate();
		sales.updateProduct(temp);
	}
	public void del(Integer id) throws Exception{
		Product_operate sales=new Product_operate();
		sales.deleteProduct(id);
	}
	
	public List<Product>  query(String num) throws Exception{
		Product_operate sales=new Product_operate();
		return sales.query(num);
		
	}
	public List<Product> query(List<Map<String, Object>> params) throws Exception{
		Product_operate sales=new Product_operate();
		return sales.query(params);
	}
	
	
	public Product get(Integer id) throws SQLException{
		Product_operate sales=new Product_operate();
		return sales.get(id);
	}

}
