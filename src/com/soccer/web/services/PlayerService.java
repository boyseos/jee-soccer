package com.soccer.web.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.soccer.web.domains.PlayerBean;

public interface PlayerService {
	
	public PlayerBean setPlayer(HttpServletRequest request);
	/**
	 * --2.포지션 종류(중복제거 없으면 빈공간)
		SELECT DISTINCT P.POSITION 포지션
		FROM PLAYER P
		ORDER BY 1 DESC
	 */
	public List<PlayerBean> findPositions();
	// 4. 팀아이디와 포지션맞는 선수찾기
	public List<PlayerBean> findTeamPositions(PlayerBean param);
	public List<PlayerBean> findTeamHeightName(PlayerBean param);
}
