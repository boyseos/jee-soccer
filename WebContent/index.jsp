<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sql</title>
<script   src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<div>
	<h2>Sql 보기</h2>
	<form id="form" action="<%=request.getContextPath()%>/player.do">
	문제번호 : <input type="number" name="page">
	<input type="submit" value="보내자" >
	<input type="hidden" name="action" value="sql">
	</form>
</div>
<script>
$('#form').submit(function());
</script>
</body>
</html>