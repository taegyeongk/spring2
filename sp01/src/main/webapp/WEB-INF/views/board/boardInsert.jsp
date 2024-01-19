<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container">
	<h1>게시글 등록</h1>
	<form name="insertForm" action="boardInsert" method="post">
	<!--  not null 제약조건을 생각하고 해야한다. -->
		<table class="table">
			<tr>
				<th>제목</th>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="contents"></textarea></td>
			</tr>
			<tr>
				<th>이미지</th><!-- app.jpg -->
				<td><input type="text" name="image"></td>
			</tr>
		</table>
		<button type="submit">등록</button>
	</form>
	<script>
		//자바스크립트
		document.querySelector('form[name="insertForm"]').removeEventListener('submit', boardInsertJs);

		function boardInsertJs(event){
			event.preventDefault();

			let title = document.getElementsByName('title')[0];
			let writer = document.getElementsByName('writer')[0];

			if(title.value == ''){ //value 속성은 값을 넣지 않을 경우 기본적으로 공백
				alert('제목이 입력되지 않았습니다.');
				title.focus();
				return; //종료하고자 하는것은 함수가 아닌 if 문
			}

			if(writer.value == ''){
				alert('작성자가 입력되지 않았습니다.');
				writer.focus();
				return;
			}

			insertForm.submit();

		}
//jQuery
$('form[name="insertForm"]').on('submit', boardInsertJq);
	function boardInsertJq(event){
		event.preventDefault();

		let title = $('[name="title"]');
		let writer = $('[name="writer"]');
		if(title.val() == ''){
			alert("제목을 확인해주세요.");
			title.focus();
			return;
		}if(writer.val() == ''){
			alert("작성자를 확인해주세요.");
			writer.focus();
			return;
		}
		
		insertForm.submit();
		
	}

	</script>


</div>