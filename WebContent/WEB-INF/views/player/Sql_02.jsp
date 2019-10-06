<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
    <c:choose>
		<c:when test="${qr eq 'question'}">
			<input id="sql_02_button" type="button" value="보내자" >
		</c:when>
		<c:when test="${qr eq 'result'}">
			포지션은${sql01Player.position} ${sql02Player.position} ${sql03Player.position} ${sql04Player.position} ${sql05Player.position}입니다.
			포지션은${sql00Player.position} ${sql01Player.position} ${sql02Player.position} ${sql03Player.position} ${sql04Player.position} ${sql05Player.position}입니다.
			<br> <a id="back_select" href="#">돌아가기</a>
		</c:when>
	</c:choose>

