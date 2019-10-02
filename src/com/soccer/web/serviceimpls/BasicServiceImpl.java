package com.soccer.web.serviceimpls;

import com.soccer.web.services.BasicService;

public class BasicServiceImpl implements BasicService{
	
	private static BasicServiceImpl instance = new BasicServiceImpl();
	private BasicServiceImpl() {}
	public static BasicServiceImpl instance() {
		return instance;
	}
	
	@Override
	public boolean isNum(String num) {
		boolean result = true;
		try {
			Integer.parseInt(num);
		} catch (Exception e) {
			result = false;
		}
		return result;
	}

}
