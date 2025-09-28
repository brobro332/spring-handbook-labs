<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/student" method="post">
		<input type="text" name="name" placeholder="name"/><br/>
		<input type="text" name="email" placeholder="email"/><br/>
	
		<br/>
		
		<button type="submit">등록</button>
	</form>
	
	<br/>
	
	<a href="/student">학생 관리 메인으로</a>
</body>
</html>