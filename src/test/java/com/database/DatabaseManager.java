package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.api.utilities.ConfigManager;

import groovy.transform.Synchronized;

public class DatabaseManager {

	private static  final String DB_URL = ConfigManager.getProperty("DB_URL");
	private static final String DB_UN = ConfigManager.getProperty("DB_UN");
	private static final String DB_PWD = ConfigManager.getProperty("DB_PWD");
	private volatile static  Connection conn ;
	
	private DatabaseManager() {
		
	}
	public static void createConnection() throws SQLException {
		if(conn == null) {
			synchronized(DatabaseManager.class){
				
			}
				if(conn ==null) {
					 conn = DriverManager.getConnection(DB_URL, DB_UN, DB_PWD);
				System.out.println(conn);
			}
		}
		
	}

	}
