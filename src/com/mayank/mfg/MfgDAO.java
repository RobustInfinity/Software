package com.mayank.mfg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MfgDAO {

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		ResourceBundle rb = ResourceBundle.getBundle("dbconfig");
		Class.forName(rb.getString("driverName"));
		Connection connection = DriverManager.getConnection(rb.getString("dburl"), rb.getString("userid"), rb.getString("password"));
		return connection;
	}
	
	public boolean add(MfgDTO mfgDTO) throws SQLException {
		Connection connection = null;
		PreparedStatement pstmt = null;
		Integer rowCount;
		String sql = "insert into manufacturer_table (company_name, supervisor, contact_no, address, gstin_no) values(?,?,?,?,?)";
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, mfgDTO.getCompany_name());
			pstmt.setString(2, mfgDTO.getSupervisor());
			pstmt.setString(3, mfgDTO.getContact_no());
			pstmt.setString(4, mfgDTO.getAddress());
			pstmt.setString(5, mfgDTO.getGstin_no());
			rowCount = pstmt.executeUpdate();
			while(rowCount!=0) {
				return true;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(pstmt!=null) {
				pstmt.close();
			}
			if(connection!=null) {
				connection.close();
			}
		}
		return false;
	}
	
	public ArrayList<MfgDTO> view() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MfgDTO> mfgList = new ArrayList<>();
		String sql = "select company_no, company_name, supervisor, contact_no, address, gstin_no from manufacturer_table";
		try {
		connection =getConnection();
		pstmt = connection.prepareStatement(sql);
		rs =pstmt.executeQuery();
		while(rs.next()) {
			MfgDTO mfgDTO = new MfgDTO();
			mfgDTO.setCompany_no(rs.getInt("company_no"));
			mfgDTO.setCompany_name(rs.getString("company_name"));
			mfgDTO.setSupervisor(rs.getString("supervisor"));
			mfgDTO.setContact_no(rs.getString("contact_no"));
			mfgDTO.setAddress(rs.getString("address"));
			mfgDTO.setGstin_no(rs.getString("gstin_no"));
			mfgList.add(mfgDTO);
		}
		}
		
		finally {
			if(rs!=null) {
				rs.close();
			}
			if(pstmt!=null) {
				pstmt.close();
			}
			if(connection!=null) {
				connection.close();
			}
		}
		return mfgList;
	}
	
}
