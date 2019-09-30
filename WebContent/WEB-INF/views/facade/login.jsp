<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="../common/head.jsp"/>

<div>1</div>
<div>
<img id="soccer_intro" src="${img}/Soccer_Intro.jpg" alt="" />
</div>
<div>3</div>
<div>4</div>
<div style="width: 100%;height: 100%">
	<jsp:include page="../common/table.jsp"/>
</div>
<div>6</div>
<div>7</div>
<div>
	<h3 id="a_join" ><a id="a_join" href="#">회원가입</a></h3>
</div>
<div>9</div>
<script>
app.init('${ctx}');
</script>
<jsp:include page="../common/foot.jsp"/>