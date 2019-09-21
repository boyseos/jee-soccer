package com.soccer.web.commands;

import javax.servlet.http.HttpServletRequest;

public class MoveCommand extends Command{

	public MoveCommand(HttpServletRequest request) {
		this.request = request;
	}
	
	@Override
	public void execute() {
		super.execute();
		request.setAttribute("page", page);//가는곳을 보여주기위한 어트리뷰트 안쓰면 필요없음.
	}
}
