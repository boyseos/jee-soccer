package com.soccer.web.factory;

import java.sql.Connection;
import java.sql.DriverManager;

import com.soccer.web.enums.DBDrivers;
import com.soccer.web.enums.DBUrls;
import com.soccer.web.pools.Constants;

public class Maria implements Database{

	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(DBDrivers.MARIA_DRIVER.toString());
			conn = DriverManager.getConnection(
					DBUrls.MARIA_URL.toString()
					,Constants.USERNAME
					,Constants.PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
