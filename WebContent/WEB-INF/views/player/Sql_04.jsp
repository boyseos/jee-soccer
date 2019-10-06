<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
    <c:choose>
    	<c:when test="${qr eq 'question'}">
			<h2>${player.playerName} 선수</h2>
			<form id="sql_04_form">
			<input type="submit" value="보내자" >
			<input type="hidden" name="action" value="search">
			<input type="hidden" name="page" value="04">
			<input type="hidden" name="qr" value="result">
			팀아이디<input type="text" name="teamId" >
			포지션<input type="text" name="position" >
			</form>
		</c:when>
		<c:when test="${qr eq 'result'}">
			해당 ID가 ${sql00Player.teamId} 팀의 포지션 ${sql00Player.position} 선수이름은 ${sql00Player.playerName}입니다.<br>
			해당 ID가 ${sql01Player.teamId} 팀의 포지션 ${sql01Player.position} 선수이름은 ${sql01Player.playerName}입니다.<br>
			해당 ID가 ${sql02Player.teamId} 팀의 포지션 ${sql02Player.position} 선수이름은 ${sql02Player.playerName}입니다.<br>
			해당 ID가 ${sql03Player.teamId} 팀의 포지션 ${sql03Player.position} 선수이름은 ${sql03Player.playerName}입니다.<br>
			해당 ID가 ${sql04Player.teamId} 팀의 포지션 ${sql04Player.position} 선수이름은 ${sql04Player.playerName}입니다.<br>
			<br> <a id="back_select" href="#">돌아가기</a>
		</c:when>
	</c:choose>


