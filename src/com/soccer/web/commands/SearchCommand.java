package com.soccer.web.commands;

import javax.servlet.http.HttpServletRequest;

import com.soccer.web.domains.PlayerBean;
import com.soccer.web.serviceimpls.PlayerServiceImpl;

public class SearchCommand extends MoveCommand{
	
	public SearchCommand(HttpServletRequest request) {
		super(request);
	}

	@Override
	public void execute() {
		super.execute();
		if(request.getAttribute("qr").equals("result")) {
			PlayerBean p = PlayerServiceImpl
					.getInstance().setPlayer(request);
			int i = 1;
			String sqlNum = page.replace("Sql_","");
			request.setAttribute("question_num", sqlNum);
			switch (sqlNum) {
			case "01":
				for (PlayerBean px : PlayerServiceImpl.getInstance()
						.findPositions()) {
					PlayerServiceImpl.getInstance()
					.setPlayerAttribute(px, i);
					i++;
				}
				break;
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
}
