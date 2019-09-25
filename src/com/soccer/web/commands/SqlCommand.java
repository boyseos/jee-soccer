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
		switch (page.replace("Sql_","")) {
		case "02":
			for (PlayerBean px : PlayerServiceImpl.getInstance()
					.findPositions()) {
				PlayerServiceImpl.getInstance()
				.setPlayerAttribute(px, i);
				i++;
			}
			break;
		case "04":
			for (PlayerBean px : PlayerServiceImpl.getInstance()
					.findTeamPositions(p)) {
				PlayerServiceImpl.getInstance()
				.setPlayerAttribute(px, i);
				i++;
			}
			break;
		case "05":
			for (PlayerBean px : PlayerServiceImpl.getInstance()
					.findTeamHeightName(p)) {
				PlayerServiceImpl.getInstance()
				.setPlayerAttribute(px, i);
				i++;
			}
			break;
		default:
			break;
		}
	}
}
