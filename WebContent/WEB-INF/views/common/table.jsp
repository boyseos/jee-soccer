<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form id="login_form">
	<div class="login_tab" style="width: 100%;height: 100%" >
		<div class="login_columns">
			ID : <input id="username" class="input_tab" type="text" name="playerId"/>
		</div>
		<div id="login_button">
			<input id="login_form_button" type="button" value="로그인전송" />
			<input type="hidden" name="page" value="home" />	
			<input type="hidden" name="action" value="login" />	
		</div>
		<div class="login_columns">
			PW : <input id="userpass" class="input_tab" type="text" name="solar"/>
		</div>
	</div>
</form>
