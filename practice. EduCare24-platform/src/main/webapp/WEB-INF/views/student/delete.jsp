<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/student/delete/${student.studentId}" method="post">
		<input type="text" name="studentId" value="${student.studentId}" placeholder="studentId" readonly/><br/>
	
		<br/>
		
		<button type="submit">삭제</button>
	</form>
	
	<br/>
	
	<a href="/student">학생 관리 메인으로</a>
</body>
</html>