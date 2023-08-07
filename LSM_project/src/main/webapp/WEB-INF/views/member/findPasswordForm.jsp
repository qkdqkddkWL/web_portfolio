<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


	<header class="member_header" style="margin-top: 50px;">

		<div id="main-title" class="menubar"
			style="margin: auto; text-align: left; width: 600px;">
			<a href="/index"><img src="/images/movie.png"
				style="padding-right: 20px; vertical-align: middle;"></a> <span
				style="font-size: 26px; color: #111; line-height: 28px; font-weight: 800;">
				비밀번호 찾기</span>
		</div>
		<hr style="width: 600px; margin: auto;">
	</header>


	<div id="findPwdForm-Container">
		<div id="findPwdForm">

			<form action="/member/findPassword" method="post">
				<div>
					<input id="input-Id" type="text" maxlength="20" placeholder="아이디">
					<button type="button" class="id-button">확인</button>
				</div>

				<div>
					<input id="input-email" type="text" placeholder="이메일">
					<button type="button" class="email-button">인증번호전송</button>
				</div>

				<div>
					<input id="auth-code" type="text" placeholder="인증번호">
				</div>



				<button type="button" id="next-button">
					<span>확인</span>
				</button>
				<input type="text" id="hidden" />
			</form>
		</div>
	</div>
