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
				tempSql(px, i);
				i++;
			}
			break;
		case "04":
			for (PlayerBean px : PlayerServiceImpl.getInstance()
					.findTeamPositions(p)) {
				tempSql(px, i);
				i++;
			}
			break;
		case "05":
			for (PlayerBean px : PlayerServiceImpl.getInstance()
					.findTeamHeightName(p)) {
				tempSql(px, i);
				i++;
			}
			break;
		default:
			break;
		
		}
	}
	
	public void tempSql(PlayerBean px,int i) {//임시처리. 메소드자체를 변수처리 또는 메소드이름 통일후 파라미터값 추가하거나 해야지 해결할듯.
		System.out.println("SqlCommand : "+px);
		Receiver.cmd.request.setAttribute
		(String.format("sql%02d",i ),px);
	}
}
