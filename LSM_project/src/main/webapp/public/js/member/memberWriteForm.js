
	window.onload=function(){
	
	var body= document.querySelector("#f");
	 var idContainer = document.querySelector("#id-container");
	 var idMsg= document.querySelector("#id-msg");
	 var pwdMsg= document.querySelector("#pwd-msg");
	 var pwdCheckMsg= document.querySelector("#pwdCheck-msg");
	 var nameMsg=idContainer.querySelector("#name-msg");
	var emailMsg=idContainer.querySelector("#email-msg");
	
	var name= idContainer.querySelector("#name");
	var id=idContainer.querySelector("#id");
	var pwd=idContainer.querySelector("#password");
	var pwdCheck=idContainer.querySelector("#password-check");
	var email=idContainer.querySelector("#email");

	var idFlag;
	var pwdFlag;

	//유효성 검사
	id.addEventListener("input",function(){
		let idReg = /^[a-z]+[a-z0-9]{4,19}$/g;
		
		if(idReg.test(id.value)){

			idMsg.innerText="사용가능한 아이디입니다!";
			idMsg.style.color="blue";
			idFlag=1;

		}
		else{		

			idMsg.innerText="5- 15글자 사이의 영문.숫자를 입력해주세요!";
			idMsg.style.color="red";
			idFlag=0;
		}
		$.ajax({
			url:"/member/checkId",
			type:'post',
			data:{"id" : id.value},
			dataType:"json",
			success:function(data){
				if(data.result == 1) {
					
					idMsg.innerText="중복 아이디입니다!";
					idMsg.style.color="red";
					idFlag=0;
				}
			},
			error:function(){
				alert("error")
			}
			
		});	
	})
	
	id.addEventListener("focusout",function(){
		if(!id.value){
			idMsg.innerText="필수정보입니다";
			idMsg.style.color="red";
		}
	});
	
	
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

	
	pwd.addEventListener("focusout",function(){
		if(!pwd.value){
			pwdMsg.innerText="필수정보입니다";
		}

	})
	
	email.addEventListener("input",function(){
		
		
		let emailReg =  /^[a-zA-Z0-9]{8,}$/;
		
		if(emailReg.test(email.value)){
			emailMsg.innerText="적절한 이메일입니다";
			emailMsg.style.color="blue";
		}else{
			emailMsg.innerText="다시 입력해주세요";
			emailMsg.style.color="red";
		}
		
	});
	
	
	
	
	
	pwdCheck.addEventListener("focusout",function(){
		if(pwdCheck.value != null && pwdCheck.value !=""){
			if(pwd.value == pwdCheck.value){
				
				pwdCheckMsg.innerText="비밀번호가 일치합니다";
				pwdCheckMsg.style.color="blue"; 
			}
				
			else {
				pwdCheckMsg.innerText="비밀번호가 일치하지 않습니다";
				pwdCheckMsg.style.color="red"; 
			}
		}else {
			pwdCheckMsg.innerText="필수정보입니다";
			pwdCheckMsg.style.color="red"; 
		}
		
	})
	
		
	name.addEventListener("focusout",function(){
		if(!name.value){
			nameMsg.innerText="필수정보입니다";
		}
		else {
			nameMsg.innerText="";
		}
	})
	 
	 var submitBt= document.querySelector("#submit-button");
	 
	 submitBt.onclick=function(){
		
		 var frm= document.querySelector("#frm");
		 
		 if(!frm.id.value || idFlag == 0) {
			 frm.id.value="";
			 frm.id.focus();
		 }
		 else if(!frm.password.value || pwdFlag ==0){
			 frm.password.value="";
			 frm.password.focus();

		 }
		 else if(!frm.password2.value ||  (frm.password2.value != frm.password.value)){
			 frm.password2.focus();
		 }
		 else if(!frm.name.value){
			 frm.name.focus();
		 }
		 else if(!frm.email.value){
			 frm.email.focus();
		 }
		 else{
			 frm.submit();
		 }
		 
	 }
	 
	 
	}
