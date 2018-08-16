<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
body {
	padding: 0;
	margin: 0;
}

nav ul:after, nav ul:before, nav li:after, nav li:before, nav:after, nav:before
	{
	display: block;
	content: '';
	clear: both;
}

nav ul {
	float: left;
}

nav ul li {
	list-style: none;
	float: left;
	color: #135999;
}

nav ul li:first-child {
	width: 450px;
	background: white;
	color: #135999;
	padding-left: 150px;
	padding-top: 6px;
	font-size: 30px;
}

nav ul li:last-child a {
	color: #135999;
}

nav ul li:last-child:hover {
	background: #a6d8ff;
}

nav li:hover {
	background: #135999;
	color: white;
}

nav a {
	text-decoration: none !important;
	padding: 20px;
	line-height: 50px;
}

nav a:visited {
	color: #135999;
}

nav a:hover {
	color: white;
}

#home:hover {
	color: #031729;
}
</style>
</head>
<body>
	<nav>
		<ul>
			<li><a id="home" href="/miso/">MISO</a></li>
			<li><a href='/miso/'>캠퍼스투어 FAQ</a></li>
			<li><a href='/miso/#miso_intro_box'>홍보대사 소개</a></li>
			<li><a href='/miso/#req_tour_box'>캠퍼스투어 신청</a></li>
			<li><a href='/miso/board'>캠퍼스투어 후기</a></li>
			<li><a href='/miso/guestBook'>방명록</a></li>
			<c:if test="${sessionScope.member.authority==1}">
				<li><a href='/miso/tourList'>캠퍼스투어 신청 내역</a></li>
			</c:if>
			<c:choose>
				<c:when test="${sessionScope.member==null }">
					<li><a href='/miso/login'>로그인</a></li>
				</c:when>
				<c:otherwise>
					<li><a href='/miso/logout'>로그아웃</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</nav>
</body>

</html>