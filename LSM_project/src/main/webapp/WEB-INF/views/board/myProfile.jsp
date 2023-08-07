<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#profile-container{
    width: 320px;
    margin: 0 auto;
    position: absolute;
    top: 150px;
    left: 780px;
    
    
}
</style>
</head>
<body>
<div id="profile-container">
  <h1>회원 정보</h1>
  <p>이름: [${dto.name}]</p>
  <p>나이: [${dto.birthday}]</p>
  <p>이메일: [${dto.email}]</p>
  
</div>



</body>
</html>