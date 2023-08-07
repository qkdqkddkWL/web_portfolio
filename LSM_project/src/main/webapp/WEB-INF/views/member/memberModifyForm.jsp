<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<body id="f">

	<div id="mem-container">
	<form id="frm" action="/member/memberWrite" method="post">
	
		<div id="id-container">
		
		<div class="id-box">
			<h3><label>아이디</label></h3>
			<input type="text" class="id1" id="id" name="id" maxlength="20" value="${dto.id}" disabled="disabled" >
			
		</div>

		<div class="ps-box">
			<h3><label>비밀번호</label></h3> 
			<input type="text" class="password" id="password" name="password" >
			<span class="msg" id="msg2">필수정보입니다</span>
		</div>
		
		<div class="ps-box-check">
			<h3><label>비밀번호 재확인</label></h3> 
			<input type="text" class="password-check" id="password-check" name="password2" >
			<span class="msg" id="msg3">필수정보입니다</span>
		</div>
		
		
		<div class="name-box">
			<h3><label>이름</label></h3>
			<input type="text" id="name" name="name" value="${dto.name}">
			
		</div>
		
		<div class="birthday-box">
			<h3><label>생년월일</label></h3>
			<input type="text" class="birthday" id="year" name="year" placeholder="년" maxlength="4">
			<select class="birthday" id="month" name="month" >
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
			<input type="text" id="email" name="email" value="${dto.email}">
		</div>
		
		<div class="submit">
			<input id="submit-button" type="button" value="수정하기" style="margin-top:50px; display:block; width: 100%; height: 35px; background-color: #dcdcdc;">
		</div>
		</div>
	</form>
	</div>
