<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원정보등록</title>
</head>
<body>
	<form action="empInsert" method="post">
		<!-- action : 요청하고자 하는 경로 / method : 요청할때 전송하고자 하는 방식으로 post 는 빈 페이지기때문에 value 에 가지고 올 값이 없다. -->
		<!-- 입력도 같이하기때문에 form 태그 사용 데이터를 전송하기 위해 사용하는 태그이다.-->
		<!--  Form 태그 안에 name 은 어떤 변수가 오느냐에 따라 달라지기 때문에 기억해야한다. -->
		<div>
			<lable> last_name : <input type="text" name="lastName">
			</lable>
			<br>
			<lable> email : <input type="text" name="email"> </lable>
			<br>
			<lable> hire_date : <input type="date" name="hireDate">
			</lable>
			<br>
			<lable> job_id : <input type="text" name="jobId"> </lable>
			<br>
			<lable> salary : <input type="number" name="salary">
			</lable>
		</div>
		<div>
			<button type="button" onclick="location.href='empList'">목록으로</button>
			<button type="submit">등록</button>
		</div>
	</form>
</body>
</html>