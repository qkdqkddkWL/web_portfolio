<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

	<div id="myreview-container">
	
		<div id="title-form">	
			<h1 class="head-title"  >문의 내역</h1>
		</div>

	<table id="answerList">
		<thead>
			<tr>
				<td>작성자</td>
				<td>문의 내용</td>
				<td>작성일</td>
				<td>문의 상태</td>
			</tr>
		</thead>
		
			<tbody>
			
				<c:forEach var="dto" items="${list}">
				
					<tr class="title-tr">
						<td><a class="title" href="">${dto.user_id}</a></td>
						<td>${dto.question}</td>
						<td>${dto.writedate}</td>

						<c:if test="${empty dto.answerdate}">
							<td class="answer-state" style="color: blue">답변 대기</td>
						</c:if>

						<c:if test="${not empty dto.answerdate}">
							<td class="answer-state" style="color: red">답변 완료</td>
						</c:if>
					</tr>

					<c:if test="${not empty dto.answerdate }">
						<tr class="answer">
							<td colspan="4">
								<div style="text-align: center; font-size: 16px; color:red;">
									<div class="answer-header">
										<div class="answer-header">${dto.admin_id}1:1 문의에 대한
											답변입니다. ${dto.answerdate}</div>
									</div>
									<br>

									<div class="answer-content">${dto.answer}</div>
								</div>
							</td>
						</tr>
					</c:if>

					<c:if test="${empty dto.answerdate }">
						<tr class="answer">
							<td colspan="4">
								<div style="text-align: center; font-size: 16px; color: blue;">
									<div class="answer-header">
										<div class="answer-header">답변 대기중입니다</div>
									</div>
								</div>
							</td>
						</tr>
					</c:if>
				</c:forEach>
					
			</tbody>
	</table>

	</div>
