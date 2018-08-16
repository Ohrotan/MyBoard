<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="UTF-8">
<style>
input {
	margin: 6px !important;
	padding: 3px;
}

textarea {
	height: 100px;
	resize: none !important;
	width: 500px;
	padding: 8px;
	border-radius: 10px;
	margin: 10px !important;
}

textarea:focus {
	outline: none;
	background: #e4f6ff;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="">
		<table>
			<tr>
				<td><input type="text" placeholder="작성자"></td>
				<td><input type="text" placeholder="비밀번호"></td>
				<td><button type="button" class="btn btn-primary" id="cmt_reg">방명록 남기기</button></td>
			</tr>
			<tr>
				<td colspan="3"><textarea id="content"
						placeholder="방명록을 남겨주세요."></textarea></td>
			</tr>
		</table>
		<table>
			<tr>
				<th style="width: 110px;">작성자</th>
				<th>내용</th>
				<th>작성일자</th>
			</tr>
			<tr>
				<td>d</td>
				<td>sdf</td>
				<td>sdf</td>
			</tr>
			<tbody id="cmtList">
				<c:forEach items="${clist }" var="cVO">
					<tr>
						<td>${cVO.name}f</td>
						<td>${cVO.content }</td>
						<td>${cVO.regdate }</td>
						<c:if
							test="${(sessionScope.member.id==cVO.id)||(sessionScope.member.authority==1)}">
							<td>
								<button type="button"
									onclick="update(${cVO.cno},'${cVO.content }')">수정</button>
								<button type="button" onclick="deleteCmt(${cVO.cno})"
									value="${cVO.cno}">삭제</button>
							</td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>



		</table>
	</div>
</body>
</html>