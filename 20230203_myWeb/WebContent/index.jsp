<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="./WEB-INF/errors/500error.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link herf="<%request.getContextPath(); %>/resources/css/reset.css" rel="">
<script type="text/javascript"></script>

</head>
<body>
<img alt="" src="">
<!-- page taglib include prefix uri http://java.sun.com/jsp/jstl/core -->

<script type="text/javascript">
	
	function login() {
		location.href = "loginurl";
	}
	
</script>


<button type="button" onclick="login();">로그인 페이지 이동</button>
	

</body>
</html>