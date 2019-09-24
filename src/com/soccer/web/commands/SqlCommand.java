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
				.getInstance().setPlayer(request);//cmd.request가 서비스까지 가도 되는가.
		int i = 1;
		switch (page.replace("Sql_","")) { //팩토리 형태로 만들기엔 30개를 일일이 클래스파일을 만들..어야하나..
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
