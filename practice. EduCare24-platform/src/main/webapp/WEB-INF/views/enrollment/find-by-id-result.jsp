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
			<th>enrollmentId</th>
			<th>studentId</th>
			<th>studentName</th>
			<th>courseId</th>
			<th>courseName</th>
			<th>paymentMethod</th>
			<th>amount</th>
		</tr>
			<tr>
				<td>${enrollment.enrollmentId}</td>
				<td>${enrollment.student.studentId}</td>
				<td>${enrollment.student.name}</td>
				<td>${enrollment.course.courseId}</td>
				<td>${enrollment.course.courseName}</td>
				<td>${enrollment.paymentMethod}</td>
				<td>${enrollment.amount}</td>
			</tr>
	</table>
	
	<br/>
	
	<a href="/enrollment">등록 관리 메인으로</a>
</body>
</html>