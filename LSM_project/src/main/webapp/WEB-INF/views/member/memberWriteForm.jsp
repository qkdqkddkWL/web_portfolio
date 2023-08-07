<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

</head>


<body id="f">
<header class="member_header" style="margin-top: 50px;">

	<div id="main-title" class="menubar" style="margin: auto; text-align: left; width: 600px;">
		<a href="/index"  ><img src="/images/movie.png" style="padding-right: 20px; vertical-align: middle;" ></a> 
		<span style="font-size: 26px; color: #111; line-height: 28px; font-weight: 800;">
			회원가입</span>
	</div>
	<hr style="width: 600px; margin: auto;">
</header>
	



	<div id="container">
	<form id="frm" action="/member/memberWrite" method="post">
	
		<div id="id-container">
		
		<div class="id-box">
			<h3><label>아이디</label></h3>
			<input type="text" class="id1" id="id" name="id" maxlength="14"><br>
			<span class="msg" id="id-msg">필수정보입니다</span>
		</div>

		<div class="ps-box">
			<h3><label>비밀번호</label></h3> 
			<input type="password" class="password" id="password" name="password">
			<span class="msg" id="pwd-msg">필수정보입니다</span>
		</div>
		
		<div class="ps-box-check">
			<h3><label>비밀번호 재확인</label></h3> 
			<input type="password" class="password-check" id="password-check" name="password2" placeholder="비밀번호와 동일하게 입력해주세요">
			<span class="msg" id="pwdCheck-msg">필수정보입니다</span>
		</div>
		
		
		<div class="name-box">
			<h3><label>이름</label></h3>
			<input type="text" id="name" name="name">
			<span class="msg" id="name-msg">필수정보입니다</span>
		</div>
		
		<div class="birthday-box">
			<h3><label>생년월일</label></h3>
			<input type="text" class="birthday" id="year" name="year" placeholder="년" maxlength="4">
			<select class="birthday" id="month" name="month">
				<option>월</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
			</select>
			<input class="birthday" type="text" id="day" name="day" placeholder="일" maxlength="2">
		</div>
		
		
		<div class="email-box" >
			<h3><label>이메일</label></h3>
			<input type="text" id="email" name="email">
			<select name="email2">
				<option value="@naver.com">@naver.com</option>
				<option value="@gmail.com">@gmail.com</option>
				<option value="@nate.com">@nate.com</option>
			</select>
			<span class="msg" id="email-msg">필수정보입니다</span>
		</div>
		
		<div class="submit">
			<input id="submit-button" type="button" value="가입하기" style="margin-top:50px; display:block; width: 100%; height: 35px; background-color: green;">
		</div>
		</div>
	</form>
	</div>
</body>
</html>