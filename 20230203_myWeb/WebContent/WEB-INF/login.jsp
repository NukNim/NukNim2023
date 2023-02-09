<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script type="text/javascript">
	location.reload = function(){
		if(document.getElementById("msgId").value == null){
			document.getElementById("msgId").style.display = 'none';
		}else{
			document.getElementById("msgId").style.display = 'block';
		}
	}
	
</script>
</head>
<body>
로그인

<form action="" method="post">
	<input type = "text" name="n1">
	<input type = "password" name="n2">
	<button type = "submit">전송</button>
	
	<h1 id = "msgId" name = "msg" value= <%=request.getAttribute("msg") %> style="display:none;" >
		<%=request.getAttribute("msg") %>
	</h1>

</form>
</body>
</html>