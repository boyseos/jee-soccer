package com.soccer.web.serviceimpls;

import com.soccer.web.daoimpls.PlayerDaoImpl;
import com.soccer.web.daos.PlayerDao;
import com.soccer.web.domains.PlayerBean;
import com.soccer.web.services.PlayerService;

public class PlayerServiceImpl implements PlayerService{
	
	public PlayerDao dao;
	
	public PlayerServiceImpl() {
		dao = new PlayerDaoImpl();
	}
		@Override
	public PlayerBean[] findPositions() {
		return dao.selectPositions().toArray(new PlayerBean[0]);
	}
}
