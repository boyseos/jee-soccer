package com.soccer.web.serviceimpls;

import com.soccer.web.services.BasicService;

public class BasicServiceImpl implements BasicService{

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
