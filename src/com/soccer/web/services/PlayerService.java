package com.soccer.web.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.soccer.web.domains.PlayerBean;

public interface PlayerService {
	
	public List<PlayerBean> findPositions();
	public List<PlayerBean> findTeamPositions(PlayerBean param);
	public List<PlayerBean> findTeamHeightName(PlayerBean param);
	public PlayerBean findPlayerIdSolar(PlayerBean param);
	public PlayerBean setPlayer(HttpServletRequest request);
	public void setPlayerAttribute(PlayerBean player, int i);
}
