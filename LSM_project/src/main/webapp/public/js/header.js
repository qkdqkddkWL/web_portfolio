window.addEventListener("load", function() {
	var login= document.querySelector("#loginOk");
	var menu= document.querySelector("#menu");
	if(menu){
		menu.style.display="none";
	}
	
	
	if(login){
		login.onclick=function(e){
			
			
			if(menu.style.display == "none"){
				
				menu.style.display="block";
			}else {
				
				menu.style.display="none";
			}
		
}
	}
	
});
