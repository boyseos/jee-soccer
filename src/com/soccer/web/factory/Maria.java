package com.soccer.web.factory;

import java.sql.Connection;
import java.sql.DriverManager;

import com.soccer.web.pools.Constants;

public class Maria implements Database{

	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(Constants.MARIA_DRIVER);
			conn = DriverManager.getConnection(
					Constants.MARIA_URL
					,Constants.USERNAME
					,Constants.PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
