package com.soccer.web.commands;

import javax.servlet.http.HttpServletRequest;

import com.soccer.web.domains.PlayerBean;
import com.soccer.web.serviceimpls.PlayerServiceImpl;

public class SqlCommand extends MoveCommand{

	public SqlCommand(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public void execute() {
		super.execute();
		PlayerBean p = PlayerServiceImpl
				.getInstance().setPlayer(request);
		int i = 1;
		switch (page.replace("Sql_","")) { //cmd.request가 서비스까지 가도 되는가.
		case "02":
			for (PlayerBean px : PlayerServiceImpl.getInstance()
					.findPositions()) {
				System.out.println("SqlCommand : "+px);
				Receiver.cmd.request.setAttribute
				(String.format("sql%02d",i ),px);
				i++;
			}
			break;
		case "04":
			for (PlayerBean px : PlayerServiceImpl.getInstance()
					.findTeamPositions(p)) {
				System.out.println("SqlCommand : "+px);
				Receiver.cmd.request.setAttribute
				(String.format("sql%02d",i ),px);
				i++;
			}
			break;
		case "05":
			for (PlayerBean px : PlayerServiceImpl.getInstance()
					.findTeamHeightName(p)) {
				System.out.println("SqlCommand : "+px);
				Receiver.cmd.request.setAttribute
				(String.format("sql%02d",i ),px);
				i++;
			}
			break;
		default:
			break;
		
		}
	}
}
