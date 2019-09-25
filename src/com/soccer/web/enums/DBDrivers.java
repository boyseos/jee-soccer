package com.soccer.web.enums;

public enum DBDrivers {
	ORACLE_DRIVER,
	MYSQL_DRIVER,
	MARIA_DRIVER,
	H2_DRIVER,
	DB2;
	
	@Override
	public String toString() {
		String driver = "";
		switch (this) {
		case ORACLE_DRIVER:
			driver = "oracle.jdbc.OracleDriver";
			break;
		case MARIA_DRIVER:
			driver = "org.mariadb.jdbc.Driver";
			break;
		case H2_DRIVER:
			driver = "oracle.jdbc.OracleDriver";
			break;
		case MYSQL_DRIVER:
			driver = "oracle.jdbc.OracleDriver";
			break;
		default:
			break;
		}
		return driver;
	}
}
