package SalesmanOperate;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Database.db_Connect;
import Operate_interface.Remove;
/*
public class RemveSalesman implements Remove{

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
	public void removeSalesman(Integer id) throws Exception {
		Connection conn = db_Connect.getConnection();
		String sql = "  delete from [InformationManagement].[dbo].[Salesman] " + " where db_id_sn=? ";
		PreparedStatement ptmt = conn.prepareStatement(sql);

		ptmt.setInt(1, id);
		ptmt.execute();
		
	}
	
*/

