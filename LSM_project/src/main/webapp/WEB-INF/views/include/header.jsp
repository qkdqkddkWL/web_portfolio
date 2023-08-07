<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
	<div>
		
		<div id="main-title" class="menubar" >
			<img src="/images/movie.png" style="vertical-align: middle;">
			<a href="/index" >영화방</a>
		</div>
		<div class="menubar" class="sub" >
			<a href="/board/reviewList?pg=1&genre=new">최신영화</a>
		</div>
		<div class="menubar" class="sub">
			<a href="/board/reviewList?pg=1&genre=로맨스 ">로맨스</a>
		</div>
		<div class="menubar" class="sub">
			<a href="/board/reviewList?pg=1&genre=액션 ">액션</a>
		</div>
		<div class="menubar" class="sub">
			<a href="/board/reviewList?pg=1&genre=sf/판타지 ">sf/판타지</a>
		</div>
	



	<c:if test="${id == null}">
		
			<div id="login" onclick="location.href='/member/loginForm';">
				<img src="/images/enter.png;">
				<span>로그인</span>
			</div>

	</c:if>

		<c:if test="${id != null}">
		
			<div id="loginOk">

			<span class="id-form">
			  <strong>${id} 님</strong>
			  <img src="/images/arrow.png">
			</span>

				<c:if test="${role eq 'admin'}">
					<ul id="menu" class="Ab">
						<li><a href="/board/adminpage/management?pg=1"><img
								src="/images/myuser.png"> <span>회원 관리</span></a></li>
						<li><a href=""><img
								src="/images/logout.png"> <span>문의 내역</span></a></li>
					    <li><a href="/member/logout"><img
								src="/images/logout.png"> <span>logout</span></a></li>
					</ul>
				</c:if>

				<c:if test="${role eq 'user'}">
					<ul id="menu" class="Ab">
						<li><a href="/board/myProfile"><img
								src="/images/myuser.png"> <span>내 정보</span></a></li>
						<li><a href="/board/boardWriteForm"><img
								src="/images/contract.png"> <span>글 작성하기</span></a></li>
						<li><a href="/member/logout"><img
								src="/images/logout.png"> <span>logout</span></a></li>
					</ul>
				</c:if>
			</div>

		</c:if>
		</div>
	</header>
