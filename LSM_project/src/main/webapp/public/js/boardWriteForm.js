
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

		/* 
		fileButton[0].onclick = function() {
				var event = new MouseEvent("click", {
					'view' : window,
					'bubbles' : true,
					'cancelable' : true
				});
				file[0].dispatchEvent(event);
			}

			file[0].addEventListener("change", function() {
				var reader = new FileReader();
				reader.onload = function(event) {

					imgs[0].src = event.target.result;
					previewImg.src = event.target.result;
				}
				if (event.target.files[0]) {
					// reader가 이미지 읽도록 하기
					reader.readAsDataURL(event.target.files[0]);
				}

			})

			

			fileButton[1].onclick = function() {
				var event = new MouseEvent("click", {
					'view' : window,
					'bubbles' : true,
					'cancelable' : true
				});
				file[1].dispatchEvent(event);
			}

			file[1].addEventListener("change", function() {
				var reader = new FileReader();
				reader.onload = function(event) {

					imgs[1].src = event.target.result;
					previewImg.src = event.target.result;
				}
				if (event.target.files[0]) {
					// reader가 이미지 읽도록 하기
					reader.readAsDataURL(event.target.files[0]);
				}

			})
			
			
					fileButton[2].onclick = function() {
				var event = new MouseEvent("click", {
					'view' : window,
					'bubbles' : true,
					'cancelable' : true
				});
				file[2].dispatchEvent(event);
			}

			file[2].addEventListener("change", function() {
				var reader = new FileReader();
				reader.onload = function(event) {

					imgs[2].src = event.target.result;
					previewImg.src = event.target.result;
				}
				if (event.target.files[0]) {
					// reader가 이미지 읽도록 하기
					reader.readAsDataURL(event.target.files[0]);
				}

			})
			 */

	});
