
	window.addEventListener("load", function() {
		var fileButton = document.querySelectorAll(".file-button");
		var file = document.querySelectorAll(".file-input");
		
		
		var imgs = document.querySelectorAll(".imgs");
		var previewImg = document.querySelector("#preview-img");
		var fileAppend = document.querySelector(".file-append");
		var imgList=document.querySelector("#img-list");

		//////////

		
		imgList.onclick= function(e){
			if(e.target.className =='imgs'){
				var position = $(e.target.parentElement.parentElement).index();
				
				var event = new MouseEvent("click", {
					'view' : window,
					'bubbles' : true,
					'cancelable' : true
				});
				file[position].dispatchEvent(event);
				
				file[position].addEventListener("change", function() {
					var reader = new FileReader();
					reader.onload = function(event) {

						imgs[position].src = event.target.result;
						previewImg.src = event.target.result;
					}
					if (event.target.files[0]) {
						// reader가 이미지 읽도록 하기
						reader.readAsDataURL(event.target.files[0]);
					}

				})		
			}


		}


	});
