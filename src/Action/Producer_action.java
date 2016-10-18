package Action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import Model.Producer;
import Operate.Producer_operate;

public class Producer_action {
	public void add(Producer temp) throws Exception{
		Producer_operate sales=new Producer_operate();
		sales.addProducer(temp);
	}

	
	public void edit(Producer temp) throws Exception{
		Producer_operate sales=new Producer_operate();
		sales.updateProducer(temp);
	}
	public void del(Integer id) throws Exception{
		Producer_operate sales=new Producer_operate();
		sales.deleteProducer(id);
	}
	
	public List<Producer>  query(String num) throws Exception{
		Producer_operate sales=new Producer_operate();
		return sales.query(num);
		
	}
	public List<Producer> query(List<Map<String, Object>> params) throws Exception{
		Producer_operate sales=new Producer_operate();
		return sales.query(params);
	}
	
	
	public Producer get(Integer id) throws SQLException{
		Producer_operate sales=new Producer_operate();
		return sales.get(id);
	}

}
