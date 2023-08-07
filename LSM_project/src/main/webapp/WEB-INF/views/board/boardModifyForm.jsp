<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<div id="container">
		<div id="input-container">
			<form method="post" action="/board/boardModify?seq=${param.seq}"
				enctype="multipart/form-data">

				<div>
					<img id="preview-img" alt="#" src="/images/file2.png">
				</div>

				<div id="img-list">
				
				
					<div class="file-form">
						<input class="file-input" name="imgs" type="file" accept="image/png, image/jpg">
						<span class="file-button"><img class="imgs"
							src="/images/add_button.png"></span>
					</div>
					
					<div class="file-form">
						<input  class="file-input" name="imgs" type="file" accept="image/png, image/jpg">
						<span  class="file-button"><img class="imgs"
							src="/images/add_button.png"></span>
					</div>
					
					<div class="file-form">
						<input class="file-input" name="imgs" type="file" accept="image/png, image/jpg">
						<span class="file-button"><img class="imgs"
							src="/images/add_button.png"></span>
					</div>
					
					
				</div>



				<div id="title-form">
					<input type="text" name="title" placeholder="제목을 입력해주세요" value="${dto.title}">
				</div>
									

				<div id="gerne-form">
					<label>장르</label>
					<select name="genre">
						<option>액션</option>
						<option>sf/판타지</option>
						<option>로맨스</option>
						<option>스릴러/미스터리</option>
					</select>
				</div>
				
				<div id="rating-form">
					<label>평점</label>
					<select name="rating">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
						<option>6</option>
						<option>7</option>
						<option>8</option>
						<option>9</option>
						<option>10</option>
					</select>
				</div>


				<div id="content-form">
					<textarea name="content">${dto.content}</textarea>
				</div>


				<div>
					<button id="submit">
						<span id="submit-button">수정</span>
					</button>
				</div>
			</form>
		</div>
	</div>
	<hr>
