package com.soccer.web.commands;

import javax.servlet.http.HttpServletRequest;

import com.soccer.web.domains.PlayerBean;
import com.soccer.web.serviceimpls.PlayerServiceImpl;

public class LoginCommand extends MoveCommand{

	public LoginCommand(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public void execute() {
		super.execute();
		PlayerBean p = new PlayerBean();
		p.setPlayerId(request.getParameter("playerId"));
		p.setSolar(request.getParameter("solar"));
		if(null == PlayerServiceImpl
				.getInstance().findPlayerIdSolar(p)) {
			System.out.println("로그인 실패");
		}else {
			System.out.println("로그인 성공");
		}
		
	}
}
