function setThumbnail(event){
    for (var img of event.target.files) {
        var reader = new FileReader();


        reader.onload = function (event) {
            var image = document.createElement("img");
            image.setAttribute("src", event.target.result);
            image.setAttribute("class","image_container" );
            document.querySelector(".image_container").appendChild(image);
        };
        console.log(img);
        reader.readAsDataURL(img);

    }
}

function getSearchList(){
	$.ajax({
		type: 'GET',
		url : "/getSearchList",
		data : $("form[name=search-form]").serialize(),
		success : function(result){
			//테이블 초기화
			$('#boardtable > tbody').empty();
			if(result.length>=1){
				result.forEach(function(item){
					str='<tr>'
					str += "<td>"+item.idx+"</td>";
					str+="<td>"+item.writer+"</td>";
					str+="<td><a href = '/board/detail?idx=" + item.idx + "'>" + item.title + "</a></td>";
					str+="<td>"+item.date+"</td>";
					str+="<td>"+item.hit+"</td>";
					str+="</tr>"
					$('#boardtable').append(str);
        		})				 
			}
		}
	})
}