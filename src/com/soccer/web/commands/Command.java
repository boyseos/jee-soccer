package com.soccer.web.commands;

import javax.servlet.http.HttpServletRequest;

import com.soccer.web.pools.Constants;

import lombok.Data;
@Data
public class Command implements Order{
	protected String action, page, view, domain, context;
	protected HttpServletRequest request;
	
	@Override
	public void execute() {
		setPage();
		setDomain();
		setView(page);
		request.setAttribute("page",request.getParameter("page"));
		request.setAttribute("qr", (request.getParameter("qr")==null) ?
				"question" : "result");
	}

	 public void setPage() {
		 page = request.getParameter("page"); 
	}
	 
	 public void setDomain() {
		 domain = request.getServletPath()
		 .replace(".do","").substring(1); 
	}
	 
	 public void setContext() {
		 context = request.getServletContext() + request.getServletPath();
	}
	  
	  public void setView(String page) {
		  this.page = page;
		  switch (page) {
		  
		  case "login":
			  view = String.format(Constants
					  .FACADE_PATH, "main");
			  break;
		  case "home":
			  view = String.format(Constants
					  .DOUBLE_PATH, domain,"main");
			  break;
		  case "join":
			  view = String.format(Constants
					  .FACADE_PATH, "main");
			  request.setAttribute("page", "login");
			  request.setAttribute("action",request.getServletContext()+"/facade.do");
			  break;
		  case "fail":
			  view = String.format(Constants
					  .FACADE_PATH,page);
			  break;
		  case "Sql_02":
			  view = String.format(Constants
					  .DOUBLE_PATH, domain,"main");
			  //request.setAttribute("action",request.getServletContext()+"/player.do");
			  break;
		  case "index":
			  view = "index.jsp"; 
			  break;
		  case "select_question":
			  view = String.format(Constants
					  .DOUBLE_PATH, domain,"main");
			  break;
		  default:
			  view = String.format(Constants
					  .DOUBLE_PATH,domain,page);
			  
			  break;
		}
	}
}
