package com.soccer.web.commands;

import javax.servlet.http.HttpServletRequest;

import com.soccer.web.enums.Actions;;

public class Commander {
	public static Command direct(HttpServletRequest request) {

		Command cmd = null;
		switch (Actions.valueOf((request.getParameter("action")!= null)
				? request.getParameter("action").toUpperCase()
					: "MOVE")) {
		case CREATE :	cmd = new CreateCommand(request);	break;
		case SEARCH:	cmd = new SearchCommand(request);	break;
		case UPDATE : break;	
		case DELETE : break;
		case LOGIN:		cmd = new LoginCommand(request);	break;
		default:		cmd = new MoveCommand(request);		break;
		}
		return cmd;
	}
	
}
