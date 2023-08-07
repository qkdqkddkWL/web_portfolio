<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
if(${result == 1}){
	alert("비밀번호가 수정 되었습니다");
	location.href="/index";
}
else{
	alert("비밀번호 수정 실패");
}
</script>
</head>
<body>

</body>
</html>