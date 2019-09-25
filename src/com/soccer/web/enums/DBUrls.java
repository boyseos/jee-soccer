package com.soccer.web.enums;

public enum DBUrls {
	ORACLE_URL,
	MARIA_URL,
	H2_URL;
	
	@Override
	public String toString() {
		String url="";
		switch (this) {
		case ORACLE_URL:
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			break;
		case MARIA_URL:
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			break;
		case H2_URL:
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			break;
		}
		return url;
	}
}
