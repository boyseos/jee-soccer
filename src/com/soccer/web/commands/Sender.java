package com.soccer.web.commands;

import javax.servlet.http.HttpServletResponse;

public class Sender {
	
	public static void foward(HttpServletResponse response) {
		try {
			Receiver.cmd.getRequest().getRequestDispatcher(Receiver.cmd.getView())
				.forward(Receiver.cmd.getRequest(), response);
		}  catch (Exception e) {
			e.printStackTrace();
		}
	}
}
