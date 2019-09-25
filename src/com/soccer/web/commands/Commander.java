package com.soccer.web.commands;

import javax.servlet.http.HttpServletRequest;

import com.soccer.web.enums.Actions;;

public class Commander {
	public static Command direct(HttpServletRequest request) {

		Command cmd = null;
		System.out.println(request.getParameter("action"));
		switch (Actions.valueOf((request.getParameter("action") 
				!= null) ? 
					request.getParameter("action").toUpperCase()
					: "MOVE")) {
		case SEARCH:
			cmd = new SearchCommand();
			break;
		case JOIN:
			cmd = new JoinCommand(request);
			break;
		case LOGIN:
			cmd = new LoginCommand(request);
			break;
		default:
			cmd = new MoveCommand(request);
			break;
		}
		return cmd;
	}
	
}
