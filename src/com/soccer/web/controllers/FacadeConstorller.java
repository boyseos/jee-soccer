package com.soccer.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soccer.web.pools.Constants;

@WebServlet("/facade.do")
public class FacadeConstorller extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	enum Resources{
		CTX,CSS,IMG,JS
	}
	
	protected void service(HttpServletRequest request
			, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("퍼사드 진입");
		for(Resources r : Resources.values()) {
			request.getSession().setAttribute(
					r.toString().toLowerCase(), request.getContextPath() +
					((r.toString().equals("CTX")) ? "" 
							: "/resources/"+r.toString().toLowerCase()));
		}
		System.out.println("설정전 " + request.getParameter("page"));
		request.setAttribute("page",
				(request.getParameter("page")==null)
				? "login" : request.getParameter("page"));
		System.out.println("설정후 " + request.getParameter("page"));
		request.getRequestDispatcher
			(String.format(Constants.DOUBLE_PATH,
					request.getServletPath().substring(1,
							request.getServletPath().indexOf("."))
								,"main"))
			.forward(request, response);
	}
}

