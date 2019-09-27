<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="${js}/app.js"></script>
</head>
<body>
<div id="wrapper" style="width: 100%;height: 100%" >
<img src="${img}/Soccer_Intro.jpg" alt="" />
	<form id="login_form" action="${ctx}/player.do">
		<table border = "1" style="width : 500px;height : 200px; margin : 100px auto ">
			<tr>
				<td style="width : 300px">
					ID : <input type="text" name="playerId"/>
				</td>
				<td rowspan="2">
					<input type="submit" value="로그인전송" />
					<input type="hidden" name="page" value="home" />	
					<input type="hidden" name="action" value="login" />	
				</td>
			</tr>
			<tr>
				<td>
					PW : <input type="text" name="solar"/>
				</td>
			</tr>
		</table>
	</form>	
	<h3 style="width : 300px; margin : 0 auto">
	<a id="a_join" href="#">회원가입</a> </h3>
</div>
<script>
app.init('${ctx}');
</script>
</body>
</html>