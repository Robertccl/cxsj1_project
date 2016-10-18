package SalesmanOperate;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import Database.db_Connect;
import Model.Salesman;
import Operate_interface.Update;
/*
public class UpdateSalesman implements Update {

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	public void updateSalesman(Salesman salesman) throws Exception {
		Connection conn = db_Connect.getConnection();
		String sql=" " +
				" update  [InformationManagement].[dbo].[Salesman] " 
				+ "  set db_number_sn=?, db_name_sn=?, db_sex_sn=?, db_phone_sn=?, db_birthDate_sn=?, "
				+ " db_address_sn=?, db_employedDate_sn=?, db_update_sn=? " +
				" where db_id_sn=? ";
		
		PreparedStatement ptmt = conn.prepareStatement(sql);

		ptmt.setString(1, salesman.getNumber());
		ptmt.setString(2, salesman.getName());
		ptmt.setString(3, salesman.getGender());
		ptmt.setString(4, salesman.getPhone());
		ptmt.setString(5, salesman.getbirthDate());
		ptmt.setString(6, salesman.getAddress());
		ptmt.setString(7, salesman.getemployedDate());
		ptmt.setDate(8, new Date(salesman.getalterDate().getTime()));
		ptmt.setInt(9, salesman.getId());
		
		ptmt.execute();
		
	}

*/
