package com.soccer.web.serviceimpls;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.soccer.web.commands.Receiver;
import com.soccer.web.daoimpls.PlayerDaoImpl;
import com.soccer.web.domains.PlayerBean;
import com.soccer.web.services.PlayerService;

public class PlayerServiceImpl implements PlayerService{
	private static PlayerServiceImpl instance = new PlayerServiceImpl();
	
	public static PlayerServiceImpl getInstance() {
		return instance;
	}
	private PlayerServiceImpl() {}
	
	@Override
	public List<PlayerBean> findPositions() {
		return PlayerDaoImpl.getInstance().selectPositions();
	}
	@Override
	public List<PlayerBean> findTeamPositions(PlayerBean param) {
		System.out.println("서비스 : " + param);
		return PlayerDaoImpl.getInstance().selectTeamPositions(param);
	}
	@Override
	public List<PlayerBean> findTeamHeightName(PlayerBean param) {
		System.out.println("서비스 : " + param);
		return PlayerDaoImpl.getInstance().selectTeamHeightName(param);
	}
	
	@Override
	public PlayerBean setPlayer(HttpServletRequest request) {
		PlayerBean p  = new PlayerBean();
		p.setBackNo(request.getParameter("backNo"));
		p.setBrithDate(request.getParameter("brithDate"));
		p.setEPlayerName(request.getParameter("ePlayerName"));
		p.setHeight(request.getParameter("height"));
		p.setJoinYyyy(request.getParameter("joinYyyy"));
		p.setNation(request.getParameter("nation"));
		p.setNickName(request.getParameter("nickName"));
		p.setPlayerId(request.getParameter("playerId"));
		p.setPlayerName(request.getParameter("playerName"));
		p.setPosition(request.getParameter("position"));
		p.setSolar(request.getParameter("solar"));
		p.setTeamId(request.getParameter("teamId"));
		p.setWeight(request.getParameter("weight"));
		return p;
	}	
}
