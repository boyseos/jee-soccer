package com.soccer.web.commands;

import javax.servlet.http.HttpServletRequest;

public class MoveCommand extends Command{
	
	public MoveCommand(HttpServletRequest request) {
		System.out.println("무브커맨드생성자 진입");
		this.request = request;
	}
	@Override
	public void execute() {
		super.execute();
	}
}
