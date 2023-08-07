window.addEventListener("load",function(){
	
	var table=document.querySelector("#myreview-container table")
	var tbody= table.querySelector("#content");
	var checkAll = table.querySelector(".check-all");
	var deleteButton = document.querySelector("#deleteButton");
	
	var checkbox=table.querySelectorAll(".check");	//tr태그 내의 checkbox들
	var selectedRows = [];
	
	checkAll.onclick=function(){
		
		for(let i=0; i<checkbox.length; i++){
			if(checkbox[i].checked){
				 const row = checkboxes[i].parentNode.parentNode; //  tr 태그 선택
			     const rowValues = row.querySelectorAll('td'); // tr 태그의 자식인 td 태그들 선택				
			} 
		}	
	}
	
	
	
	
	
	
})