<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/course/delete/${course.courseId}" method="post">
		<input type="text" name="courseId" value="${course.courseId}" placeholder="courseId" readonly/><br/>
	
		<br/>
		
		<button type="submit">삭제</button>
	</form>
	
	<br/>
	
	<a href="/course">강좌 관리 메인으로</a>
</body>
</html>