package Action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import Model.Salesman;
import Operate.Salesman_operate;

public class Salesman_action {
	
	public void add(Salesman salesman) throws Exception{
		Salesman_operate sales=new Salesman_operate();
		sales.addSalesman(salesman);
	}

	
	public void edit(Salesman salesman) throws Exception{
		Salesman_operate sales=new Salesman_operate();
		sales.updateSalesman(salesman);
	}
	public void del(Integer id) throws Exception{
		Salesman_operate sales=new Salesman_operate();
		sales.deleteSalesman(id);
	}
	
	public List<Salesman>  query(String num) throws Exception{
		Salesman_operate sales=new Salesman_operate();
		return sales.query(num);
		
	}
	public List<Salesman> query(List<Map<String, Object>> params) throws Exception{
		Salesman_operate sales=new Salesman_operate();
		return sales.query(params);
	}
	
	
	public Salesman get(Integer id) throws SQLException{
		Salesman_operate sales=new Salesman_operate();
		return sales.get(id);
	}
}
