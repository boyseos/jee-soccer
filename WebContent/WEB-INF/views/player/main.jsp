<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="../common/head.jsp"/>
<div class="wrapper" style="width: 100%;height: 100%" >
<div></div>
<div></div>
<div></div>
	<h2>${player.playerName} 선수</h2>
	<form id="form" action="<%=request.getContextPath()%>/player.do">
	문제번호 : <input type="number" name="page">
	<input type="submit" value="보내자" >
	<input type="hidden" name="action" value="sql">
	팀아이디<input type="text" name="teamId" >
	포지션<input type="text" name="position" >
	선수키<input type="text" name="height" >
	선수이름<input type="text" name="playerName" >
	</form>
<script>
app.init('${ctx}');
</script>

<jsp:include page="../common/foot.jsp"/>