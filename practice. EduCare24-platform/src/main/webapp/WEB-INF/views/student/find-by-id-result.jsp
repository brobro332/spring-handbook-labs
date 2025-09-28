<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" style="border-collapse: collapse;">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>email</th>
		</tr>
			<tr>
				<td>${student.studentId}</td>
				<td>${student.name}</td>
				<td>${student.email}</td>
			</tr>
	</table>
	
	<br/>
	
	<a href="/student">학생 관리 메인으로</a>
</body>
</html>