<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title> 
<script type="text/javascript">

var result="${result}";
</script>
</head>


<body>
<div class="login-container">
<div class="login-box">

		<h2 class="title">로그인</h2>

			<form action="/member/login" method="post" name=frm>
				<div>
					<input id="id" type="text" name="id" placeholder="아이디를 입력하세요">
				</div>

				<div>
					<input id="pwd" type="password" name="pwd"
						placeholder="비밀번호를 입력하세요">
				</div>
			
				<div id="login-Message"></div>

				<button type="button" id="login-button">
					<span>로그인</span>
				</button>


				<div class="WriteForm">
					<a href="/member/memberWriteForm">회원가입</a> <a href="/member/findPasswordForm">비밀번호 찾기</a>
				</div>

				<hr>
			</form>
		</div>
</div>
</body>
</html>