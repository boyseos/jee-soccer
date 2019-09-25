package com.soccer.web.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sender {
	public static void forward(HttpServletResponse response) {
		try {
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
