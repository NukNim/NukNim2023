<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 상세</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="./resources/css/boardview.css">
<link rel="stylesheet" type="text/css" href="./resources/css/boardList.css">

</head>
<body>

	<div id="mainTitle" class="" name="">
		<span>게시판 상세 페이지</span>
	</div>
	
	<div>
		${bview }	
	</div>
	

</body>
</html>