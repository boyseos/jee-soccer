package com.soccer.web.serviceimpls;

public class ScheduleServiceImpl {
	private static ScheduleServiceImpl instance = new ScheduleServiceImpl();
	
	private ScheduleServiceImpl() {}
	
	public static ScheduleServiceImpl getInstance() {
		return instance;
	}
}
