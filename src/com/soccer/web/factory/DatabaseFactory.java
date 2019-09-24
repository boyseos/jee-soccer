package com.soccer.web.factory;

public class DatabaseFactory {

	public static Database createDatabase(String vender)	{	
		Database db = null;
		switch (vender) {
		case "oracle" :	db = new Oracle();	break;
		case "mariadb": db = new Maria();	break;
		case "h2" :		db = new H2();		break;
		case "mysql" : break;
		case "db2" : break;
		default:	break;
		}
		return db;
	}
}
