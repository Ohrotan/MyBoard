<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style>
.album {
	margin: auto;
	width: 1000px;
	height: 625px;
	border: 2px solid #2196F3;
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

.err {
	font-size: 25px;
	color: #2196F3;
	text-align: center;
	margin-top: 100px;
}
</style>

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<c:choose>
		<c:when test="${sessionScope.member.authority!=1 }">
			<div class="err">접근 권한이 없습니다.</div>
		</c:when>
		<c:otherwise>
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
							<option value="na"
								<c:out value="${cri.searchType =='c'?'selected':'' }"/>>
								신청자명</option>
							<option value="p"
								<c:out value="${cri.searchType =='c'?'selected':'' }"/>>
								전화번호</option>
							<option value="d"
								<c:out value="${cri.searchType =='c'?'selected':'' }"/>>
								방문일자</option>
							<option value="sn"
								<c:out value="${cri.searchType =='sc'?'selected':'' }"/>>
								학교명 + 신청자명</option>

						</select> <input type="text" name="keyword" id="keywordInput"
							value='${cri.keyword }'>
						<button id="searchBtn" type="button">Search</button>
					</div>

					<table style="width: 1000px;">
						<tr>
							<th style="text-align: center;">번호</th>
							<th style="width: 200px;">학교명</th>
							<th style="width: 150px;">방문일자</th>
							<th style="width: 150px;">신청자명</th>
							<th style="width: 150px;">전화번호</th>
							<th>신청인원</th>
						</tr>
						<c:if test="${list!=null }">
							<c:forEach items="${list}" var="tour">

								<tr>
									<td>${tour.tno }</td>
									<td style="text-align: left;">${tour.school }</td>
									<td>${fn:substring(tour.visitdate, 0, 10)}</td>
									<td>${tour.name }</td>
									<td>${tour.phone }</td>
									<td><span class="badge bg-red">${tour.pnum}</span></td>
									<td><button type="button" id="delete_btn"
											value="${tour.tno }">삭제</button></td>
								</tr>

							</c:forEach>
						</c:if>
					</table>
					<div class="text-center">
						<ul class="pagination">
							<c:if test="${pageMaker.prev }">
								<li><a
									href="tourList${pageMaker.makeSearch(pageMaker.startPage -1) }">&laquo;</a></li>
							</c:if>

							<c:forEach begin="${pageMaker.startPage }"
								end="${pageMaker.endPage }" var="idx">
								<li
									<c:out value="${pageMaker.cri.page ==idx?'class=active':'' }"/>>
									<a href="tourList${pageMaker.makeSearch(idx) }">&nbsp;&nbsp;${idx }&nbsp;&nbsp;</a>

								</li>
							</c:forEach>

							<c:if test="${pageMaker.next && pageMaker.endPage>0}">
								<li><a
									href="tourList${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
							</c:if>
						</ul>
						<form id="jobForm">
							<input type='hidden' name="page"
								value=${pageMaker.cri.perPageNum }> <input type='hidden'
								name="perPageNum" value=${pageMaker.cri.perPageNum }>
						</form>
					</div>
				</div>


			</div>
		</c:otherwise>
	</c:choose>

</body>
<script>
	$(document).ready(
			function() {
				$('#delete_btn').on('click', function() {
					if (confirm("정말 삭제하시겠습니까?") == true) {
						console.log(this.value);
						location.href = 'tourDelete/' + this.value;
					}
				});

				$('#searchBtn').on(
						"click",
						function(event) {

							self.location = "tourList"
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