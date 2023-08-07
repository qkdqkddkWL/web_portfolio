<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<div id="myreview-container">

		<div id="title-form">
			<h1 class="head-title">문의 내역</h1>
		</div>

		<table id="answerList">
			<thead>
				<tr>
					<td>작성자</td>
					<td>문의 내용</td>
					<td>작성일</td>
					<td>답변 상태</td>
				</tr>
			</thead>

			<tbody>

				<c:forEach var="dto" items="${list}">

					<tr class="title-tr">
						<td class="id" style="display: none;">${dto.id}</td>
						<td><a class="user-id" href="">${dto.user_id}</a></td>
						<td class="question">${dto.question}</td>
						<td>${dto.writedate}</td>

						<c:if test="${empty dto.answerdate}">
							<td class="answer-state" style="color: blue">대기</td>
						</c:if>

						<c:if test="${not empty dto.answerdate}">
							<td class="answer-state" style="color: red">완료</td>
						</c:if>
					</tr>

				</c:forEach>

			</tbody>
		</table>

	</div>
