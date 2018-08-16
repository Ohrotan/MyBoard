<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="robots" content="index, follow">


<title>MISO:)</title>
<meta name="description"
	content="A responsive Jekyll theme for dental clinics.">

<!-- Stylesheet -->

<!-- Favicon -->
<link rel="shortcut icon" href="/../../img/smile.png">

<style>
#tour_intro_box {
	background: #d6edff;
}

#miso_intro_box {
	background: #02b0ff;
}

#req_tour_box {
	background: #1870b5;
}

.box_header {
	text-align: center;
	margin-top: 0;
	margin-bottom: 20px;
	padding: 30px;
}

.box_content {
	padding: 100px;
	padding-top: 0;
	margin-bottom: 0px;
}

form div {
	line-height: 50px;
	font-size: 20px;
	color: white;
	text-shadow: 2px 2px 2px #3F51B5;
}

input {
	line-height: 30px;
	width: 300px;
}

button[type=submit] {
	font-size: 25px;
	margin: auto;
	border-radius: 8px;
	background: white;
	padding: 10px;
}

button[type=submit]:hover {
	background: #186fb5;
	color: white;
}

#req_tour_box .box_content {
	width: 500px;
	margin: auto;
}

.box_content:before, .box_content:after {
	clear: both;
	display: block;
	content: '';
}

.submit_btn {
	margin: 40px auto;
	width: 200px;
}

img {
	border-radius: 10px;
	float: left;
}

img:before, img:after, #miso_explain:before, #miso_explain:after {
	clear: both;
	display: block;
	content: '';
}

#tour_explain {
	float: left;
	width: 900px;
	color: #3f51b5;
	font-size: 17px;
	font-weight: bold;
	margin: 50px;
	margin-right: 0;
}

#miso_explain {
	float: left;
	width: 525px;
	color: white;
	font-size: 25px;
	font-weight: bold;
	margin: 50px;
	margin-right: 0;
}
</style>

</head>

<body data-spy="scroll" data-offset="80" data-target=".scrollspy"
	id="top">
	<!-- Start Header -->
	<jsp:include page="header.jsp"></jsp:include>
	<div id="tour_intro_box">
		<h2 class="box_header">캠퍼스투어 소개</h2>
		<div class="box_content">
			<img src="/miso/resources/img/pyr.jpg" style="width: 1300px">
			<div id="tour_explain">

				1. 진행일: <br>각 중·고교에서 원하는 일정에 맞추어 진행 [단, 일정 중복 시 조정] <br> <br>2.
				진행가능 기간: <br>2018.4.16.(월) ~ 2019.1.31.(목)<br> [주말 및 공휴일은
				진행하지 않음] <br> <br> 3. 진행가능 시간:<br> 학기 중 10:00 ~ /
				14:00 ~ 방학 중 10:30 ~ / 14:30 ~<br> <br> 4. 진행자:<br>
				본교 홍보대사 ‘미소’ [홍보대사 보기]<br> <br> 5. 진행시간: 2시간 이내<br> <br>
				6. 문의:<br> 입학관리팀 02-820-0050~0054 / Fax: 02-820-0022<br>
			</div>
		</div>
	</div>
	<div id="miso_intro_box">
		<h2 class="box_header" style="color: white">미소란?</h2>
		<div class="box_content">
			<img src="/miso/resources/img/miso.jpg">
			<div id="miso_explain">
				미소는 2006년 1기를 시작으로 중·고등학생 및 학부모를 위한 캠퍼스투어 진행, 학교홍보책자 모델, 대입 입시설명회 진행
				등의 업무를 맡아 예비 숭실인들에게 숭실대학교를 알리는 역할을 수행하고 있습니다.<br>미소는 '아름다운 마음'과
				'밝은 웃음' 으로 여러분에게 다가가는 숭실대학교 홍보대사입니다. ​숭실대학교의 대표가 되어 예비 숭실인들에게 본교를
				알리는 역할을 수행하고 있습니다.
			</div>
		</div>
	</div>
	<div id="req_tour_box">
		<h2 class="box_header" style="color: white">캠퍼스투어 신청</h2>
		<div class="box_content">

			<form action="reqTour" id="tour_form" method="post">

				<div>
					학교명&nbsp;&nbsp;&nbsp; <input type="text" placeholder="신청학교명"
						name="school">
				</div>
				<div>
					신청자명 <input type="text" placeholder="신청자명" name="name">
				</div>
				<div>
					전화번호 <input type="text" placeholder="전화번호" name="phone">
				</div>
				<div>
					방문일자 <input type="date" placeholder="방문일자" name="visitdate">
				</div>
				<div>
					신청인원 <input type="number" placeholder="신청인원" name="pnum">
				</div>
				<div class="submit_btn">
					<button id="reqTour" type="button">신청하기</button>
				</div>
			</form>
		</div>
	</div>
	<!-- Start Footer -->
	<footer class="main-footer">
		<div class="container-fluid">

			<small> © 2006 MISO - All rights reserved </small>

		</div>
	</footer>
	<!-- End Footer -->

	<script>
		$('#reqTour').on('click', function() {
			if (confirm("신청이 완료되었습니다.") == true) {
				$('#tour_form').submit();
			}
		});
	</script>

</body>
</html>
