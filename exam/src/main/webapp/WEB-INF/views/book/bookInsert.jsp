<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container">
	<h1>도서등록</h1>
	<form name="insertForm" action="bookInsert" method="post">
		<table class="table">
			<tr>
				<th>도서번호</th>
				<td></td>
			</tr>
			<tr>
				<th>도서명</th>
				<td><input type="text" name="bookname"></td>
			</tr>
			<tr>
				<th>도서표지</th>
				<td><input type="text" name="bookcoverimg"></td>
			</tr>
			<tr>
				<th>출판일자</th>
				<td><input type="text" name="bookdate"></td>
			</tr>
			<tr>
				<th>금액</th>
				<td><input type="text" name="bookprice"></td>
			</tr>
			<tr>
				<th>출판사</th>
				<td><input type="text" name="bookpublisher"></td>
			</tr>
			<tr>
				<th>도서소개</th>
				<td><textarea name="bookinfo"></textarea></td>
			</tr>

		</table>
		<button type="submit">등록</button>
		<button type="button" onclick="location.href=bookList">조회</button>
	</form>
	<script>
		document.querySelector('form[name="insertForm"]').addEventListener(
				'submit', bookInsertJs);

		function bookInsertJs(event) {
			event.preventDefault();

			let name = document.getElementsByName('bookname')[0];

			if (name.value == '') {
				alert('도서명을 입력되지 않았습니다!!!!!!');
				name.focus();
				return;
			}

			insertForm.submit();

		}
	</script>


</div>