window.onload=function(){
	var frm= document.frm;
	var loginMessage = document.querySelector("#login-Message");
	var loginButton= document.querySelector("#login-button");
		
	
	
	if(result == 1 ){
		loginMessage.innerText="아이디 또는 비밀번호가\n잘못되었습니다";
		
	}else{
		loginMessage.innerText="";
	}
	
	
	loginButton.onclick=function(){
		
		
		if(!id.value) {
			loginMessage.innerText="아이디를 입력하세요";
			id.focus();
		}
		else if(!pwd.value){
			loginMessage.innerText="비밀번호를 입력하세요";
			pwd.focus();	
		}else{
			frm.submit();
		}	
	}	
};