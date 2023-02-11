<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 제목</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="./resources/css/boardList.css">

</head>
<body>
	<div id="mainTitle" class="" name="">
		<span>게시판 제목</span>
	</div>
	<div>
		
	</div>
	<div>
		<table id="blist" class="" name="">
			<thead>
				<tr>
					<th class="no">번호</th>
					<th class="type">분류</th>					
					<th class="title">제목</th>
					<th class="author">글쓴이</th>
					<th class="createD">등록 시간</th>
				</tr>
			</thead>
			<tbody>
					<c:forEach var="anlist" items="${anlist}" >
						<tr class="allNoti">
							<td class="no">${anlist.id}</td>
							<td class="type">${anlist.categoryName}</td>
							<td class="title">${anlist.title}</td>
							<td class="author">${anlist.userId}</td>
							<td class="createD">${anlist.createDate}</td>
						</tr>
					</c:forEach>
					<c:forEach var="bnlist" items="${bnlist}" >
						<tr class="Noti">
							<td class="no">${bnlist.id}</td>
							<td class="type">${bnlist.categoryName}</td>
							<td class="title">${bnlist.title}</td>
							<td class="author">${bnlist.userId}</td>
							<td class="createD">${bnlist.createDate}</td>
						</tr>
					</c:forEach>
					<c:forEach var="blist" items="${blist}" >
						<tr>
							<td class="no">${blist.id}</td>
							<td class="type">${blist.categoryName}</td>
							<td class="title">${blist.title}</td>
							<td class="author">${blist.userId}</td>
							<td class="createD">${blist.createDate}</td>
						</tr>
					</c:forEach>
			</tbody>
		</table>
<hr>		

		
		
		
	</div>
</body>
</html>