<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../common/head.jsp"/>
<div class="wrapper" style="width: 100%;height: 100%" >
로그인 실패
<h3><a id="index" href="#">인덱스</a> </h3>
<script>
$('#index').click(function(){
	location.assign('<%=request.getContextPath()%>/player.do?page=index');
})
</script>

<jsp:include page="../common/foot.jsp"/>