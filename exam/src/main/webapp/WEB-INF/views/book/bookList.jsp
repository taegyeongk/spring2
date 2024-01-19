<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 목록조회</title>
</head>
<body>
	<div class="container">
		<h3 style="text-align:center;">도서조회/수정</h3>
		<table class="table">
			<thead>
				<tr>
					<th>도서번호</th>
					<th>도서명</th>
					<th>표지</th>
					<th>출판일자</th>
					<th>금액</th>
					<th>출판사</th>
					<th>도서소개</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ bookList }" var="book">
					<tr>
						<td>${book.bookno}</td>
						<td>${book.bookname}</td>
						<td><img style="width:50px;" src="<c:url value="/resources/images/${book.bookcoverimg}"/>"></td>
						<td><fmt:formatDate value="${ book.bookdate }"
								pattern="yyyy년MM월dd일" /></td>
						<td><fmt:formatNumber value="${book.bookprice}" pattern="#,###"/></td>
						<td>${book.bookpublisher}</td>
						<td>${book.bookinfo}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>

<style>
table {
    width: 100%;
    border: 1px solid #444444;
  }
th, td {
    border: 1px solid #444444;
  }
</style>
</html>