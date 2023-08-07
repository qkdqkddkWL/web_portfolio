<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>


<body>
<header class="member_header" style="margin-top: 50px; ">

	<div id="main-title" class="menubar" style="margin: auto; text-align: left; width: 600px;">
		<a href="/index"  ><img src="/images/movie.png" style="padding-right: 20px; vertical-align: middle;" ></a> 
		<span style="font-size: 26px; color: #111; line-height: 28px; font-weight: 800;">
			비밀번호 변경</span>
	</div>
	<hr style="width: 600px; margin: auto;">
</header>




	<div id="password-container">
		<div id="pwd-form">
			<h2>새 비밀번호 작성</h2>
			<form action="/member/passwordModify?id=${param.id}" method="post" name="frm">
				<div>
					<label>새 비밀번호 입력</label> <input class="pwd-box" id="pwd"
						type="password" name="password"> <span class=msg id="pwd-msg">비밀번호를
						입력해주세요</span>
				</div>
				<div>
					<label>새 비밀번호 확인</label> <input class="pwd-box" id="pwd-check"
						type="password"> <span class=msg id="pwdCheck-msg">비밀번호를
						입력해주세요</span>
				</div>

				<div>
					<button id="submit-button"type="button">
						<span class="btn">변경하기</span>
					</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>