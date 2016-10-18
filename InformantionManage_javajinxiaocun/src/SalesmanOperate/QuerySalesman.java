package SalesmanOperate;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import Database.DBAccess;
import Database.db_Connect;
import Model.Salesman;
import Operate_interface.Query;

public class QuerySalesman {

	/*
	@Override
	public void query() {
		// TODO Auto-generated method stub
		
	}
	*/
	public List<Salesman> queryNumber(String num){
		DBAccess dbAccess=new DBAccess();
		SqlSession sqlSession=null;
		List<Salesman> salesmanList=new ArrayList<Salesman>();
		
		try {
			sqlSession=dbAccess.getSqlSession();
			
			salesmanList=sqlSession.selectList("Salesman.queryNumber",num);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
		
		return salesmanList;
	}
	
	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
		String num=cin.next();
		QuerySalesman querySalesman=new QuerySalesman();
		
		System.out.println(querySalesman.queryNumber(num).size());
	}
	

	/*
	public List<Salesman> query(String name, String number, String sex, String birthday, String phone ,
							String employeddate, String address,Date date) throws Exception {        //Date alterdate
		
		List<Salesman> result = new ArrayList<Salesman>();

		Connection conn = db_Connect.getConnection();
		StringBuffer s_sql = new StringBuffer();
		s_sql.append(" select * from [InformationManagement].[dbo].[Salesman]  where 1=1");

		
		 
		s_sql.append(" where db_name_sn like ? and db_number_sn like ? and db_sex_sn like ?  "
				+ " and db_birthdate_sn like ? and db_phone_sn like ? "
				+ " and db_employeddate_sn like ? and db_address_sn like ? and db_update_sn like ? ");//and db_update_sn like ?
		 
		ptmt.setString(1, name );
		ptmt.setString(2,  number );
		ptmt.setString(3,  sex );
		ptmt.setString(4,  birthday );
		ptmt.setString(5,  phone );
		ptmt.setString(6,  employeddate );
		ptmt.setString(7,  address );
		ptmt.setDate(8,  alterdate );
		
		System.out.println(s_sql.toString());
		String temp =" "" ";
		
		if(name!=null)
			s_sql.append( " and db_name_sn = '" + name + "' ");            //    sql.append(  "  and  t.name='"+name+"'  "  );
		if(number!=null)
			s_sql.append( " and db_number_sn = '" + number + "' ");
		if(sex!=null)
			s_sql.append( " and db_sex_sn = '" + sex + "' ");
		if(birthday!=null)
			s_sql.append( " and db_birthdate_sn = '" + birthday + "' ");
		if(phone!=null)
			s_sql.append( " and db_phone_sn = '" + phone + "' ");
		if(employeddate!=null)
			s_sql.append( " and db_employeddate_sn = '" + employeddate + "' ");
		if(address!=null)
			s_sql.append( " and db_address_sn = '" + address + "' ");
		if(date!=null)
			s_sql.append( " and db_alterdate_sn = '" + date + "' ");
		
		//System.out.println(s_sql.toString());
		PreparedStatement ptmt=conn.prepareStatement(s_sql.toString());
		//System.out.println(s_sql.toString());
		ResultSet rs = ptmt.executeQuery();

		Salesman salesman = null;

		while (rs.next()) {
			
			salesman = new Salesman();
			salesman.setId(rs.getInt("db_id_sn"));
			salesman.setNumber(rs.getString("db_number_sn"));
			salesman.setName(rs.getString("db_name_sn"));
			salesman.setGender(rs.getString("db_sex_sn"));
			salesman.setPhone(rs.getString("db_phone_sn"));
			salesman.setbirthDate(rs.getString("db_birthDate_sn"));
			salesman.setAddress(rs.getString("db_address_sn"));
			salesman.setemployedDate(rs.getString("db_employedDate_sn"));
			salesman.setalterDate(rs.getDate("db_update_sn"));

			result.add(salesman);
		}
		
		return result;
		
	}

	public List<Salesman> query(String name, String number) throws Exception {
		
		List<Salesman> result = new ArrayList<Salesman>();

		Connection conn = db_Connect.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("select * from [InformationManagement].[dbo].[Salesman]  ");

		sb.append(" where db_name_sn like ? and db_number_sn like ? ");

		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		
		ptmt.setString(1, "%" + name + "%");
		ptmt.setString(2, "%" + number + "%");

		System.out.println(sb.toString());
		ResultSet rs = ptmt.executeQuery();

		Salesman salesman = null;

		while (rs.next()) {
			salesman = new Salesman();
			salesman.setId(rs.getInt("db_id_sn"));
			salesman.setNumber(rs.getString("db_number_sn"));
			salesman.setName(rs.getString("db_name_sn"));
			salesman.setGender(rs.getString("db_sex_sn"));
			salesman.setPhone(rs.getString("db_phone_sn"));
			salesman.setbirthDate(rs.getString("db_birthDate_sn"));
			salesman.setAddress(rs.getString("db_address_sn"));
			salesman.setemployedDate(rs.getString("db_employedDate_sn"));

			result.add(salesman);
		}
		return result;
	}

	public List<Salesman> query(List<Map<String, Object>> params) throws Exception {
		List<Salesman> result = new ArrayList<Salesman>();

		Connection conn = db_Connect.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("select * from Salesman where 1=1 ");

		if (params != null && params.size() > 0) {
			for (int i = 0; i < params.size(); i++) {
				Map<String, Object> map = params.get(i);
				sb.append(" and  " + map.get("name") + " " + map.get("rela") + " " + map.get("value") + " ");
			}
		}

		PreparedStatement ptmt = conn.prepareStatement(sb.toString());

		System.out.println(sb.toString());
		ResultSet rs = ptmt.executeQuery();

		Salesman salesman = null;
		while (rs.next()) {
			salesman = new Salesman();
			salesman.setId(rs.getInt("db_id_sn"));
			salesman.setNumber(rs.getString("db_number_sn"));
			salesman.setName(rs.getString("db_name_sn"));
			salesman.setGender(rs.getString("db_sex_sn"));
			salesman.setPhone(rs.getString("db_phone_sn"));
			salesman.setbirthDate(rs.getString("db_birthDate_sn"));
			salesman.setAddress(rs.getString("db_address_sn"));
			salesman.setemployedDate(rs.getString("db_employedDate_sn"));

			result.add(salesman);
		}
		return result;
	}
	
	*/
}
