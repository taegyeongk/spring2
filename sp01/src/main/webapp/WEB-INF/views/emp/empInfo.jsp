<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 정보 조회 및 수정</title>
</head>
<body>
	<form action="">
		<!-- 입력도 같이하기때문에 form 태그 사용 -->
		<div>
			<lable> employee_id : <input type="number" name="employeeId"
				value="${ empInfo.employeeId }"> <!-- el태그는 하나의 속성이나 값이 될 수 있다. -->
			</lable>
			<br>
			<lable> last_name : <input type="text" name="lastName"
				value="${ empInfo.lastName }"> </lable>
			<br>
			<lable> email : <input type="text" name="email"
				value="${ empInfo.email }"> </lable>
			<br>
			<lable> hire_date : <input type="date" name="hireDate"
				value='<fmt:formatDate value="${ empInfo.hireDate }" pattern="yyyy-MM-dd"/>'>
			</lable>
			<br>
			<lable> job_id : <input type="text" name="jobId"
				value="${ empInfo.jobId }"> </lable>
			<br>
			<lable> salary : <input type="number" name="salary"
				value="${ empInfo.salary }"> </lable>
		</div>
		<div>
			<button type="button" onclick="location.href='empList'">목록으로</button>
			<button type="button" id="updateBtn">수정</button>
			<button type="button" onclick="location.href='empDelete?eid=${empInfo.employeeId}'">삭제</button>
		</div>
	</form>
	<script>
		//querySelector : 어떤 속성을 가지고 올지
		document.querySelector('#updateBtn').addEventListener('click', updateEmpInfo);
		
		function updateEmpInfo(event){
			//form 태그 내부의 입력태그를 기반으로 정보를 가져옴
			let empInfo = getEmpInfo();
			console.log(empInfo);
			//해당정보를 기반으로 ajax
			//- QueryString : key = value&key=value... / URLSearchParams 랑 QueryString 이랑 같이 사용된다.
			fetch('empUpdate',{
				method : 'post',
				body : new URLSearchParams(empInfo)
			})
			.then(response => response.json())
			.then(result =>{
				console.log('QueryString', result)
			}).catch(err => console.log(err));
		//json : {"key" : "value", "key" : "value", ...} 구조상 반드시 post
			fetch('empUpdateAjax',{
				method : 'post',
				headers : {
					'content-type' : 'application/json' //content-type 이라는걸 알려줘야한다. / application/json : 통신상의 규칙으로 절대 변경하지 않고 이대로 작성해야한다.
				},
					body : JSON.stringify(empInfo)
			})
			.then(response => response.json())
			.then(result =>{
				console.log('JSON', result)
			}).catch(err => console.log(err));
		
		
		
		
		}
		
		
		
		
		
		function getEmpInfo(){
			//form 태그 내부에 있는 input 태그를 검색함. form 과 input 사이의 공백은 하위요소를 뜻한다. 다만 통신용은 아님.
			let inputList = document.querySelectorAll('form input'); 
			
			let objData = {};
			inputList.forEach(tag =>{
				objData[tag.name] = tag.value; // ->form 태그에 name 속성을 필드명으로 지정해서 값을 불러오도록 함. 배열이 아닌 객체기 때문에 puhs는 올수없다.
			});
			
			return objData;
		}
		
		
		
		
	</script>
</body>
</html>