<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="myreview-container">
	
		<div id="title-form">
			<h1 class="head-title">자주 묻는 질문</h1>
		</div>

	<table>
		<thead>
			<tr>
				<td>작성자</td>
				<td>제목</td>
				<td>내용</td>
				<td>작성일</td>
			</tr>
		</thead>
		<c:forEach var="dto" items="${list}">
			<tbody>
				<tr>
					<td class="title"><a class="title"
						href="">${dto.admin_id}</a></td>
					<td>${dto.title}</td>
					<td>${dto.content}</td>
					<td>${dto.regdate}</td>
					
				</tr>
			</tbody>
		</c:forEach>
	</table>
</div>


</body>
</html>