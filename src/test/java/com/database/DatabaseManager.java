package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.api.utilities.ConfigManager;
import com.api.utilities.EnvUtil;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import groovy.transform.Synchronized;

public class DatabaseManager {

	private static  final String DB_URL =EnvUtil.getValue("DB_URL");
	private static final String DB_UN = EnvUtil.getValue("DB_UN");
	private static final String DB_PWD = EnvUtil.getValue("DB_PWD");
	private static final int MAXIMUM_POOL_SIZE=Integer.parseInt(ConfigManager.getProperty("MAXIMUM_POOL_SIZE"));
	private static final int MINIMUM_IDLE_TIME=Integer.parseInt(ConfigManager.getProperty("MINIMUM_IDLE_TIME"));
	private static final int CONNECTION_TIMEOUT=Integer.parseInt(ConfigManager.getProperty("CONNECTION_TIMEOUT"));
	private static final int IDLE_TIMEOUT=Integer.parseInt(ConfigManager.getProperty("IDLE_TIMEOUT"));
	private static final int MAX_LIFE_TIME = Integer.parseInt(ConfigManager.getProperty("MAX_LIFE_TIME"));
	private static final String POOL_NAME=ConfigManager.getProperty("POOL_NAME");

	
	private  static  Connection conn ;
	private static HikariConfig hikariConfig;
	private volatile static HikariDataSource hikariDataSource;
	
	private DatabaseManager() {
		
	}
	public static void initializePool() throws SQLException {
		if(hikariDataSource == null) {
			synchronized(DatabaseManager.class){
				
			}
				if(hikariDataSource ==null) {
					 hikariConfig = new HikariConfig();
					hikariConfig.setJdbcUrl(DB_URL);
					hikariConfig.setUsername(DB_UN);
					hikariConfig.setPassword(DB_PWD);
					hikariConfig.setMaximumPoolSize(MAXIMUM_POOL_SIZE);
					hikariConfig.setMinimumIdle(MINIMUM_IDLE_TIME);
					hikariConfig.setConnectionTimeout(CONNECTION_TIMEOUT*1000);
					hikariConfig.setIdleTimeout(IDLE_TIMEOUT*1000);
					hikariConfig.setMaxLifetime(MAX_LIFE_TIME*60*1000); //30*60*1000
					hikariConfig.setPoolName(POOL_NAME);
					System.out.println(DB_URL);
					System.out.println(DB_UN);
					System.out.println(DB_PWD);
					 hikariDataSource = new HikariDataSource(hikariConfig);
					
					 conn = hikariDataSource.getConnection();
					System.out.println(conn);
					
					Statement statement = conn.createStatement();
				ResultSet rs = statement.executeQuery("select first_name , last_name , mobile_number  from tr_customer;");
				
//				while(rs.next()) {
//					System.out.println(rs.getString("first_name"));
//				}
			}
		}
		
	}
	
	public static Connection getConnection() throws SQLException {
		Connection conn = null;
		if(hikariDataSource == null) {
			
			initializePool();
		
		}
		else if(hikariDataSource.isClosed()) {
			throw new SQLException("Database connection is closed");
		}
		
		
				conn = hikariDataSource.getConnection();
		
			return conn;
		
	}

	}
