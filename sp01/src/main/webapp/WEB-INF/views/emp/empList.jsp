<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!-- 데이터 가져올 때 import / prefix 는 html 기반으로 java 가 해석해야한다는 의미 /  uri : 자동등록이나 잘못 불러오면 오류가남-->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <!-- 날짜포맷 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 사원 조회</title>
</head>
<body>
	<button></button>
	<table>
		<thead>
			<tr>
				<th>No.</th>
				<th>employee_id</th>
				<th>last_name</th>
				<th>email</th>
				<th>hire_Date</th>
				<th>job_id</th>
				<th>salary</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ empList }" var="info" varStatus="sts"> 
			<!-- var : 임시변수로 내부에서만 사용하기 때문에 el태그 필요없음 -->
			<!--  info는 empList 배열에서 empVO 객체를 담았기 때문에 info.으로 작성해주면 된다 -->
				<tr onclick="location.href='empInfo?employeeId=${info.employeeId}'"> <!-- empInfo와 연결 -->
					<td>${ sts.count }</td> <!-- index : 0부터 시작, count : 1부터 시작 -->
					<td>${ info.employeeId }</td> <!-- controller가 넘겨준 addattribute 값 -->
					<td>${ info.lastName }</td>
					<td>${ info.email }</td>
					<td>
						<fmt:formatDate value="${ info.hireDate }" pattern="yyyy년MM월dd일"/>
					</td>
					<td>${ info.jobId }</td>
					<td>${ info.salary }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>