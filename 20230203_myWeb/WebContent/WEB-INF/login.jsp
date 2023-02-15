<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.3.js"></script>
<script type="text/javascript">

	$("#dupid").click(checkDupId);
	
	function checkDupId(){
		$.ajax({
			url : "<%=request.getContextPath() %>/dupid.lo",
			type : "post",
			async : false,
		    /* dataType : 'json', 받을 결과데이터의 자료형 
		    contentType : 'application/json; charset:utf-8', 
		    data : JSON.stringify(test), JSON 타입 데이터 입력*/
			data : {id : $("input[type = text]").first().val()},		
			sucess : function(result){
				console.log(result);
				if(result == "1"){
					$("#dupid").next().html("중복 아이디가 있습니다. 다시 입력해주세요");
					$("#dupid").next().css.("color","red");
				}else{
					$("#dupid").next().html("사용가능 아이디 입니다.");
					$("#dupid").next().css.("color","blue");
				}
			},
			error : function(request, status, error){
				alert(request.statis)
				console.log(result + "error");
			}
		});
	}
	
</script>
</head>
<body>
로그인

<form action="loginurl" method="post">
	id : <input type = "text" name="n1">
	<button type="button" id="dupid">id 중복 확인</button>
	<span></span>
	PW : <input type = "password" name="n2">
	<button type = "submit">전송</button>
	
	
	

</form>
</body>
</html>