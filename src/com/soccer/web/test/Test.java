package com.soccer.web.test;

import com.soccer.web.serviceimpls.BasicServiceImpl;
import com.soccer.web.services.BasicService;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicService s = new BasicServiceImpl();
		String k = "asdf";
		if(s.isNum(k)) {
			Integer.parseInt(k);		
			}
		Integer.parseInt(k);
		System.out.println(k);	
	}
}
