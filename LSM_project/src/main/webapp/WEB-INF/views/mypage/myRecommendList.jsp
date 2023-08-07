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

	<div id="recommnd-container">
		<div style="position:absolute;  bottom:830px; left:400px; font-size: 25px;">
			글 목록(${total})
		</div>
			
		<table id="recommendList">
			<thead>
				<tr>
					<th>제목</th>
					<th>장르</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dto" items="${list}">
				<tr>
					<td style="font-weight: 700;"><a href="/board/boardView?seq=${dto.id}">${dto.title}</a></td>
					<td>${dto.genre}</td>
					<td>${dto.member_id}</td>
					<td>${dto.regdate}</td>
					<td>${dto.hit}</td>
					
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>