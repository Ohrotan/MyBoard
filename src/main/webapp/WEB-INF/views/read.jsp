<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<head>
<meta charset="UTF-8">
<style>
.album {
	margin: 20px auto;
	width: 1000px;
	border: 2px solid #2196F3;
	border-radius: 30px;
}

}
.album table {
	width: 900px;
	margin: auto;
	padding-top: 30px;
}

.album table th {
	padding: 30px;
}

.album table tr td:first-child {
	width: 100px;
}

.album table td {
	padding: 10px;
}

.album input, textarea {
	width: 500px;
	padding: 10px;
	font-size: 15px;
}

.album textarea {
	height: 300px;
	resize: none;
}

button {
	font-size: 16px;
	margin: auto;
	border-radius: 8px;
	background: white;
	padding: 7px;
}

button:hover {
	background: #186fb5;
	color: white;
}

.btn_box:before, .btn_box:after {
	clear: both;
	display: block;
	content: "";
}

.btn_box div {
	width: 100px;
	float: right;
}

.comment_div td:first-child {
	text-align: center;
}

.comment_div textarea {
	height: 100px;
	width: 550px;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="album">
		<form action="update" method="post">
			<div style="height: 540px; margin: 50px;">
				<table>
					<tr>
						<td>학교명</td>
						<td>${boardVO.school}</td>

					</tr>
					<tr>
						<td>방문일자</td>
						<td>${boardVO.visitdate}</td>
						<td>글쓴시각</td>
						<td>${boardVO.regdate}</td>
					</tr>
					<tr>
						<td>사진</td>
						<td colspan="3"><img src="../../resources/${boardVO.pic}"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td colspan="3">${boardVO.content}</td>
					</tr>
				</table>


			</div>
			<hr>

			<div class="btn_box">
				<div>
					<button type="button" id="albumList">목록보기</button>
				</div>

				<c:if test="${sessionScope.member.authority == 1}">

					<div>
						<button type="button" id="delete" value="${boardVO.bno}">삭제하기</button>
					</div>
					<div>
						<button type="button" id="update">수정하기</button>
					</div>
				</c:if>
			</div>
		</form>
		<hr>
		<form role="form" method="post">
			<input type="hidden" name="bno" value="${boardVO.bno}">
		</form>
		<form role="form" action="update" method="post">
			<input type='hidden' name='bno' value="${boardVO.bno }"> <input
				type='hidden' name='page' value="${cri.page }"> <input
				type='hidden' name='perPageNum' value="${cri.perPageNum }">
			<input type='hidden' name='searchType' value="${cri.searchType }">
			<input type='hidden' name='keyword' value="${cri.keyword }">
		</form>
		<jsp:include page="comment.jsp"></jsp:include>

	</div>
</body>
<script>
	$(document).ready(function() {
		$('#albumList').on('click', function() {
			location.href = 'board';
		});
		$('#delete').on('click', function() {
			if (confirm("정말 삭제하시겠습니까?") == true) {
				location.href = "/miso/delete/" + this.value;
			}
		});
		$('#update').on('click', function() {
			formObj.attr("action", "/miso/update");
			formObj.attr("method", "get");
			formObj.submit();
		});

		var formObj = $("form[role='form']");

	});
</script>
</html>