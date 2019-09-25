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
		PlayerBean p = PlayerServiceImpl
				.getInstance().setPlayer(request);
		p = PlayerServiceImpl
				.getInstance().findPlayerIdSolar(p);
		if(null ==  p.getPlayerId()){
			System.out.println("로그인 실패");
			setView("index");
		}else {			
			System.out.println("로그인 성공");
			request.setAttribute("player",p);
		}
		
	}
}
