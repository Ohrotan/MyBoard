<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<form id="cmt_form" action="comment/all" method="post" role="form">
		<input type="hidden" value="${boardVO.bno }">
		<div class="comment_div" style="margin: 50px;">

			<table>
				<tr>
					<th style="width: 110px;">작성자</th>
					<th>내용</th>
					<th>작성일자</th>
				</tr>
				<tbody id="cmtList">
					<c:forEach items="${clist }" var="cVO">
						<tr>
							<td>${cVO.name}</td>
							<td>${cVO.content }</td>
							<td>${cVO.regdate }</td>
							<c:if
								test="${(sessionScope.member.id==cVO.id)||(sessionScope.member.authority==1)}">
								<td>
									<button type="button"
										onclick="update(${cVO.cno},'${cVO.content }')" class="btn btn-warning"
										>수정</button>
									<button type="button" onclick="deleteCmt(${cVO.cno})" value="${cVO.cno}" class="btn btn-danger">삭제</button>
								</td>
							</c:if>
						</tr>
					</c:forEach>
				</tbody>

				<c:if test="${sessionScope.member!=null}">
					<tr>
						<td>${sessionScope.member.name}</td>
						<td><textarea id="content"></textarea></td>
						<td><button type="button" id="cmt_reg" class="btn btn-primary">댓글달기</button></td>

					</tr>
				</c:if>
				<c:if test="${sessionScope.member==null}">
					<tr>
						<td>비회원</td>
						<td><textarea disabled>회원만 댓글을 달 수 있습니다. 로그인 해주세요!</textarea></td>
						<td><button type="button" disabled="disabled" class="btn btn-primary">댓글달기</button></td>

					</tr>
				</c:if>
			</table>
		</div>
	</form>
</body>
<script>
var updateCno;
	var update = function(cno,content) {
		alert(cno);
		$('#content').text(content);
		updateCno=cno;
		location.href='#content';
	}
	
	var deleteCmt = function(cmt) {
		location.href = "/miso/comment/delete/"
				+ cmt;
	}
	
	$(document)
			.ready(
					function() {

						var formObj = $("form[role='form']");

						$('#cmt_reg').on('click', function() {
							var obj = $('#cmt_form').serialize();
if(updateCno!=null){
	$.ajax({
		method : 'post',
		url : '/miso/comment/update',
		headers : {
			"Content-type" : "application/json",
		},
		data : JSON.stringify({
			cno: updateCno,
			bno : '${boardVO.bno}',
			content : $('#content').val(),
			name : '${sessionScope.member.name}',
			id : '${sessionScope.member.id}'

		}),
		success : function(result) {
			console.log(result);
			alert("수정되었습니다.");
			$('#content').val("");
			updateCno=null;
			getAllList();
		}
	})
}else{
							$.ajax({
								method : 'post',
								url : '/miso/comment/write',
								headers : {
									"Content-type" : "application/json",
								},
								data : JSON.stringify({
									bno : '${boardVO.bno}',
									content : $('#content').val(),
									name : '${sessionScope.member.name}',
									id : '${sessionScope.member.id}'

								}),
								success : function(result) {
									console.log(result);
									alert("등록되었습니다.");
									$('#content').val("");
									getAllList();
								}
							})
}
						});

						function getAllList() {
							$.getJSON("/miso/comment/all/"+ '${boardVO.bno}',
											function(data) {
												var str = "";
												$(data)
														.each(
																function() {
																	str += "<tr><td>"
																			+ this.name
																			+ "</td><td>"
																			+ this.content
																			+ "</td><td>"
																			+ this.regdate
																			+ "</td><c:if test='${(sessionScope.member.id==cVO.id)||(sessionScope.member.authority==1)}'>"
																			+ "<td><button type='button' id='cmt_update' value='${cVO.cno}'>수정</button><button type='button' "
					+"id='cmt_delete' value='${cVO.cno}'>삭제</button></td></c:if></tr>";
																});

												$('#cmtList').html(str);
											});
						}
					});
</script>
</html>