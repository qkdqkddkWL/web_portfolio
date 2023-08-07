<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="myreview-container">
	
		<div id="title-form">
			<h1 class="head-title">회원 목록(${total})</h1>
		</div>

	<table>
		<thead>
			<tr>
				<td>아이디</td>
				<td>닉네임</td>
				<td>가입일</td>
				<td>이메일</td>
			</tr>
		</thead>
		<c:forEach var="dto" items="${list}">
			<tbody>
				<tr>
					<td class="title"><a class="title"
						href="">${dto.id}</a></td>
					<td>${dto.name}</td>
					<td>${dto.rgdate}</td>
					<td>${dto.email}</td>
					
				</tr>

			</tbody>

		</c:forEach>

	</table>
</div>
	<div id="pg-container">
		<div id="pg">

		
			<c:if test="${startPage > 5 }">
				<a class="paging" href="/board/adminpage/management?pg=1">[맨앞]</a>
				<a class="paging" href="/board/adminpage/management?pg=${startPage - 1}">[이전]</a>
			</c:if>

			<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
				<c:if test="${i == pg }">
					<a class="currentPaging" href="javascript:void(0);" >[${i}]</a>
				</c:if>

				<c:if test="${i != pg }">
					<a class="paging" href="/board/adminpage/management?pg=${i}">[${i}]</a>
				</c:if>
				
			</c:forEach>

			<c:if test="${endPage < totalPage }">
				<a class="paging" href="/board/adminpage/management?pg=${endPage + 1}">[다음]</a>
				<a class="paging" href="/board/adminpage/management?pg=${totalPage}">[맨끝]</a>
			</c:if>
		</div>
	</div>

	


</body>
</html>