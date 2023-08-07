<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

	<div id="question-form">
		<div id="title-form"><h2>1대1 문의하기</h2></div>
	
		<form action="/board/inqiresWrite" method="POST">
			<label id="question-title">1:1 문의 질문 등록하기</label>
			<textarea id="question" name="question" placeholder="질문을 입력해주세요"></textarea>
			<br>
			<input type="submit" value="보내기">
		</form>
	</div>
