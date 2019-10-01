<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sql05</title>
<script   src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>

	<h2>${player.playerName} 선수</h2>
	<form id="form" action="<%=request.getContextPath()%>/player.do">
	문제번호 : <input type="hidden" name="page" value="05">
	<input type="submit" value="보내자" >
	<input type="hidden" name="action" value="sql">
	팀아이디<input type="text" name="teamId" >
	포지션<input type="text" name="position" >
	선수키<input type="text" name="height" >
	선수이름<input type="text" name="playerName" >
	</form>

<!-- 답 -->
해당 ID가 ${sql01.teamId} 선수이름은 ${sql01.playerName}이고   키는 ${sql01.height} 입니다.<br>
해당 ID가 ${sql02.teamId} 선수이름은 ${sql02.playerName}이고   키는 ${sql02.height} 입니다.<br>
</body>
</html>