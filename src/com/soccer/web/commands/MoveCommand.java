package com.soccer.web.commands;

import javax.servlet.http.HttpServletRequest;

public class MoveCommand extends Command{
	
	public MoveCommand(HttpServletRequest request) {
		this.request = request;
	}
	@Override
	public void execute() {
		super.execute();
	}
}
