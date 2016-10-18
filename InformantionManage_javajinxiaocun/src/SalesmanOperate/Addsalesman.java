package SalesmanOperate;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import Database.DBAccess;
import Database.db_Connect;
import Model.Salesman;
import Operate_interface.*;

public class Addsalesman implements Add{

	/*public void add(Object obj) throws SQLException {
		Salesman salesman = (Salesman) obj;
		add(salesman);		// TODO Auto-generated method stub instanceof 
		
	}
	*/
	public void add(Salesman salesman){
		DBAccess dbAccess=new DBAccess();
		
		SqlSession sqlSession=null;
		
		try {
			
			sqlSession=dbAccess.getSqlSession();
		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
	}

	@Override
	public void add(Object obj) {
		// TODO Auto-generated method stub
		
	}
	
	
	/*public void add(Salesman salesman) throws SQLException {
		Connection conn = db_Connect.getConnection();
		String sql = " " + " insert into [InformationManagement].[dbo].[Salesman] "
				+ " (db_number_sn, db_name_sn, db_sex_sn, db_phone_sn, db_birthDate_sn, "
				+ " db_address_sn, db_employedDate_sn, db_update_sn) " + " values( " + " ?,?,?,?,?,?,?,?) ";
		
		
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		ptmt.setString(1, salesman.getNumber());
		ptmt.setString(2, salesman.getName());
		ptmt.setString(3, salesman.getGender());
		ptmt.setString(4, salesman.getPhone());
		ptmt.setString(5, salesman.getbirthDate());
		ptmt.setString(6, salesman.getAddress());
		ptmt.setString(7, salesman.getemployedDate());
		ptmt.setDate(8, new Date(System.currentTimeMillis()));
 
		
		ptmt.execute();
	}
*/
}
