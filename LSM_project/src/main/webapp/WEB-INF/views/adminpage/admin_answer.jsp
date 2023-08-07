<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h2>${param.user_id} : ${param.question}</h2>
<form action="/board/adminpage/adminAnswerWrite">
	<input type="hidden" name="seq" value="${param.id}">
    <textarea name="content" rows="15" style="width: 100%;" id="replyTextarea" placeholder="답변을 작성해주세요"></textarea>
    <br>
    <button id="submit">등록</button>
</form>


