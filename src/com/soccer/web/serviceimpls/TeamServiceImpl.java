package com.soccer.web.serviceimpls;

public class TeamServiceImpl {
	private static TeamServiceImpl instance = new TeamServiceImpl();
	
	private TeamServiceImpl() {}
	
	public TeamServiceImpl getInstance() {
		return instance;
	}
}
