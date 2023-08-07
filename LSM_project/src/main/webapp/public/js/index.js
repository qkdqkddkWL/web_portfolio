$(document).ready(function() {
const slide = new Swiper('.swiper-container', {
  // 다양한 옵션 설정
  
    slidesPerView : 4, // 동시에 보여줄 슬라이드 갯수
	spaceBetween : 30, // 슬라이드간 간격
	slidesPerGroup : 4, // 그룹으로 묶을 수, slidesPerView 와 같은 값을 지정하는게 좋음
  
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

const slide2 = new Swiper('.swiper-container2', {
	  // 다양한 옵션 설정
	  
	    slidesPerView : 4, // 동시에 보여줄 슬라이드 갯수
		spaceBetween : 30, // 슬라이드간 간격
		slidesPerGroup : 4, // 그룹으로 묶을 수, slidesPerView 와 같은 값을 지정하는게 좋음
	  
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
window.addEventListener("load",function(){
	var searchBox=document.querySelector("#search-box");
	var title=searchBox.querySelector("#title");
	//var frm=document.getElementsByName("frm")
	
	
	var frm=document.querySelector("#frm");
	title.addEventListener("keyup",function(event){
		if(event.keyCode== 13){
			frm.submit();
		}
	})
	
});