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
import Model.Salesman;

public class Salesman_operate {

	PreparedStatement ptmt = null;

	public void addSalesman(Salesman salesman) throws SQLException {
		Connection conn = db_Connect.getConnection();
		String sql = " " + " insert into [InformationManagement].[dbo].[Salesman] "
				+ " (db_number_sn, db_name_sn, db_sex_sn, db_phone_sn, db_birthDate_sn, "
				+ " db_address_sn, db_employedDate_sn) " + " values(" + " ?,?,?,?,?,?,?) ";
		
		try {
			ptmt = conn.prepareStatement(sql);

		} catch (NullPointerException e) {
			System.out.println("yichengyuanyin" + e.getMessage());
		}

		ptmt.setString(1, salesman.getNumber());
		ptmt.setString(2, salesman.getName());
		ptmt.setString(3, salesman.getGender());
		ptmt.setString(4, salesman.getPhone());
		ptmt.setDate(5, new Date(salesman.getbirthDate().getTime()));
		ptmt.setString(6, salesman.getAddress());
		ptmt.setDate(7, new Date(salesman.getemployedDate().getTime()));
		ptmt.execute();
	}

	public void updateSalesman(Salesman salesman) throws Exception {
		Connection conn = db_Connect.getConnection();
		String sql = "" + " insert into Salesman " + " (db_number_sn,db_name_sn,db_sex_sn,db_phone_sn,db_birthDate_sn "
				+ " db_address_sn,db_employedDate_sn) " + " values(" + " ?,?,?,?,?,?,?) ";
		PreparedStatement ptmt = conn.prepareStatement(sql);

		ptmt.setString(1, salesman.getNumber());
		ptmt.setString(2, salesman.getName());
		ptmt.setString(3, salesman.getGender());
		ptmt.setString(4, salesman.getPhone());
		ptmt.setDate(5, new Date(salesman.getbirthDate().getTime()));
		ptmt.setString(6, salesman.getAddress());
		ptmt.setDate(7, new Date(salesman.getemployedDate().getTime()));
		ptmt.execute();
	}

	public void deleteSalesman(Integer id) throws Exception {
		Connection conn = db_Connect.getConnection();
		String sql = "" + " delete from Salesman " + " where db_id_sn=? ";
		PreparedStatement ptmt = conn.prepareStatement(sql);

		ptmt.setInt(1, id);
		ptmt.execute();
	}

	public List<Salesman> query(String num) throws Exception {
		List<Salesman> result = new ArrayList<Salesman>();

		Connection conn = db_Connect.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("select db_id_sn,db_number_sn from Salesman  ");

		PreparedStatement ptmt = conn.prepareStatement(sb.toString());

		ResultSet rs = ptmt.executeQuery();

		Salesman salesman = null;
		while (rs.next()) {
			salesman = new Salesman();
			salesman.setId(rs.getInt("db_id_sn"));
			salesman.setNumber(rs.getString("db_number_sn"));

			result.add(salesman);
		}
		return result;
	}

	public List<Salesman> query(String name, String number) throws Exception {
		List<Salesman> result = new ArrayList<Salesman>();

		Connection conn = db_Connect.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("select * from Salesman  ");

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
			salesman.setbirthDate(rs.getDate("db_birthDate_sn"));
			salesman.setAddress(rs.getString("db_address_sn"));
			salesman.setemployedDate(rs.getDate("db_employedDate_sn"));

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
			salesman.setbirthDate(rs.getDate("db_birthDate_sn"));
			salesman.setAddress(rs.getString("db_address_sn"));
			salesman.setemployedDate(rs.getDate("db_employedDate_sn"));

			result.add(salesman);
		}
		return result;
	}

	public Salesman get(Integer id) throws SQLException {
		Salesman g = null;
		Connection conn = db_Connect.getConnection();
		String sql = "" + " select * from imooc_goddess " + " where db_id_sn=? ";
		PreparedStatement ptmt = conn.prepareStatement(sql);

		ptmt.setInt(1, id);
		ResultSet rs = ptmt.executeQuery();
		Salesman salesman = null;
		while (rs.next()) {
			salesman = new Salesman();
			salesman.setId(rs.getInt("db_id_sn"));
			salesman.setNumber(rs.getString("db_number_sn"));
			salesman.setName(rs.getString("db_name_sn"));
			salesman.setGender(rs.getString("db_sex_sn"));
			salesman.setPhone(rs.getString("db_phone_sn"));
			salesman.setbirthDate(rs.getDate("db_birthDate_sn"));
			salesman.setAddress(rs.getString("db_address_sn"));
			salesman.setemployedDate(rs.getDate("db_employedDate_sn"));

		}
		return salesman;
	}
}
