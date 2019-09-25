package com.soccer.web.daoimpls;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.soccer.web.daos.PlayerDao;
import com.soccer.web.domains.PlayerBean;
import com.soccer.web.factory.DatabaseFactory;
import com.soccer.web.pools.SqlList;

public class PlayerDaoImpl implements PlayerDao{
	private static PlayerDaoImpl instance = new PlayerDaoImpl();
	public static PlayerDaoImpl getInstance() {return instance;}
	private PlayerDaoImpl() {}
	
	@Override
	public List<PlayerBean> selectPositions() {
		List<PlayerBean> list = new ArrayList<>();
		PlayerBean p = null;
		String result = "";
		System.out.println("만세");
		try {
			ResultSet rs = DatabaseFactory
					.createDatabase("oracle")
					.getConnection()
					.prepareStatement(SqlList.SqlQuestion02).executeQuery();
			while(rs.next()) {
				p = new PlayerBean();
				p.setPosition(rs.getString("POSITION"));				
				list.add(p);
				result += String.format("%s\n", p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("db 값 = "+ result);
		return list;
	}



	public List<PlayerBean> selectTeamPositions(PlayerBean param) {
		List<PlayerBean> list = new ArrayList<>();
		PlayerBean p = null;
		String result = "";
		System.out.println("만세");
		try {
			ResultSet rs = DatabaseFactory
					.createDatabase("oracle")
					.getConnection()
					.prepareStatement(String.format(SqlList.SqlQuestion04
							,param.getTeamId(),param.getPosition())).executeQuery();
			while(rs.next()) {
				p = new PlayerBean();
				p.setPosition(rs.getString("POSITION"));
				p.setTeamId(rs.getString("TEAM_ID"));
				p.setPlayerName(rs.getString("PLAYER_NAME"));
				list.add(p);
				result += String.format("%s\n", p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("db 값 = "+ result);
		return list;
	}



	@Override
	public List<PlayerBean> selectTeamHeightName(PlayerBean param) {
		List<PlayerBean> list = new ArrayList<>();
		PlayerBean p = null;
		String result = "";
		System.out.println("만세");
		try {
			ResultSet rs = DatabaseFactory
					.createDatabase("oracle")
					.getConnection()
					.prepareStatement(String
							.format(SqlList.SqlQuestion05
							,param.getTeamId(),param.getHeight()
							,param.getPlayerName())).executeQuery();
			while(rs.next()) {
				p = new PlayerBean();
				p.setTeamId(rs.getString("TEAM_ID"));
				p.setPlayerName(rs.getString("PLAYER_NAME"));
				p.setHeight(rs.getString("HEIGHT"));
				list.add(p);
				result += String.format("%s\n", p);
			}
		}
	    catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("db 값 = "+ result);
		return list;
	}
	
	@Override
	public PlayerBean selectPlayerIdSolar(PlayerBean param) {
		PlayerBean p = null;
		String result = "";
		System.out.println("만세");
		try {
			ResultSet rs = DatabaseFactory
					.createDatabase("oracle")
					.getConnection()
					.prepareStatement(String
							.format(SqlList.findPlayerIdSolar
							,param.getPlayerId(),param.getSolar()
							)).executeQuery();
			p = new PlayerBean();
			p.setPlayerId(rs.getString("PLAYER_ID"));
			p.setHeight(rs.getString("SOLAR"));
			result += String.format("%s\n", p);
		}
	    catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("db 값 = "+ result);
		return p;
	}
}