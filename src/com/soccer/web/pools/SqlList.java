package com.soccer.web.pools;

public class SqlList {

	public static String 
			SqlQuestion02 = "SELECT DISTINCT P.POSITION\r\n" + 
			"FROM PLAYER P\r\n" + 
			"ORDER BY 1 DESC"
		
			,SqlQuestion04 = "SELECT *\r\n" +
			"FROM PLAYER P\r\n" + 
			"WHERE P.TEAM_ID LIKE ?\r\n" + 
			"    AND P.POSITION LIKE ?\r\n" + 
			"ORDER BY 1"
					
			,SqlQuestion05 ="SELECT *\r\n" + 
					"FROM PLAYER P\r\n" + 
					"WHERE P.TEAM_ID LIKE ?\r\n" + 
					"    AND P.HEIGHT >= ?\r\n" + 
					"    AND P.PLAYER_NAME LIKE ?\r\n" + 
					"ORDER BY 1"
			,findPlayerIdSolar = "SELECT *\n" + 
					"FROM PLAYER\n" + 
					"WHERE PLAYER_ID LIKE ?\n" + 
					"	AND SOLAR LIKE ?\n";
			
			
}
