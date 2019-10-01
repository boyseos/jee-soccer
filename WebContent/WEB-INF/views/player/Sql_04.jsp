<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sql04</title>
<script   src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>

	<h2>${player.playerName} 선수</h2>
	<form id="form" action="<%=request.getContextPath()%>/player.do">
	문제번호 : <input type="hidden" name="page" value="04">
	<input type="submit" value="보내자" >
	<input type="hidden" name="action" value="sql">
	팀아이디<input type="text" name="teamId" >
	포지션<input type="text" name="position" >
	선수키<input type="text" name="height" >
	선수이름<input type="text" name="playerName" >
	</form>
<!-- 답 -->
해당 ID가 ${sql01.teamId} 팀의 포지션 ${sql01.position} 선수이름은 ${sql01.playerName}입니다.
</body>
</html>