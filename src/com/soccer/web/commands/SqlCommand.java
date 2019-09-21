package com.soccer.web.commands;

import javax.servlet.http.HttpServletRequest;

import com.soccer.web.domains.PlayerBean;
import com.soccer.web.serviceimpls.PlayerServiceImpl;
import com.soccer.web.services.PlayerService;

public class SqlCommand extends MoveCommand{

	public PlayerService service;
	
	public SqlCommand(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public void execute() {
		super.execute();
		service = new PlayerServiceImpl();
		int i = 0;
		PlayerBean[] arr = service.findPositions();
		for (PlayerBean p : arr) {
			Receiver.cmd.request.setAttribute(String.format("sql%02d",i ),p);
			i++;
		}
	}
}
