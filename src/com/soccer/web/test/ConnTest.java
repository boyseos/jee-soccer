package com.soccer.web.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.soccer.web.domains.PlayerBean;

public class ConnTest {
	public static void main(String[] args) {
		List<PlayerBean> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		PlayerBean p = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe"
				, userName = "c##admin"
				, passWord = "1234";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, userName, passWord);
			if(conn != null) {
				System.out.println("만세");
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT DISTINCT P.POSITION 포지션\r\n" + 
						"FROM PLAYER P\r\n" + 
						"ORDER BY 1 DESC");
				String result = "";
				while(rs.next()) {
					p = new PlayerBean();
					p.setPosition(rs.getString("포지션"));
					list.add(p);
					result += String.format("%s\n", p);
				}
				System.out.println(result);
			} else {
				System.out.println("망");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
