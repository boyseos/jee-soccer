package com.soccer.web.commands;

import javax.servlet.http.HttpServletRequest;

import com.soccer.web.domains.PlayerBean;
import com.soccer.web.serviceimpls.PlayerServiceImpl;

public class CreateCommand extends MoveCommand{

	public CreateCommand(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public void execute() {
		super.execute();
		PlayerBean p = PlayerServiceImpl
				.getInstance().setPlayer(request);
		request.setAttribute("result", (PlayerServiceImpl
				.getInstance().joinPlayer(p) ? "회원가입 성공":"회원가입 실패"));
		System.out.println(request.getAttribute("result"));
	}
}
