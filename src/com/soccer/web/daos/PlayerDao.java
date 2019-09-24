package com.soccer.web.daos;

import java.util.List;

import com.soccer.web.domains.PlayerBean;
public interface PlayerDao {
	
	/**
	 * --2.포지션 종류(중복제거 없으면 빈공간)
		SELECT DISTINCT P.POSITION 포지션
		FROM PLAYER P
		ORDER BY 1 DESC
	 */
	public List<PlayerBean> selectPositions();
	public List<PlayerBean> selectTeamPositions(PlayerBean param);
	public List<PlayerBean> selectTeamHeightName(PlayerBean param);
}
