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
		  
		  case "login":
			  view = String.format(Constants
					  .FACADE_PATH, page);
			  break;
		  case "home":
			  view = String.format(Constants
					  .FACADE_PATH, page);
			  break;
		  case "join":
			  view = String.format(Constants
					  .FACADE_PATH, page);
			  break;
		  case "fail":
			  view = String.format(Constants
					  .FACADE_PATH,page);
			  break;
		  case "index":
			  view = "index.jsp"; 
			  break;
		  default:
			  view = String.format(Constants
					  .DOUBLE_PATH,domain,page);
			  break;
		}
	}
}
