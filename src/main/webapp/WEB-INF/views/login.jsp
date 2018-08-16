<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
.login {
	border: 2px solid #000069;
	border-radius: 10px;
	width: 500px;
	height: 300px;
	margin: 100px auto;
}

.login h2 {
	color: #000069;
	text-align: center;
	padding-top: 30px;
}

#login_form {
	width: fit-content;
	margin: auto;
	color: #000069;
}

#login_form input {
	line-height: 30px;
	padding: 5px;
	margin: 10px;
}

#login_form button {
	width: 100px;
	height: 50px;
	font-size: 20px;
	margin: 14px;
	margin-top: 10px;
}

#login_form label {
	width: 80px;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="login">
		<h2>로그인</h2>
		<form id="login_form" method="post" action="login">
			<div>
				<label>ID</label><input type="text" placeholder="id" name="id">
			</div>
			<div>
				<label>Password</label><input type="password" placeholder="password"
					name="pwd">
			</div>

			<button type="button" class="btn btn-success">회원가입</button>
			<button type="submit" style="margin-right: 20px;"
				class="btn btn-primary">로그인</button>
		</form>
	</div>
</body>
</html>