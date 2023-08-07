<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

	
	<div class="home-wrap">
		<img id="home-img"  src="/images/ga.jpg">
		
		<div id="home-text">
			<h1 id="title">영화 리뷰는 영화방에서</h1>
		</div>
		

	</div>	
	
	<div class="movie-list" style="margin-left: 30px;"><h2>최신 영화리뷰</h2></div>
	
	
	<div class="swiper-container">
		<div class="swiper-wrapper">
		
		
			<c:forEach var="dto" items="${list}">
				<c:if test="${empty dto.img}">
					<div class="swiper-slide">
						<a href="/board/boardView?seq=${dto.id}" style="font-weight: 800;"><img src="/images/images.png"> ${dto.title}</a>
					</div>
				</c:if>
				
				<c:if test="${not empty dto.img}">
					<div class="swiper-slide">
						<a href="/board/boardView?seq=${dto.id}" style="font-weight: 800;"><img src="/storage/${dto.img}"> ${dto.title}</a>
						
					</div>
				</c:if>
			</c:forEach>
			
			
		</div>
		
		<!-- 네비게이션 -->
	<div class="swiper-button-next"></div><!-- 다음 버튼 (오른쪽에 있는 버튼) -->
	<div class="swiper-button-prev" ></div><!-- 이전 버튼 -->
			<!-- 페이징 -->
	<div class="swiper-pagination"></div>
	</div>
	
	
	
	
	
	<div class="movie-list"  style="margin-left: 30px;  margin-top:50px;" ><h2>추천 영화리뷰</h2></div>
		<div class="swiper-container2" style="margin-bottom: 200px;">
		<div class="swiper-wrapper">
			<c:forEach var="dto" items="${list2}">
				<c:if test="${empty dto.img}">
					<div class="swiper-slide">
						<a href="/board/boardView?seq=${dto.id}" style="font-weight: 800;"><img src="/images/images.png">${dto.title}</a>
					</div>
				</c:if>
				
				<c:if test="${not empty dto.img}">
					<div class="swiper-slide">
						<a href="/board/boardView?seq=${dto.id}" style="font-weight: 800;"><img src="/storage/${dto.img}">${dto.title}</a>
						
					</div>
				</c:if>
			</c:forEach>
		</div>
	
		<!-- 네비게이션 -->
	<div class="swiper-button-next"></div><!-- 다음 버튼 (오른쪽에 있는 버튼) -->
	<div class="swiper-button-prev" ></div><!-- 이전 버튼 -->
			<!-- 페이징 -->
	<div class="swiper-pagination"></div>
	</div>
