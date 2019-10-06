package com.soccer.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soccer.web.commands.Receiver;
import com.soccer.web.commands.Sender;
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
		
		Receiver.init(request);
		Receiver.cmd.execute();
		Sender.forward(response);
	}
}

