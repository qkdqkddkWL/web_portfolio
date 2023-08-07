

window.onload=function(){
	
	var replyForm= document.querySelector("#reply-form");
	var replyList= document.querySelectorAll(".re_reply");
	var replyModifyList= document.querySelectorAll(".reply_modify");
	
	replyForm.onclick=function(e){
		
		
			if(e.target.className == "reply-button"){
				var index = $(e.target.parentElement.parentElement).index();
				
				if(replyList[index-1].style.display == "") replyList[index-1].style.display="none";
				else	 replyList[index-1].style.display="";				
				
				var submitBt=replyList[index-1].querySelector('#re_reply_submit');
				
				submitBt.onclick=function(){
					var content=replyList[index-1].querySelector("#replyContent").value;
					
					if(isNull){
						alert("로그인 먼저 해주세요");
						location.href="/member/loginForm";
						return false;
					}
					else{
						if(content == null || content =="") {
							
							alert("답글을 입력하세요");
							
							return false;
						}		
					}

					
					
					}
					
				
				
				
				
			}
			if(e.target.className == "modify-button"){
				var index = $(e.target.parentElement.parentElement).index();
				
				if(replyModifyList[index-1].style.display == "") replyModifyList[index-1].style.display="none";
				else	 replyModifyList[index-1].style.display="";
				
			}
			
		
		
		
	

	}

	var replySubmit= document.querySelector("#reply_submit");
	
	replySubmit.onclick=function(){
		var replyfrm= document.replyFrm;
		
		if(isNull){
			alert("로그인 먼저 해주세요");
			location.href="/member/loginForm";
			return false;
		}
		else{
			if( replyfrm.content.value == null || replyfrm.content.value == "") {
				alert("댓글을 입력하세요");
				replyfrm.content.focus();
				return false;
			} else{
				
				replyfrm.submit();
			}
			
		}

	}
	

	//	
	var goodBt=document.querySelector("#good-button");
	var count= document.querySelector("#recommend-count");
	
	if(state == true){
		goodBt.src="/images/good2.png";
	}
	else{
		goodBt.src="/images/good.png";
	}
	
	goodBt.onclick=function(){
		var img=goodBt.src.split('/').reverse()[0];
		var state;
		if(isNull) {
			alert("로그인 먼저 해주세요")
			location.href="/member/loginForm";
		}
		 
		else{
			
		
		if(img == "good.png")
			{
				goodBt.src="/images/good2.png";
				$.ajax({
					url:"/board/insertRecommend",
					type:'post',
					data:{
						  "seq" : seq, 
						  "id" : id
					},
					dataType:"text",
					success:function(data){

						
							count.innerHTML=data;

					},
					error:function(){
						alert("error")
					}
					
				});	

			}
		else {
			goodBt.src="/images/good.png";
			$.ajax({
				url:"/board/deleteRecommend",
				type:'post',
				data:{
					  "seq" : seq, 
					  "id" : id
				},
				dataType:"text",
				success:function(data){
					count.innerHTML=data;
					
				},
				error:function(){
					alert("error")
				}
				
			});	
		}
		
		

		
		
		}
		
	}
}
$(document).ready(function() {
	const slide = new Swiper('.swiper-container', {
	  // 다양한 옵션 설정
	  
	    slidesPerView : 1, // 동시에 보여줄 슬라이드 갯수
		slidesPerGroup : 1, // 그룹으로 묶을 수, slidesPerView 와 같은 값을 지정하는게 좋음
	  
		 //그룹수가 맞지 않을 경우 빈칸으로 메우기
		//3개가 나와야 되는데 1개만 있다면 2개는 빈칸으로 채워서 3개를 만듬
		loopFillGroupWithBlank : false,

		loop : true, // 무한 반복
	    pagination: { // 호출(pager) 여부
	        el: ".swiper-pagination", //버튼을 담을 태그 설정
	        clickable: true, // 버튼 클릭 여부
	      },

		navigation : { // 네비게이션
			nextEl : '.swiper-button-next', // 다음 버튼 클래스명
			prevEl : '.swiper-button-prev', // 이번 버튼 클래스명
		},
		slideToClickedSlide : true, // 해당 슬라이드 클릭시 슬라이드 위치로 이동

		});

		
		
	});
