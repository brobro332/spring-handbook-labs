<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/student/update/${student.studentId}" method="post">
		<input type="text" name="name" value={student.name} placeholder="name"/><br/>
		<input type="text" name="email" value={student.email} placeholder="email"/><br/>
	
		<br/>
		
		<button type="submit">수정</button>
	</form>
	
	<br/>
	
	<a href="/enrollment">등록 관리 메인으로</a>
</body>
</html>