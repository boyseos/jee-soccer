package com.soccer.web.serviceimpls;

public class StadiumServiceImpl {
	private static StadiumServiceImpl instance = new StadiumServiceImpl();
	
	private StadiumServiceImpl(){}
	
	public static StadiumServiceImpl getInstance() {
		return instance;
	}
}
