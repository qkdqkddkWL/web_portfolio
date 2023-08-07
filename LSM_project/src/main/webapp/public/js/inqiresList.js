
window.addEventListener("load",function(){

	var answerList= document.querySelector("#answerList");
	var answer= document.querySelectorAll(".answer");
	
	answerList.onclick=function(event){
		
		var item=event.target;	
		
		
		 while (item.parentElement.className != "title-tr") {
			    item = item.parentElement;
			   
			    if (item === null) return;
			  }

			  
			  const answerRow = item.parentElement.nextElementSibling;
			  answerRow.classList.toggle("answer");

		
	}


	
	});