package com.soccer.web.test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.soccer.web.domains.PlayerBean;
import com.soccer.web.factory.DatabaseFactory;

public class ConnTest {
	public static void main(String[] args) {
		PlayerBean p = null;

		try {
			PreparedStatement stmt = DatabaseFactory
					.createDatabase("oracle")
					.getConnection()
					.prepareStatement(
					"SELECT *\n" + 
					"FROM PLAYER\n" + 
					"ORDER BY 1 DESC\n");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				p = new PlayerBean();
				p.setPlayerId(rs.getString(1));
				System.out.println(rs.getObject(1));
				System.out.println(rs.getRow());
				System.out.println(rs.getMetaData());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(p);
	}
}
