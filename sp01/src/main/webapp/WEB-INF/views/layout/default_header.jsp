<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<ul class="nav">
	<li class="nav-item"><a class="nav-link active"
		aria-current="page" href="${pageContext.request.contextPath }/">home</a>
	</li>
	<li class="nav-item"><a class="nav-link"
		href="${pageContext.request.contextPath }/empList">전체 사원 조회</a> <!-- @GetMapping("empList") -->
	</li>
	<li class="nav-item"><a class="nav-link"
		href="${pageContext.request.contextPath }/empInsert">사원 정보 등록 </a></li>
	<li class="nav-item"><a class="nav-link"
		href="${pageContext.request.contextPath }/boardList">게시판 전체 조회</a></li>
	<li class="nav-item"><a class="nav-link"
		href="${pageContext.request.contextPath }/boardInsert">게시판 정보 등록</a></li>

</ul>