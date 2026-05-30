package com.database.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.database.DatabaseManager;
import com.database.model.CustomerDBModel;

public class CustomerDao {
	
	

	private static final String CUSTOMER_DATA_QUERY="""
			Select * from tr_customer where id = 304800 """;
	
	public static CustomerDBModel getCutomerInfo(int id)  {
		
		Connection conn;
		CustomerDBModel customerdbmodel = null;
		try {
		 conn = DatabaseManager.getConnection();
		
		Statement statement = conn.createStatement();
		
		
		ResultSet resultSet = statement.executeQuery(CUSTOMER_DATA_QUERY);
	
		while(resultSet.next()) {
			System.out.println(resultSet.getString("first_name"));
			
		
			
			 customerdbmodel = new CustomerDBModel(resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("mobile_number"), resultSet.getString("mobile_number_alt"), resultSet.getString("email_id"), resultSet.getString("email_id_alt"));
		}
		}
		catch(SQLException e) {
			System.err.println(e.getStackTrace());
		}
		return customerdbmodel;
	}
}

