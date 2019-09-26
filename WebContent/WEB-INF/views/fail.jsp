<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 실패</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
로그인 실패
<h3><a id="index" href="#">인덱스</a> </h3>
</body>
<script>
$('#index').click(function(){
	location.assign('<%=request.getContextPath()%>/player.do?page=index');
})
</script>
</html>