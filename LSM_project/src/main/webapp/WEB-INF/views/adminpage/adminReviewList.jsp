<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

		
	<div id="myreview-container">
	
		<div id="title-form">
			<h1 class="head-title">전체 글 목록(${total})</h1>
		</div>
		
		<form action="/board/adminpage/listDelete">
			<table>
				<thead>
					<tr>
						<td></td>
						<td>작성자</td>
						<td>제목</td>
						<td>장르</td>
						<td>평점</td>
						<td>작성일</td>
						<td>조회수</td>
					</tr>
				</thead>

				<c:forEach var="dto" items="${list}">

					<tbody id="content">
						<tr>
							
							<td><input class="check" type="checkbox"
								style="width: 15px; height: 15px;" name="review_id" value="${dto.id}"></td>
							<td>${dto.member_id}</td>
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
			<div  style="position: absolute; bottom: 280px;left:1500px;">
				<button style=" display: inline-block;
  padding: 10px 20px;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 16px;" id="deleteButton" type="submit">일괄 삭제</button>
				
			</div>

		</form>
		

	
</div>
	
	
	
	<div id="pg-container">
		<div id="pg">

		
			<c:if test="${startPage > 5 }">
				<a class="paging" href="/board/adminpage/adminReviewList?pg=1">[맨앞]</a>
				<a class="paging" href="/board/adminpage/adminReviewList?pg=${startPage - 1}">[이전]</a>
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
				<a class="paging" href="/board/adminpage/adminReviewList?pg=${endPage + 1}">[다음]</a>
				<a class="paging" href="/board/adminpage/adminReviewList?pg=${totalPage}">[맨끝]</a>
			</c:if>
		</div>
	</div>
	
