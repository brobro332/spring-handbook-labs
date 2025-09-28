<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/enrollment" method="post">
		<input type="text" name="studentId" placeholder="studentId"/><br/>
		<input type="text" name="courseId" placeholder="courseId"/><br/>
		<input type="text" name="paymentMethod" placeholder="paymentMethod"/><br/>
		<input type="text" name="amount" placeholder="amount"/><br/>
	
		<br/>
		
		<button type="submit">등록</button>
	</form>
	
	<br/>
	
	<a href="/enrollment">등록 관리 메인으로</a>
</body>
</html>