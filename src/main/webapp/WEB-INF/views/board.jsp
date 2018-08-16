<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style>
.album {
	margin: auto;
	width: 1000px;
	height: 625px;
	border: 2px solid #006;
	border-radius: 30px;
}

.album table th {
	padding: 30px;
}

.album table td {
	padding: 10px;
	text-align: center;
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

.pagination {
	width: fit-content;
	margin: auto;
}

.searchbar {
	margin: 20px;
	margin-bottom: -20px;
}
</style>

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div class="album">
		<div style="height: 540px;">
			<div class="searchbar">
				<select name="searchType">
					<option value="n"
						<c:out value="${cri.searchType ==null?'selected':'' }"/>>
						---</option>
					<option value="s"
						<c:out value="${cri.searchType == 't'?'selected':'' }"/>>
						학교명</option>
					<option value="c"
						<c:out value="${cri.searchType =='c'?'selected':'' }"/>>
						내용</option>
					<option value="sc"
						<c:out value="${cri.searchType =='sc'?'selected':'' }"/>>
						학교 + 내용</option>

				</select> <input type="text" name="keyword" id="keywordInput"
					value='${cri.keyword }'>
				<button id="searchBtn" class="btn btn-primary" type="button">Search</button>
				<c:if test="${sessionScope.member.authority==1 }">
					<div style="width: 100px; float: right;">
						<button id="write" class="btn btn-primary">글쓰기</button>
					</div>
				</c:if>
			</div>
			<table style="width: 1000px;">
				<tr>
					<th style="text-align: center;">번호</th>
					<th style="width: 200px;">학교명</th>
					<th style="width: 150px;">방문일자</th>
					<th style="width: 250px;">글쓴시각</th>
					<th>댓글 수</th>
				</tr>
				<c:forEach items="${list}" var="boardVO">

					<tr>
						<td>${boardVO.bno }</td>
						<td style="text-align: left;"><a
							href='/miso/read${pageMaker.makeSearch(pageMaker.cri.page)}&bno=${boardVO.bno}'>${boardVO.school }</a></td>
						<td>${boardVO.visitdate }</td>
						<td>${boardVO.regdate }</td>
						<td><span class="badge bg-red">0</span></td>
					</tr>

				</c:forEach>

			</table>
			<div class="text-center">
				<ul class="pagination">
					<c:if test="${pageMaker.prev }">
						<li><a
							href="board${pageMaker.makeSearch(pageMaker.startPage -1) }">&laquo;</a></li>
					</c:if>

					<c:forEach begin="${pageMaker.startPage }"
						end="${pageMaker.endPage }" var="idx">
						<li
							<c:out value="${pageMaker.cri.page ==idx?'class=active':'' }"/>>
							<a href="board${pageMaker.makeSearch(idx) }">&nbsp;&nbsp;${idx }&nbsp;&nbsp;</a>

						</li>
					</c:forEach>

					<c:if test="${pageMaker.next && pageMaker.endPage>0}">
						<li><a
							href="board${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
					</c:if>
				</ul>
				<form id="jobForm">
					<input type='hidden' name="page" value=${pageMaker.cri.perPageNum }>
					<input type='hidden' name="perPageNum"
						value=${pageMaker.cri.perPageNum }>
				</form>
			</div>
		</div>


	</div>


</body>
<script>
	$(document).ready(
			function() {
				$('#write').on('click', function() {
					location.href = 'write';
				});

				$('#searchBtn').on(
						"click",
						function(event) {

							self.location = "board"
									+ '${pageMaker.makeQuery(1)}'
									+ "&searchType="
									+ $("select option:selected").val()
									+ "&keyword="
									+ encodeURIComponent($('#keywordInput')
											.val());
						});
			});
</script>
</html>