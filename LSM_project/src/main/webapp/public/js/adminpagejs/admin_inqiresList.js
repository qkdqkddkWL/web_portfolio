window.addEventListener("load",function(){
	var answerList= document.querySelector("#answerList");
	
	answerList.onclick=function(event){
		var item = event.target;
        var tr = item.parentElement; // 클릭한 요소가 포함된 <tr> 요소
		
		var id= tr.querySelector(".id").innerText;  
		var question=tr.querySelector(".question").innerText;
		var user_id=tr.querySelector(".user-id").innerText;
		
		
		window.open("/board/adminpage/admin_answer?id="+id+"&question="+question+"&user_id="+user_id, "answer", "width=500,height=500");
	}
	
	
});