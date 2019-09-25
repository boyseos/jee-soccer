package com.soccer.web.factory;

import com.soccer.web.enums.DB;

public class DatabaseFactory {

	public static Database createDatabase(String vender)	{	
		Database db = null;
		switch (DB.valueOf(vender.toUpperCase())) {
		case ORACLE :	db = new Oracle();	break;
		case MARIADB : db = new Maria();	break;
		case H2 :		db = new H2();		break;
		case MYSQL : break;
		case DB2 : break;
		default:	break;
		}
		return db;
	}
}
