<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<jsp:include page="../common/head.jsp"/>
	<div>
		<c:choose>
			<c:when test="${page eq 'select_question'}">
				<jsp:include page="select_question.jsp"/>
			</c:when>
			<c:when test="${page eq 'Sql_02'}">
				<jsp:include page="Sql_02.jsp"/>
			</c:when>
			<c:when test="${page eq 'Sql_01'}">
				<jsp:include page="Sql_01.jsp"/>
			</c:when>
			<c:when test="${page eq 'Sql_04'}">
				<jsp:include page="Sql_04.jsp"/>
			</c:when>
			<c:when test="${page eq 'Sql_05'}">
				<jsp:include page="Sql_05.jsp"/>
			</c:when>
		</c:choose>
	</div>	
	<div>6</div>
	<div>7</div>
	<div><h1>기본 mainset</h1>
	페이지는 ${page} 이다. qr은 ${qr} 이다.</div>
	<div>9</div>
<jsp:include page="../common/foot.jsp"/>

