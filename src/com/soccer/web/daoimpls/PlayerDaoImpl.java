package com.soccer.web.daoimpls;

import java.sql.PreparedStatement;
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
					.prepareStatement(SqlList.SqlQuestion02)
					.executeQuery();
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
			PreparedStatement stmt = DatabaseFactory
					.createDatabase("oracle")
					.getConnection()
					.prepareStatement(SqlList.SqlQuestion04);
			stmt.setString(1, param.getTeamId());
			stmt.setString(2, param.getPosition());
			ResultSet rs = stmt.executeQuery();
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
			PreparedStatement stmt = DatabaseFactory
					.createDatabase("oracle")
					.getConnection()
					.prepareStatement(SqlList.SqlQuestion05);
			stmt.setString(1, param.getTeamId());
			stmt.setString(2, param.getHeight());
			stmt.setString(3, param.getPlayerName());
			ResultSet rs = stmt.executeQuery();
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
		PlayerBean p = new PlayerBean();
		String result = "";
		System.out.println("만세");
		try {		
			PreparedStatement stmt = DatabaseFactory
					.createDatabase("oracle")
					.getConnection()
					.prepareStatement(SqlList
					.findPlayerIdSolar);
			stmt.setString(1, param.getPlayerId());
			stmt.setString(2, param.getSolar());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				p = new PlayerBean();
				p.setPlayerId(rs.getString("PLAYER_ID"));
				p.setSolar(rs.getString("SOLAR"));
				p.setPlayerName(rs.getString("PLAYER_NAME"));
				p.setBackNo(rs.getString("BACK_NO"));
				p.setBrithDate(rs.getString("BIRTH_DATE"));
				p.setEPlayerName(rs.getString("E_PLAYER_NAME"));
				p.setHeight(rs.getString("HEIGHT"));
				p.setJoinYyyy(rs.getString("JOIN_YYYY"));
				p.setNation(rs.getString("NATION"));
				p.setNickName(rs.getString("NICKNAME"));
				p.setPosition(rs.getString("POSITION"));
				p.setTeamId(rs.getString("TEAM_ID"));
				p.setWeight(rs.getString("WEIGHT"));
				result += String.format("%s\n", p);
			}
		}
	    catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("db 값 = "+ result);
		return p;
	}
}