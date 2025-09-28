<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/enrollment/delete/${enrollment.enrollmentId}" method="post">
		<input type="text" name="enrollmentId" value="${enrollment.enrollmentId}" placeholder="enrollmentId" readonly/><br/>
	
		<br/>
		
		<button type="submit">삭제</button>
	</form>
	
	<br/>
	
	<a href="/enrollment">등록 관리 메인으로</a>
</body>
</html>