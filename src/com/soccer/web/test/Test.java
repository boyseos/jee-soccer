package com.soccer.web.test;

import com.soccer.web.serviceimpls.BasicServiceImpl;
import com.soccer.web.services.BasicService;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String k = "asdf";
		if(BasicServiceImpl.instance().isNum(k)) {
			Integer.parseInt(k);		
			}
		Integer.parseInt(k);
		System.out.println(k);	
	}
}
