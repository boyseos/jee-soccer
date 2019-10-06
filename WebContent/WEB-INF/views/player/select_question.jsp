<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
	select_question
	<h2>${player.playerName} 선수</h2>
	<form id="sql_form">
		문제번호 : <input type="number" name="page">
		<input type="submit" value="보내자" >
		<input type="hidden" name="action" value="search">
	</form>
</body>
</html>