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
<link rel="stylesheet" type="text/css" href="./resources/css/boardWrite.css">
<link rel="stylesheet" type="text/css" href="./resources/css/boardList.css">
</head>
<body>
<%@include file="/WEB-INF/view/extra/header.jsp" %>

<div>
	<form action="" method="post">
		<span class="sub">제목</span><input type="text" id = "boardtitle" class="boardtitle" ><br>
		<span class="sub">아이디</span><input type="text" id = "boardid" class="boardid" placeholder="6자 이내로 ">
		<span class="sub">비밀번호</span><input type="password" id = "boardpw" class="boardpw" placeholder="6자 이내로 ">
		<div class="bContext">
			<textarea id="editor" class="editor" name="bContext" placeholder="내용을 입력하세요"></textarea>
		</div>
		
	</form>
	
</div>
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