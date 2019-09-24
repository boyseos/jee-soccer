package com.soccer.web.commands;

import javax.servlet.http.HttpServletRequest;
import lombok.Data;

import com.soccer.web.pools.Constants;

@Data
public class Command implements Order{
	
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
