<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

	<div>
		<nav>
			<ul id="mypage-ul">
				<li><a href="/board/myProfile">나의 프로필</a></li>
				<li><a href="/member/memberModifyForm">회원 정보 수정</a></li>
				<li><a href="/board/myReview?pg=1">내 게시글</a></li>
				<li><a href="/board/boardWriteForm">게시글 작성</a></li>
				<li><a href="/board/myRecommendList">좋아요 목록</a></li>	
				<li><a href="/board/userQuestion">1:1 문의하기</a></li>
				<li><a href="/board/inqiresList">1:1 문의내역</a></li>
			</ul>
		</nav>

	</div>


