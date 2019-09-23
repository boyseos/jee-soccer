package com.soccer.web.commands;

import javax.servlet.http.HttpServletRequest;
import lombok.Data;

import com.soccer.web.pools.Constants;

@Data
public class Command implements Order{  //코맨드를 싱글톤패턴으로 만들기엔 상속도 걸리고
										//액션값 초기화를 위해서도 생성자 실행되는게 좋을듯.
	protected String domain, page, view, action;
	protected HttpServletRequest request;

	public void execute() {
		setDomain();
		setPage();
		setView(page);
	}

	public void setDomain() {
		domain = request.getServletPath().replace(".do", "").substring(1);
	}

	public void setPage() {
		page = 	String.format("Sql_%02d",
					Integer.parseInt((request.getParameter("page") != "")
					? request.getParameter("page") : "1")); 		
	}
	
	public void setView(String page) {
		view = String.format(Constants.VIEW_PATH, page);
	}
}
