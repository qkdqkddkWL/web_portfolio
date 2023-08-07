window.addEventListener("load",function(){
	var id=document.querySelector("#input-Id");
	var idButton= document.querySelector(".id-button");
	
	var email=document.querySelector("#input-email");
	var emailButton=document.querySelector(".email-button");
	
	
	var nextButton= document.querySelector("#next-button");
	var auth= document.querySelector("#auth-code");


	var idstate=0;
	var emailstate=0;
	var authcode;
	
	idButton.onclick=function(){
		if(!id.value){
			alert("아이디를 입력해주세요");
			id.focus();
		}
		
		else{

		$.ajax({
			
			type:"get",
			url:"/member/findPassword",
			cache:"false",
			data:{'id' : id.value},
			dataType:"json",
			success:function(data){
				if(data ==0){
					alert("입력하신 아이디가 존재하지 않습니다");
					id.value="";
					
					id.focus();
				}
				else{
					alert("확인되었습니다");
					idstate=1;
					id.disabled=true;
					email.focus();
				}
			},
			error:function(){
				alert("에러");
			}
		})			
		}
	}	
	
	emailButton.onclick=function(){
		
		if(!id.value || idstate ==0 ){
			alert("아이디를 확인해주세요");
			id.focus();
		}else if(!email.value){
			alert("이메일을 입력해주세요");
			id.focus();
		}
		
		else{

		$.ajax({
			
			type:"get",
			url:"/email/emailCode",
			cache:"false",
			data:{'email' : email.value},
			dataType:"json",
			
			success:function(data){
				if(data){
					authcode=data;
					alert("인증번호가 발송되었습니다"+ " "+data);
					emailstate=1;
				
					
				}
				else{
					alert("");
					
				}
			},
			error:function(){
				alert("에러");
			 }
		})			
		}
	}
	
	nextButton.onclick=function(){
		if(emailstate ==1 && idstate == 1){
			if(auth.value == authcode){
				alert("인증번호가 일치합니다");
				location.href="/member/passwordModifyForm?id="+id.value;
			}
			else{
				alert("인증번호가 틀렸습니다");
				auth.focus();
			}
		}
		else{
			alert("아이디와 이메일을 확인하세요");
		}
		
		
		
		
	}
	
});