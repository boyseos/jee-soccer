package com.soccer.web.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sender {
	public static void forward(HttpServletResponse response) {
		try {
			System.out.println("센더 "
		+ Receiver.cmd.getPage()+"\n"+Receiver.cmd.getView()+"\n"
		+ Receiver.cmd.request.getAttribute("qr"));
			
			Receiver.cmd.getRequest()
				.getRequestDispatcher(Receiver.cmd.getView())
					.forward(Receiver.cmd.getRequest(), response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void redirect(HttpServletRequest request
			, HttpServletResponse response) {
		try {
			response.sendRedirect("view");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
