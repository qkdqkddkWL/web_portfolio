function addrKindChange(e) {

	var seoul = ["선택","강남구","강동구","강북구","강서구",
				"관악구","광진구","구로구","금천구",
				"노원구","도봉구","동대문구","동작구",
				"마포구","서대문구","서초구","성동구",
				"성북구","송파구","양천구","영등포구",
				"용산구","은평구","종로구","중구","중랑구"];
	var busan = ["선택","중구","서구","동구","영도구","부산진구",
				"동래구","남구","북구","해운대구","사하구",
				"금정구","강서구","연제구","수영구","사상구","기장군"];
	var deagu = ["선택","중구","동구","서구","남구","북구","수성구","달서구","달성군"];
	
	var incheon=["선택","중구","동구","미추홀구","연수구","남동구",
				"부평구","계양구","서구","강화군","옹진군"];
	var gwangju =["선택","동구","서구","남구","북구","광산구"];
	var daejeon =["선택","동구","중구","서구","유성구","대덕구"];
	var ulsan =["선택","중구	","남구","동구","북구","울주군"];
	var sejong =["선택","세종시"];
	var gyeonggi =["선택","수원시","장안구","권선구","팔달구","영통구","성남시","수정구","중원구","분당구","의정부시","안양시","만안구","일산서구",
			"과천시","구리시","남양주시","오산시","시흥시","군포시","의왕시","하남시","용인시","처인구","기흥구","수지구","파주시","이천시",
			"안성시","김포시","화성시","광주시","양주시","포천시","여주시","연천군","가평군","양평군"];
	var gangwon =["선택","춘천시","원주시","강릉시","동해시","태백시","속초시","삼척시","홍천군","횡성군",
				"영월군","평창군","정선군","철원군","화천군","양구군","인제군","고성군","양양군"];
	var chungbuk =["선택","청주시","상당구","서원구","흥덕구","청원구","충주시","제천시","보은군","옥천군",
					"영동군","증평군","진천군","괴산군","음성군","단양군"];
	var chungnam =["선택","천안시","동남구","서북구","공주시","보령시","아산시","서산시","논산시","계룡시","당진시","금산군","부여군",
					"서천군","청양군","홍성군","예산군","태안군"];
	var jeollabuk =["선택","전주시","완산구","덕진구","군산시","익산시","정읍시","남원시","김제시","완주군","진안군","무주군","장수군","임실군","순창군","고창군","부안군"];
	var jeollanam =["선택","전체","광양시","나주시","목포시","순천시","여수시","여천시","강진군","고흥군","곡성군","구례군","담양군","무안군",
					"보성군","신안군","여천군","영광군","영암군","완도군","장성군","장흥군","진도군","함평군","해남군","화순군"];
	var Gyeongsangbuk =["선택","포항시","남구","북구","경주시","김천시","안동시","구미시","영주시","영천시","상주시","문경시","경산시","군위군",
						"의성군","청송군","영양군","영덕군","청도군","고령군","성주군","칠곡군","예천군","봉화군","울진군","울릉군"];
	var Gyeongsangnam =["선택","창원시","의창구","성산구","마산합포구","마산회원구","진해구","진주시","통영시","사천시","김해시","밀양시","거제시",
						"양산시","의령군","함안군","창녕군","고성군","남해군","하동군","산청군","함양군","거창군","합천군"];
	var jeju =["선택","제주시","서귀포시"];
	
	
	var target = document.getElementById("region2");
	var city = e.value;
	
	if (e.value == "서울") var d = seoul;
		else if (e.value == "부산") var d = busan;
		else if (e.value == "대구") var d = deagu;
		else if (e.value == "인천") var d = incheon;
		else if (e.value == "광주") var d = gwangju;
		else if (e.value == "대전") var d = daejeon;
		else if (e.value == "울산") var d = ulsan;
		else if (e.value == "세종") var d = sejong;
		else if (e.value == "경기") var d = gyeonggi;
		else if (e.value == "강원") var d = gangwon;
		else if (e.value == "충북") var d = chungbuk;
		else if (e.value == "충남") var d = chungnam;
		else if (e.value == "전북") var d = jeollabuk;
		else if (e.value == "전남") var d = jeollanam;
		else if (e.value == "경북") var d = Gyeongsangbuk;
		else if (e.value == "경남") var d = Gyeongsangnam;
		else if (e.value == "제주") var d = jeju;

		target.options.length = 0;
		for (i in d) {
			var opt = document.createElement("option");
			opt.value = d[i];
			opt.innerHTML = d[i];
			target.appendChild(opt);
		}

	}