window.addEventListener("load",function(){
	var pwd=document.querySelector("#pwd");
	var pwdCheck=document.querySelector("#pwd-check");
	var pwdMsg=document.querySelector("#pwd-msg");
	var pwdCheckMsg=document.querySelector("#pwdCheck-msg");
	var pwdFlag=0;
	var pwdCheckFlag=0;
	
	var submitBt= document.querySelector("#submit-button");
	pwd.addEventListener("input",function(){

		// A-Z, a-z, 0-9 특수문자가 포함되어 있는지, 8자 이상
		let reg = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[~?!@#$%^&*_-]).{8,}$/;
		
		if(reg.test(pwd.value)){
			pwdMsg.innerText="사용가능한 비밀번호 입니다";
			pwdMsg.style.color="blue";
			pwdFlag=1;
		}
		else{
			pwdMsg.innerText="영문자,숫자,특수문자를 포함하여 8자 이상 작성해주세요";
			pwdMsg.style.color="red";
			pwdFlag=0;	
		} 
	});
	
	pwdCheck.addEventListener("input",function(){
		if(pwdCheck.value != null && pwdCheck.value !=""){
			if(pwd.value == pwdCheck.value){
				pwdCheckMsg.innerText="비밀번호가 일치합니다";
				pwdCheckMsg.style.color="blue";
				pwdCheckFlag=1;
			}
			
			else {
				pwdCheckMsg.innerText="비밀번호가 일치하지 않습니다";
				pwdCheckMsg.style.color="red";
				pwdCheckFlag=0;
			}
		}
		else{
			pwdCheckMsg.innerText="비밀번호를 입력해주세요";
			pwdCheckMsg.style.color="red";
			pwdCheckFlag=0;
			
		}

	})
	
	
	submitBt.addEventListener("click",function(){
		if(!pwd.value || pwdFlag ==0){
			 pwd.focus();
		 }
		 else if(!pwdCheck.value || pwdCheckFlag==0){
			 pwdCheck.focus();
		 }
		 else{
			 document.frm.submit();
		 }
	});

	});