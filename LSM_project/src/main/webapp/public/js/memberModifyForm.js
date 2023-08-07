
	window.addEventListener("load",function(){
		 var idContainer = document.querySelector("#id-container");
		 var msg= document.querySelector("#msg");
		 var msg2= document.querySelector("#msg2");
		 var msg3= document.querySelector("#msg3");
		var body= document.querySelector("body");
		 
		 f.onclick=function(event){

			 
			 var pwd= idContainer.querySelector("#password");
			 
			 if(event.target.className != pwd.className){
				 if( pwd.value != null && pwd.value != '' ) {
					 msg2.innerText="사용가능한 비밀번호입니다!";
					 msg2.style.color="blue";
				 }
				 else{
					 msg2.innerText="필수정보입니다";
					 msg2.style.color="red";
				 }	 		 
			 }
			 
			 var pwdCheck= idContainer.querySelector("#password-check");
			 
			 if(event.target.className != pwdCheck.className){
				 if( pwdCheck.value != null && pwdCheck.value != '' ) {
					 if(pwdCheck.value == pwd.value) {
						 msg3.innerText="비밀번호가 일치합니다!";
					 	 msg3.style.color="blue";
					 }
					 else{
						 msg3.innerText="비밀번호가 일치하지 않습니다";
						 msg3.style.color="red";
					 }
				 }
				 else{
					 msg3.innerText="필수정보입니다";
					 msg3.style.color="red";
				 }	 		 
			 }
		 }
		 
		 var submit2= document.querySelector("#submit-button");
		 
		 submit2.onclick=function(){
			
			 var frm= document.querySelector("#frm");
			 
			 if(!frm.id.value) {
				 frm.id.focus();
			 }
			 else if(!frm.password.value){
				 frm.password.focus();
			 }
			 else if(!frm.password2.value || frm.password2.value != frm.password.value){
				 frm.password2.focus();
			 }
			 else{
				 frm.submit();
			 }
			 
		 }
		 
		
	});
