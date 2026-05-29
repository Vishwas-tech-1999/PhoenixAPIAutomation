package com.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.api.utilities.ConfigManager;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariCpDemo {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setJdbcUrl(ConfigManager.getProperty("DB_URL"));
		hikariConfig.setUsername(ConfigManager.getProperty("DB_UN"));
		hikariConfig.setPassword(ConfigManager.getProperty("DB_PWD"));
		hikariConfig.setMaximumPoolSize(10);
		hikariConfig.setMinimumIdle(2);
		hikariConfig.setConnectionTimeout(10000);
		hikariConfig.setIdleTimeout(10000);
		hikariConfig.setMaxLifetime(1800000); //30*60*1000
		hikariConfig.setPoolName("Phoenis test automation framework");
		
		HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);
		
		Connection conn = hikariDataSource.getConnection();
		System.out.println(conn);
		
		Statement statement = conn.createStatement();
	ResultSet rs = statement.executeQuery("select first_name , last_name , mobile_number  from tr_customer;");
	
	while(rs.next()) {
		System.out.println(rs.getString("first_name"));
	}
		
		
	}

}
