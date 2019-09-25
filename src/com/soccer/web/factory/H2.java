package com.soccer.web.factory;

import java.sql.Connection;
import java.sql.DriverManager;

import com.soccer.web.enums.DBDrivers;
import com.soccer.web.enums.DBUrls;
import com.soccer.web.pools.Constants;

public class H2 implements Database{

	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(DBDrivers.H2_DRIVER.toString());
			conn = DriverManager.getConnection(
					DBUrls.H2_URL.toString()
					,Constants.USERNAME
					,Constants.PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}
