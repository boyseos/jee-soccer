package com.soccer.web.commands;

import javax.servlet.http.HttpServletRequest;

public class Receiver {
	public static Command cmd = new Command();//코맨더에서  cmd가 정의될때 초기화가됨으로 중복이지만 
											//스태틱이라 실수로 다른데서 불리면 널익셉션으로
											//뻗을 가능성이 있음으로 삽입?
	public static void init(HttpServletRequest request) {
		try {
			cmd = Commander.order(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
