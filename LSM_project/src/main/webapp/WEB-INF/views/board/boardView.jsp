<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
 var isNull= ${id == null};
 var state= ${state};
 var seq=${param.seq};
 var id="${id}";

</script>


	<div class="swiper-container" style="margin-top: 200px;">
		<div class="swiper-wrapper">

			<c:if test="${imgs.size() == 0 }">
				<div class=swiper-slide>
	
					<img src="/images/images.png">
				</div>
			</c:if>
			
			<c:if test="${imgs.size() > 0 }">
				<c:forEach var="img" items="${imgs}">

					<div class=swiper-slide>
						<img src="/storage/${img}">
					</div>
				</c:forEach>
			</c:if>
		</div>
		<!-- 네비게이션 -->
		<div class="swiper-button-next"></div>
		<!-- 다음 버튼 (오른쪽에 있는 버튼) -->
		<div class="swiper-button-prev"></div>
		<!-- 이전 버튼 -->
	</div>
	<!--  -->
	

	<div id="content-header">
	
		<div class="title-box">
			<span>
				${dto.title}
			</span>

		</div>

		
		<div class="gerne-box">
			<span>
				${dto.genre}
			</span>
			
						
			<span id="rating" style="float: right">
				평점 : ${dto.rating}점
			</span>
		</div>
		
		<div class="id-box">
			<span>
				<img src="/images/user.PNG">
				${dto.member_id}
			</span>
			
			<span id="recommend" style="float: right"> 
			 	<img id="good-button" src="/images/good.png"> 좋아요
			 	<span id="recommend-count">${count}</span> 
			</span>

		</div>
		
		<div style="text-align: right;">
			<span style="color: gray; font-size: 13px;">조회 ${dto.hit}</span>
		</div>
		
		
		<c:if test="${dto.member_id == id}">		
		
		<div class="change-button">
			<span>
				<a href="/board/boardModifyForm?seq=${dto.id}">
					<img src="/images/modify.PNG">수정
				</a>
			</span>
			<span>
				<a href="/board/boardDelete?seq=${dto.id}">
					<img src="/images/delete.PNG">삭제
				</a>
			</span>
		</div>
		
		</c:if>
	</div>

	<hr>
	<div id="content">
		${dto.content}
	</div>
	<hr>
	
	
	<!-- 댓글 -->
	<div id="reply-form">
			<strong id="reply" >댓글 ${replyTotal}</strong>
			

			
		<c:forEach var="dto" items="${list}">

			
		
			<div class="reply-total">
			
				<c:if test="${dto.re_lev >= 1 }">
					<c:forEach begin="1" end="${dto.re_lev}">
						<div style="float: left;">&nbsp;&nbsp;&nbsp;</div>
					</c:forEach>
				</c:if>
				
			<div>
				<img class="user" src="/images/user.PNG" align="left">
					
				<p style="font-size: 15px;">
					<strong>${dto.member_id}</strong>
				</p>
				
				<p style="font-size: 15px;">${dto.content}</p>
				<p style="font-size: 11px; color: gray; display: inline;">${dto.regdate}</p>

				<c:if test="${dto.member_id == id}">
					<span class="modify-button" >수정</span>
				</c:if>
				
				<span class="reply-button" >답글쓰기</span>
				
				
				<hr	class="reply_hr">
				
			</div>
			
			<!-- 답글 달기 -->
			<div class="re_reply" style="display:none;">
					<c:if test="${id == null }">
						<p>로그인을 해주세요</p>
					</c:if>
					<c:if test="${id != null }">
						<p>${id}</p>
					</c:if>
					<form action="/board/replyWrite" method="post" name="re_replyFrm">
						<input type="hidden" name="re_lev" value="${dto.re_lev}">
						<input type="hidden" name="re_ref" value="${dto.re_ref}">
						<input type="hidden" name="re_seq" value="${dto.re_seq}">
						<textarea id="replyContent" name="content" rows=1; cols=30;
							placeholder="댓글을 입력하세요"></textarea>
						<input  id="re_reply_submit" type="submit" value="등록" >
					</form>
			</div>
			<!-- 댓글 수정하기 -->
			<div class="reply_modify" style="display:none;">
					<c:if test="${id == null }">
						<p>로그인을 해주세요</p>
					</c:if>
					<c:if test="${id != null }">
						<p>${id}</p>
					</c:if>
					<form action="/board/replyModify" method="post"name="re_replyModifyFrm">
						<input type="hidden" name="re_lev" value="${dto.re_lev}">
						<input type="hidden" name="re_ref" value="${dto.re_ref}">
						<input type="hidden" name="re_seq" value="${dto.re_seq}">
						<textarea id="replyContent" name="content" rows=1; cols=30;
							placeholder="수정할 내용을 입력하세요"></textarea>
						<input id="re_modify_submit" type="submit" value="수정">
					</form>
			</div>
		</div>
		</c:forEach>
		







<!-- 댓글달기 -->
	<hr id="comment_hr">

		<div id="CommentWriter" style="margin-top: 200px;">
			<c:if test="${id == null }">
				<p>로그인을 해주세요</p>
			</c:if>
			<c:if test="${id != null }">
				<p>${id}</p>
			</c:if>
			
			<form action="/board/replyWrite" method="post" name="replyFrm">
				<input type="hidden" name="re_ref" value="${dto.id}">
				<input type="hidden" name="re_lev" value="${re_lev}"> 
				<input type="hidden" name="re_seq" value="${re_seq}">
				
				<textarea id="replyContent" name="content" rows=1; cols=35;
					placeholder="댓글을 남겨보세요"></textarea>
					
				<input id="reply_submit" type="submit" value="등록">
				
			</form>

		</div>


	</div>
	
