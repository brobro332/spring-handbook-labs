<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/course" method="post">
		<input type="text" name="courseName" placeholder="courseName"/><br/>
		<input type="text" name="price" placeholder="price"/><br/>
		<input type="text" name="catId" placeholder="catId"/><br/>
	
		<br/>
		
		<button type="submit">등록</button>
	</form>
	
	<br/>
	
	<a href="/course">강좌 관리 메인으로</a>
</body>
</html>