<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload=function(){
	if(${result> 0}){
		alert("글이 수정되었습니다");
		location.href="/index";
	}	
	else{
		alert("수정에 실패 했습니다.");
		window.history.back();
	}
}
</script>
</head>
<body>

</body>
</html>