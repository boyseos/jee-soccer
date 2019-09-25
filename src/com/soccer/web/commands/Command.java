package com.soccer.web.commands;

import javax.servlet.http.HttpServletRequest;

import com.soccer.web.pools.Constants;

import lombok.Data;
@Data
public class Command implements Order{
	protected String action, page, view, domain;
	protected HttpServletRequest request;
	
	@Override
	public void execute() {
		setPage();
		setDomain();
		setView(page);
	}

	 public void setPage() {
		 page = request.getParameter("page"); 
	}
	 
	 public void setDomain() {
		 domain = request.getServletPath()
		 .replace(".do","").substring(1); 
	}
	  
	  public void setView(String page) {
		  this.page = page;
		  switch (page) {
		  case "home":
			  view = String.format(Constants
					  .VIEW_PATH+".jsp",page);
			  break;
		  case "index":
			  view = "index.jsp"; 
			  break;
		  default:
			  view = String.format(Constants
					  .VIEW_PATH+"/%s.jsp",domain,page);
			  break;
		}
	}
}
