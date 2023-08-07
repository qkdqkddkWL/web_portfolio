<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<div id="s">

		<div class="search"  >
			<form method="get" action="/board/boardsearch">
				<input type="hidden" name="pg" value="1">
			<div>

					<input name="content" type="text" placeholder="검색어 입력" maxlength="18" >
					

					<select name="word">
						<option value="title">제목</option>
						<option value="writer">작성자</option>
						<option value="overall">제목+작성자</option>
					</select>

			</div>

				<button type="submit">
					<img src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/icon/search.png">
				</button>
			</form>
		</div>
		



		<!--  -->
		<p style="clear: both;">&nbsp;</p>



		<ul id="movieList-container">
			<c:if test="${list.size() == 0}">
				<h2 style="">게시글이 없습니다</h2>
			</c:if>
			
			
			<c:forEach var="dto" items="${list}">
				<li class="item"><a href="/board/boardView?seq=${dto.id}">
						<c:if test="${empty dto.img}">
							<img src="/images/images.png">
						</c:if> 
						<c:if test="${not empty dto.img}">
							<img src="/storage/${dto.img}">
						</c:if></a>
					<div class="title-font">${dto.title}</div>
				</li>
			</c:forEach>
		</ul>
		
		
		<!-- 페이징 -->
		
		<div id="pg">

			<c:if test="${empty word}">
			<c:if test="${startPage > 5 }">
				<a class="paging" href="/board/reviewList?pg=1&genre=${genre}">[맨앞]</a>
				<a class="paging" href="/board/reviewList?pg=${startPage - 1}&genre=${genre}">[이전]</a>
			</c:if>

			<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
				<c:if test="${i == pg }">
					<a class="currentPaging" href="javascript:void(0);">[${i}]</a>
				</c:if>

				<c:if test="${i != pg }">
					<a class="paging" href="/board/reviewList?pg=${i}&genre=${genre}">[${i}]</a>
				</c:if>

			</c:forEach>

			<c:if test="${endPage < totalPage }">
				<a class="paging" href="/board/reviewList?pg=${endPage + 1}&genre=${genre}">[다음]</a>
				<a class="paging" href="/board/reviewList?pg=${totalPage}&genre=${genre}">[맨끝]</a>
			</c:if>
			</c:if>
			
			
			<c:if test="${not empty word}">
			<c:if test="${startPage > 5 }">
				<a class="paging" href="/board/boardsearch?pg=1&content=${content}&word=${word}">[맨앞]</a>
				<a class="paging" href="/board/boardsearch?pg=${startPage - 1}&content=${content}&word=${word}">[이전]</a>
			</c:if>

			<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
				<c:if test="${i == pg }">
					<a class="currentPaging" href="javascript:void(0);">[${i}]</a>
				</c:if>

				<c:if test="${i != pg }">
					<a class="paging" href="/board/boardsearch?pg=${i}&content=${content}&word=${word}">[${i}]</a>
				</c:if>

			</c:forEach>

			<c:if test="${endPage < totalPage }">
				<a class="paging" href="/board/boardsearch?pg=${endPage + 1}&content=${content}&word=${word}">[다음]</a>
				<a class="paging" href="/board/boardsearch?pg=${totalPage}&content=${content}&word=${word}">[맨끝]</a>
			</c:if>
			</c:if>


		</div>

	</div>
