package Action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import Model.Market;
import Operate.Market_operate;

public class Market_action {
	
	public void add(Market temp) throws Exception{
		Market_operate sales=new Market_operate();
		sales.addMarket(temp);
	}

	
	public void edit(Market temp) throws Exception{
		Market_operate sales=new Market_operate();
		sales.updateMarket(temp);
	}
	public void del(Integer id) throws Exception{
		Market_operate sales=new Market_operate();
		sales.deleteMarket(id);
	}
	
	public List<Market>  query(String num) throws Exception{
		Market_operate sales=new Market_operate();
		return sales.query(num);
		
	}
	public List<Market> query(List<Map<String, Object>> params) throws Exception{
		Market_operate sales=new Market_operate();
		return sales.query(params);
	}
	
	
	public Market get(Integer id) throws SQLException{
		Market_operate sales=new Market_operate();
		return sales.get(id);
	}

}
