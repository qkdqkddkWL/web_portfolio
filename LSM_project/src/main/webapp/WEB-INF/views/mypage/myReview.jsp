<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>




	
	
	<div id="myreview-container">
	
		<div id="title-form">
			<h1 class="head-title">내가 올린 글(${total})</h1>
		</div>

	<table>
		<thead>
			<tr>
				<td>제목</td>
				<td>장르</td>
				<td>평점</td>
				<td>작성일</td>
				<td>조회수</td>
			</tr>
		</thead>
		<c:forEach var="dto" items="${list}">

			<tbody>
				<tr>
					<td class="title"><a class="title"
						href="/board/boardView?seq=${dto.id}">${dto.title}</a></td>
					<td>${dto.genre}</td>
					<td>${dto.rating}</td>
					<td>${dto.regdate}</td>
					<td>${dto.hit}</td>
				</tr>

			</tbody>

		</c:forEach>

	</table>
</div>
	
	
	
	<div id="pg-container">
		<div id="pg">

		
			<c:if test="${startPage > 5 }">
				<a class="paging" href="/board/myReview?pg=1">[맨앞]</a>
				<a class="paging" href="/board/myReview?pg=${startPage - 1}">[이전]</a>
			</c:if>

			<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
				<c:if test="${i == pg }">
					<a class="currentPaging" href="javascript:void(0);" >[${i}]</a>
				</c:if>

				<c:if test="${i != pg }">
					<a class="paging" href="/board/myReview?pg=${i}">[${i}]</a>
				</c:if>
				
			</c:forEach>

			<c:if test="${endPage < totalPage }">
				<a class="paging" href="/board/myReview?pg=${endPage + 1}">[다음]</a>
				<a class="paging" href="/board/myReview?pg=${totalPage}">[맨끝]</a>
			</c:if>
		</div>
	</div>
	
