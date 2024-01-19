<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서별 대출현황</title>
</head>
<body>
	<div class="container">
		<h3 style="text-align:center;">도서별 대여매출현황</h3>
		<table class="table">
			<thead>
				<tr>
					<th>도서번호</th>
					<th>도서명</th>
					<th>대여총계</th>
					<th>대여횟수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${bookrentList }" var="rent">
					<tr>
						<td style="text-align:center;">${rent.bookno}</td>
						<td>${rent.bookname}</td>
						<td>${rent.sum}</td>
						<td>${rent.count}</td>
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