package Operate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import DateBase.db_Connect;
import Model.Producer;

public class Producer_operate {
	
	PreparedStatement  ptmt=null;
	
	public void addProducer(Producer temp) throws SQLException {
		Connection conn=db_Connect.getConnection();
		String sql=" " +
				" insert into Producer " +
				" db_name_pr,db_phone_pr ,db_address_pr " +
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
	
	public void updateProducer(Producer temp) throws Exception{
		Connection conn=db_Connect.getConnection();
		String sql=" " +
				" insert into Producer " +
				" db_name_pr,db_phone_pr ,db_address_pr " +
				" values(" +
				" ?,?,?) ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setString(1, temp.getName());
		ptmt.setString(2, temp.getPhone());
		ptmt.setString(3, temp.getAddress());
		
		ptmt.execute();
	}
	

	public void deleteProducer(Integer id) throws Exception{
		Connection conn=db_Connect.getConnection();
		String sql="" +
				" delete from Producer " +
				" where db_id_mt=? ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setInt(1, id);
		ptmt.execute();
	}
	

	
	public List<Producer> query(String name) throws Exception{
		List<Producer> result=new ArrayList<Producer>();
		
		Connection conn=db_Connect.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select db_id_pr,db_phone_pr from Producer  ");
		
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		
		ResultSet rs=ptmt.executeQuery();
		
		Producer temp=null;
		while(rs.next()){
			temp=new Producer();
			temp.setId(rs.getInt("db_id_pr"));
			temp.setPhone(rs.getString("db_phone_pr"));

			result.add(temp);
		}
		return result;
	}

	public List<Producer> query(List<Map<String, Object>> params) throws Exception{
		List<Producer> result=new ArrayList<Producer>();
		
		Connection conn=db_Connect.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select * from Producer where 1=1 ");
		
		if(params!=null&&params.size()>0){
			for (int i = 0; i < params.size(); i++) {
				Map<String, Object> map=params.get(i);
				sb.append(" and  "+map.get("name")+" "+map.get("rela")+" "+map.get("value")+" ");
			}
		}
		
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		
		System.out.println(sb.toString());
		ResultSet rs=ptmt.executeQuery();
		
		Producer temp=null;
		while(rs.next()){
			temp=new Producer();
			temp.setId(rs.getInt("db_id_pr"));
			temp.setName(rs.getString("db_name_pr"));
			temp.setPhone(rs.getString("db_phone_pr"));
			temp.setAddress(rs.getString("db_address_pr"));
	
			result.add(temp);
		}
		return result;
	}
	
	public Producer get(Integer id) throws SQLException{
		Producer temp=null;
		Connection conn=db_Connect.getConnection();
		String sql="" +
				" select * from Producer " +
				" where id=? ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setInt(1, id);
		ResultSet rs=ptmt.executeQuery();
		while(rs.next()){
			temp=new Producer();
			temp.setId(rs.getInt("db_id_pr"));
			temp.setName(rs.getString("db_name_pr"));
			temp.setPhone(rs.getString("db_phone_pr"));
			temp.setAddress(rs.getString("db_address_pr"));
			
	
		}
		return temp;
	}

}
