<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<h1>게시글 조회</h1>
	<table>
		<tr>
			<th>게시글번호</th> <!-- info컨트롤러에서 담은 변수명으로 데이터를 불러온다. -->
			<td>${ boardInfo.bno }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${ boardInfo.title }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${ boardInfo.writer }</td>
		</tr>
		<tr>
			<th>작성일자</th>
			<td>${ boardInfo.regdate }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="3" cols="2" style="width:100px;" readonly>${ boardInfo.contents }</textarea></td>
		</tr>
		<tr>
			<th>이미지</th>
			<td><img src="<c:url value="/resources/${boardInfo.image }"/>"></td>
		</tr>
	</table>
	<button type="button">수정</button>
	<button type="button">삭제</button>
</div>
