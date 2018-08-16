<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
.album {
	margin: auto;
	width: 1000px;
	background: #d6edff;
	height: 600px
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
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="album">
		<form action="write" method="post" enctype="multipart/form-data">
			<div style="height: 540px;">
				<table>
					<tr>
						<td>학교명</td>
						<td><input type="text" name="school"></td>
					</tr>
					<tr>
						<td>방문일자</td>
						<td><input type="date" name="visitdate"></td>
					</tr>
					<tr>
						<td>사진</td>
						<td><input type="file" name="file"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea name="content"></textarea></td>
					</tr>
				</table>

			</div>
			<div style="width: 100px; float: right;">
				<button id="write" type="submit">올리기</button>
			</div>
		</form>
	</div>
</body>
</html>