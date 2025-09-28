<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/course/update/${course.courseId}" method="post">
		<input type="text" name="courseName" value="${course.courseName}" placeholder="courseName"/><br/>
		<input type="text" name="price" value="${course.price}" placeholder="price"/><br/>
		<input type="text" name="catId" value="${course.category.catId}" placeholder="catId"/><br/>
	
		<br/>
		
		<button type="submit">수정</button>
	</form>
	
	<br/>
	
	<a href="/course">강좌 관리 메인으로</a>
</body>
</html>