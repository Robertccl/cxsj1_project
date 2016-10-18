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
import Model.Product;

public class Product_operate {
	
	PreparedStatement  ptmt=null;
	
	public void addProduct(Product temp) throws SQLException {
		Connection conn=db_Connect.getConnection();
		String sql=" " +
				" insert into Product " +
				" (db_number_pt, db_name_pt, db_amount_pt, db_unitPrice_pt, db_producer_pt, " +
				" db_stockDate_pt) " +
				" values(" +
				" ?,?,?,?,?,?) ";
		System.out.println(conn);
		try
		{
			ptmt=conn.prepareStatement(sql);
			
		}catch(NullPointerException e)
		{
			System.out.println("yichengyuanyin"+e.getMessage());
		}
		
		ptmt.setString(1, temp.getNumber());
		ptmt.setString(2, temp.getName());
		ptmt.setInt(3, temp.getAmount());
		ptmt.setFloat(4, temp.getunitPrice());
		ptmt.setString(5, temp.get_producer());
		ptmt.setDate(6, new Date(temp.getstockDate().getTime()));
		ptmt.execute();
	}
	
	public void updateProduct(Product temp) throws Exception{
		Connection conn=db_Connect.getConnection();
		String sql=" " +
				" insert into Product " +
				" (db_number_pt, db_name_pt, db_amount_pt, db_unitPrice_pt, db_producer_pt, " +
				" db_stockDate_pt) " +
				" values(" +
				" ?,?,?,?,?,?) ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setString(1, temp.getNumber());
		ptmt.setString(2, temp.getName());
		ptmt.setInt(3, temp.getAmount());
		ptmt.setFloat(4, temp.getunitPrice());
		ptmt.setString(5, temp.get_producer());
		ptmt.setDate(6, new Date(temp.getstockDate().getTime()));
		
		ptmt.execute();
	}
	

	public void deleteProduct(Integer id) throws Exception{
		Connection conn=db_Connect.getConnection();
		String sql="" +
				" delete from Product " +
				" where db_id_sn=? ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setInt(1, id);
		ptmt.execute();
	}
	

	
	public List<Product> query(String num) throws Exception{
		List<Product> result=new ArrayList<Product>();
		
		Connection conn=db_Connect.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select db_id_sn,db_number_sn from Salesman  ");
		
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		
		ResultSet rs=ptmt.executeQuery();
		
		Product temp=null;
		while(rs.next()){
			temp=new Product();
			temp.setId(rs.getInt("db_id_sn"));
			temp.setNumber(rs.getString("db_number_sn"));

			result.add(temp);
		}
		return result;
	}
	public List<Product> query(String name,String number) throws Exception{
		List<Product> result=new ArrayList<Product>();
		
		Connection conn=db_Connect.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select * from Product  ");
		
		sb.append(" where db_name_sn like ? and db_number_sn like ? ");
		
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		ptmt.setString(1, "%"+name+"%");
		ptmt.setString(2, "%"+number+"%");
	
		System.out.println(sb.toString());
		ResultSet rs=ptmt.executeQuery();
		
		Product temp=null;
		
		while(rs.next()){
			temp=new Product();
			temp.setId(rs.getInt("db_id_pt"));
			temp.setNumber(rs.getString("db_number_pt"));
			temp.setName(rs.getString("db_name_pt"));
			temp.setAmount(rs.getInt("db_amount_pt"));
			temp.setunitPrice(rs.getFloat("db_unitPrice_pt"));
			temp.set_producer(rs.getString("db_producer_pt"));
			temp.setstockDate(rs.getDate("db_stockdate_pt"));
			
	
	
	
			result.add(temp);
		}
		return result;
	}
	public List<Product> query(List<Map<String, Object>> params) throws Exception{
		List<Product> result=new ArrayList<Product>();
		
		Connection conn=db_Connect.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select * from Salesman where 1=1 ");
		
		if(params!=null&&params.size()>0){
			for (int i = 0; i < params.size(); i++) {
				Map<String, Object> map=params.get(i);
				sb.append(" and  "+map.get("name")+" "+map.get("rela")+" "+map.get("value")+" ");
			}
		}
		
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		
		System.out.println(sb.toString());
		ResultSet rs=ptmt.executeQuery();
		
		Product temp=null;
		while(rs.next()){
			temp=new Product();
			temp.setId(rs.getInt("db_id_pt"));
			temp.setNumber(rs.getString("db_number_pt"));
			temp.setName(rs.getString("db_name_pt"));
			temp.setAmount(rs.getInt("db_amount_pt"));
			temp.setunitPrice(rs.getFloat("db_unitPrice_pt"));
			temp.set_producer(rs.getString("db_producer_pt"));
			temp.setstockDate(rs.getDate("db_stockdate_pt"));
	
		
	
			result.add(temp);
		}
		return result;
	}
	
	public Product get(Integer id) throws SQLException{
		Product g=null;
		Connection conn=db_Connect.getConnection();
		String sql="" +
				" select * from imooc_goddess " +
				" where db_id_sn=? ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setInt(1, id);
		ResultSet rs=ptmt.executeQuery();
		Product temp=null;
		while(rs.next()){
			temp=new Product();
			temp.setId(rs.getInt("db_id_pt"));
			temp.setNumber(rs.getString("db_number_pt"));
			temp.setName(rs.getString("db_name_pt"));
			temp.setAmount(rs.getInt("db_amount_pt"));
			temp.setunitPrice(rs.getFloat("db_unitPrice_pt"));
			temp.set_producer(rs.getString("db_producer_pt"));
			temp.setstockDate(rs.getDate("db_stockdate_pt"));
	
		}
		return temp;
	}

}
