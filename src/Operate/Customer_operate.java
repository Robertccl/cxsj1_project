package Operate;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import DateBase.db_Connect;
import Model.Customer;

public class Customer_operate {
	
	PreparedStatement  ptmt=null;
	
	public void addCustomer(Customer temp) throws SQLException {
		Connection conn=db_Connect.getConnection();
		String sql=" " +
				" insert into Customer " +
				" db_name_cr,db_phone_cr ,db_address_cr " +
				" values(" +
				" ?,?,?) ";
		System.out.println(conn);
		try
		{
			ptmt=conn.prepareStatement(sql);
			
		}catch(NullPointerException e)
		{
			System.out.println("yuanyin"+e.getMessage());
		}
		
		ptmt.setString(1, temp.getName());
		ptmt.setString(2, temp.getPhone());
		ptmt.setString(3, temp.getAddress());
	
		ptmt.execute();
	}
	
	public void updateCustomer(Customer temp) throws Exception{
		Connection conn=db_Connect.getConnection();
		String sql=" " +
				" insert into Customer " +
				" db_name_cr,db_phone_cr ,db_address_cr " +
				" values(" +
				" ?,?,?) ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setString(1, temp.getName());
		ptmt.setString(2, temp.getPhone());
		ptmt.setString(3, temp.getAddress());
		
		ptmt.execute();
	}
	

	public void deleteCustomer(Integer id) throws Exception{
		Connection conn=db_Connect.getConnection();
		String sql="" +
				" delete from Customer " +
				" where db_id_mt=? ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setInt(1, id);
		ptmt.execute();
	}
	

	
	public List<Customer> query(String name) throws Exception{
		List<Customer> result=new ArrayList<Customer>();
		
		Connection conn=db_Connect.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select db_id_mt,db_phone_sn from Customer  ");
		
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		
		ResultSet rs=ptmt.executeQuery();
		
		Customer temp=null;
		while(rs.next()){
			temp=new Customer();
			temp.setId(rs.getInt("db_id_cr"));
			temp.setPhone(rs.getString("db_phone_cr"));

			result.add(temp);
		}
		return result;
	}

	public List<Customer> query(List<Map<String, Object>> params) throws Exception{
		List<Customer> result=new ArrayList<Customer>();
		
		Connection conn=db_Connect.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select * from Customer where 1=1 ");
		
		if(params!=null&&params.size()>0){
			for (int i = 0; i < params.size(); i++) {
				Map<String, Object> map=params.get(i);
				sb.append(" and  "+map.get("name")+" "+map.get("rela")+" "+map.get("value")+" ");
			}
		}
		
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		
		System.out.println(sb.toString());
		ResultSet rs=ptmt.executeQuery();
		
		Customer temp=null;
		while(rs.next()){
			temp=new Customer();
			temp.setId(rs.getInt("db_id_cr"));
			temp.setName(rs.getString("db_name_cr"));
			temp.setPhone(rs.getString("db_phone_cr"));
			temp.setAddress(rs.getString("db_address_cr"));
	
			result.add(temp);
		}
		return result;
	}
	
	public Customer get(Integer id) throws SQLException{
		Customer temp=null;
		Connection conn=db_Connect.getConnection();
		String sql="" +
				" select * from Customer " +
				" where id=? ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setInt(1, id);
		ResultSet rs=ptmt.executeQuery();
		while(rs.next()){
			temp=new Customer();
			temp.setId(rs.getInt("db_id_cr"));
			temp.setName(rs.getString("db_name_cr"));
			temp.setPhone(rs.getString("db_phone_cr"));
			temp.setAddress(rs.getString("db_address_cr"));
			
	
		}
		return temp;
	}
	

}
