package com.soccer.web.services;

import com.soccer.web.domains.PlayerBean;

public interface PlayerService {
	/**
	 * --2.포지션 종류(중복제거 없으면 빈공간)
		SELECT DISTINCT P.POSITION 포지션
		FROM PLAYER P
		ORDER BY 1 DESC
	 */
	public PlayerBean[] findPositions();
}
