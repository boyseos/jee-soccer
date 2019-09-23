package com.soccer.web.commands;

import javax.servlet.http.HttpServletRequest;

public class Receiver {
	public static Command cmd = new Command();
	
	public static void init(HttpServletRequest request) {
		try {
			cmd = Commander.order(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
