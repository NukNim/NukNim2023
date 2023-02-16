<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성 페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script src="https://cdn.ckeditor.com/ckeditor5/36.0.0/classic/ckeditor.js"></script>
<script type="text/javascript" src="./resources/js/boardview.js"></script>
<link href="./resources/css/boardWrite.css?ver=1.1" rel="stylesheet" type="text/css" >
<link href="./resources/css/boardList.css?ver=1.1" rel="stylesheet" type="text/css" >
</head>
<body>

<%@include file="/WEB-INF/view/extra/header.jsp" %>

<div>
	<form action="write" method="post">
		<span class="sub">제목</span><input type="text" id = "boardtitle" class="boardtitle" name="boardtitle" ><br>
		<span class="sub">아이디</span><input type="text" id = "boardid" class="boardid" name="boardid" placeholder="6자 이내로 ">
		<span class="sub">비밀번호</span><input type="password" id = "boardpw" class="boardpw" name="boardpw" placeholder="6자 이내로 ">
		<div class="bContext">
			<textarea id="editor" class="editor" name="bContext" placeholder="내용을 입력하세요"></textarea>
		</div>
		
		<button type="button" class="btn writeBtn" id="writeBtn" name="writeBtn">글작성</button>
	</form>
	
</div>

<script type="text/javascript">

	 $("#writeBtn").on("click", bWrite);
	 
	function bWrite(){
		
		var contents = CKEDITOR.instances['editor'].getData();

		if($(".boardtitle").val() == null || $(".boardtitle").val() ==""){
			alert("제목을 입력해 주세요");	
		}else if($(".boardid").val() == null || $(".boardid").val() ==""){
			alert("아이디를 입력해 주세요");
		}else if($(".boardpw").val() == null || $(".boardpw").val() ==""){
			alert("비밀번호를 입력해 주세요");
		}else if($(".editor").is(':empty')){
			alert("내용을 입력해 주세요");
			alert(contents + "==============asdfsadfsad");
		}else{
			$("form").submit();
		}
	} 
</script>
      <script>
              ClassicEditor
                      .create( document.querySelector( '#editor' ), {
                      	toolbar: {
                      		items: [
                      			'bold',
                      			'italic',
                      			'|',
                      			'outdent',
                      			'indent',
                      			'|',
                      			'blockQuote',
                      			'undo',
                      			'redo'
                      		]
                      	},
                      	language: 'ko'
                      })
                      .catch( error => {
                              console.error( error );
                      } );
      </script>

</body>
</html>