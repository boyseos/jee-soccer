package com.soccer.web.daoimpls;

import com.soccer.web.daos.ScheduleDao;

public class ScheduleDaoImpl implements ScheduleDao{
	private static ScheduleDao instance = new ScheduleDaoImpl();
	
	private ScheduleDaoImpl() {}
	
	public static ScheduleDao getInstance() {
		return instance;
	}
}
