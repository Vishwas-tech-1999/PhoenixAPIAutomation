package com.database;

import java.sql.Connection;
import java.sql.SQLException;

public class DbRunnerHickari {

	public static void main(String[] args) throws SQLException  {
		
		
	Connection conn = DatabaseManager.getConnection();
	System.out.println(conn);
		

	}

}
