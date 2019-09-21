package com.soccer.web.commands;

import javax.servlet.http.HttpServletRequest;

public class Commander {
	
	public static Command order(HttpServletRequest request) {
		Command cmd = null;
		request.getParameter("action");
		String action = request.getParameter("action") != null ? 
				request.getParameter("action") : "move";
		switch (action) {
		case "sql":
			cmd = new SqlCommand(request);
			break;
		default:
			cmd = new MoveCommand(request);
			break;
		}
		return cmd;
	}
}
