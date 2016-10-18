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
import Model.Market;
import Model.Salesman;

public class Market_operate {
	
	PreparedStatement  ptmt=null;
	
	public void addMarket(Market temp) throws SQLException {
		Connection conn=db_Connect.getConnection();
		String sql=" " +
				" insert into Market " +
				" (db_salesman_mt, db_customer_mt, db_customerPhone_mt, db_productName_mt, db_productNumber_mt, " +
				" db_amount_mt,db_unitPrice_mt ,db_salesdate_mt, db_notes_mt) " +
				" values(" +
				" ?,?,?,?,?,?,?,?,?) ";
		System.out.println(conn);
		try
		{
			ptmt=conn.prepareStatement(sql);
			
		}catch(NullPointerException e)
		{
			System.out.println("yuanyin"+e.getMessage());
		}
		
		ptmt.setString(1, temp.get_salesman());
		ptmt.setString(2, temp.get_customer());
		ptmt.setString(3, temp.getcustomerPhone());
		ptmt.setString(4, temp.getproductName());
		ptmt.setString(5, temp.getproductNumber());
		ptmt.setInt(6, temp.getAmount());
		ptmt.setFloat(7, temp.getunitPrice());
		ptmt.setDate(8, new Date(temp.getsaleDate().getTime()));
		ptmt.setString(9, temp.getnotes());
	
		ptmt.execute();
	}
	
	public void updateMarket(Market temp) throws Exception{
		Connection conn=db_Connect.getConnection();
		String sql=" " +
				" insert into Market " +
				" (db_salesman_mt, db_customer_mt, db_customerPhone_mt, db_productName_mt, db_productNumber_mt, " +
				" db_amount_mt,db_unitPrice_mt ,db_salesdate_mt, db_notes_mt) " +
				" values(" +
				" ?,?,?,?,?,?,?,?,?) ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setString(1, temp.get_salesman());
		ptmt.setString(2, temp.get_customer());
		ptmt.setString(3, temp.getcustomerPhone());
		ptmt.setString(4, temp.getproductName());
		ptmt.setString(5, temp.getproductNumber());
		ptmt.setInt(6, temp.getAmount());
		ptmt.setFloat(7, temp.getunitPrice());
		ptmt.setDate(8, new Date(temp.getsaleDate().getTime()));
		ptmt.setString(9, temp.getnotes());
		
		ptmt.execute();
	}
	

	public void deleteMarket(Integer id) throws Exception{
		Connection conn=db_Connect.getConnection();
		String sql="" +
				" delete from Market " +
				" where db_id_mt=? ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setInt(1, id);
		ptmt.execute();
	}
	

	
	public List<Market> query(String name) throws Exception{
		List<Market> result=new ArrayList<Market>();
		
		Connection conn=db_Connect.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select db_id_mt,db_salesman_sn from Market  ");
		
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		
		ResultSet rs=ptmt.executeQuery();
		
		Market temp=null;
		while(rs.next()){
			temp=new Market();
			temp.setId(rs.getInt("db_id_mt"));
			temp.setproductName(rs.getString("db_salesman_mt"));

			result.add(temp);
		}
		return result;
	}

	public List<Market> query(List<Map<String, Object>> params) throws Exception{
		List<Market> result=new ArrayList<Market>();
		
		Connection conn=db_Connect.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select * from Market where 1=1 ");
		
		if(params!=null&&params.size()>0){
			for (int i = 0; i < params.size(); i++) {
				Map<String, Object> map=params.get(i);
				sb.append(" and  "+map.get("name")+" "+map.get("rela")+" "+map.get("value")+" ");
			}
		}
		
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		
		System.out.println(sb.toString());
		ResultSet rs=ptmt.executeQuery();
		
		Market temp=null;
		while(rs.next()){
			temp=new Market();
			temp.setId(rs.getInt("db_id_mt"));
			temp.set_salesman(rs.getString("db_salesman_mt"));
			temp.set_customer(rs.getString("db_customer_mt"));
			temp.setcustomerPhone(rs.getString("db_customerPhone_mt"));
			temp.setproductName(rs.getString("db_productName_mt"));
			temp.setproductNumber(rs.getString("db_productNUmber_mt"));
			temp.setAmount(rs.getInt("db_amount_mt"));
			temp.setunitPrice(rs.getFloat("db_unitPrice_mt"));
			temp.setsaleDate(rs.getDate("db_salesdate_mt"));
			temp.setnotes(rs.getString("db_notes_mt"));
	
			result.add(temp);
		}
		return result;
	}
	
	public Market get(Integer id) throws SQLException{
		Market temp=null;
		Connection conn=db_Connect.getConnection();
		String sql="" +
				" select * from Market " +
				" where id=? ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setInt(1, id);
		ResultSet rs=ptmt.executeQuery();
		while(rs.next()){
			temp=new Market();
			temp.setId(rs.getInt("db_id_mt"));
			temp.set_salesman(rs.getString("db_salesman_mt"));
			temp.set_customer(rs.getString("db_customer_mt"));
			temp.setcustomerPhone(rs.getString("db_customerPhone_mt"));
			temp.setproductName(rs.getString("db_productName_mt"));
			temp.setproductNumber(rs.getString("db_productNUmber_mt"));
			temp.setAmount(rs.getInt("db_amount_mt"));
			temp.setunitPrice(rs.getFloat("db_unitPrice_mt"));
			temp.setsaleDate(rs.getDate("db_salesdate_mt"));
			temp.setnotes(rs.getString("db_notes_mt"));
	
		}
		return temp;
	}

}
