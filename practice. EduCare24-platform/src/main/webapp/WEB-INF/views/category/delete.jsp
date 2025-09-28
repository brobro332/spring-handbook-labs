<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/category/delete/${category.catId}" method="post">
		<input type="text" name="catId" value="${category.catId}" placeholder="catId" readonly/><br/>
	
		<br/>
		
		<button type="submit">삭제</button>
	</form>
	
	<br/>
	
	<a href="/category">카테고리 관리 메인으로</a>
</body>
</html>