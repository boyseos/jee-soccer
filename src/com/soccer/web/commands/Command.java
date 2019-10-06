package com.soccer.web.commands;

import javax.servlet.http.HttpServletRequest;

import com.soccer.web.pools.Constants;
import com.soccer.web.serviceimpls.BasicServiceImpl;

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
		setQr();
	}

	 public void setPage() {
		page = (request.getParameter("page")==null)
				 ? "login" : request.getParameter("page");
		System.out.println("페이지 전환전 " + page);
		page = BasicServiceImpl.instance().isNum(page) ?
				  (String.format("Sql_%02d", Integer.parseInt(page))) : page;
		request.setAttribute("page", page);
		System.out.println("페이지 전환후 " + page);
	}
	 
	 public void setDomain() {
		 domain = request.getServletPath()
		 .replace(".do","").substring(1); 
	}
	 
	 public void setContext() {
		 context = request.getServletContext() + request.getServletPath();
	}

	 public void setQr() {
		 request.setAttribute("qr", (request.getParameter("qr")==null) 
				 ?	"question" : "result");
	}
	 public void setView(String page) {
		  switch (page) {
		  case "index":
			  view = "index.jsp"; 
			  break;
		  default:
			  view = String.format(Constants
					  .DOUBLE_PATH,domain,"main");	  
			  break;
		}
	}
}
