<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 게시글 조회</title>
</head>
<body>
	<div class="container">
		<h1>자유게시판</h1>
		<table class="table">
			<thead>
				<tr>
					<th>No.</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일자</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ boardList }" var="board">
					<tr onclick="location.href='boardInfo?bno=${board.bno}'">
						<td>${ board.bno }</td>
						<td>${ board.title }</td>
						<td>${ board.writer }</td>
						<td><fmt:formatDate value="${ board.regdate }"
								pattern="yyyy년MM월dd일" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
 </body>
</html>