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
			<th>courseId</th>
			<th>courseName</th>
			<th>price</th>
			<th>catId</th>
			<th>catName</th>
		</tr>
			<tr>
				<td>${course.courseId}</td>
				<td>${course.courseName}</td>
				<td>${course.price}</td>
				<td>${course.category.catId}</td>
				<td>${course.category.catName}</td>
			</tr>
	</table>
	
	<br/>
	
	<a href="/course">강좌 관리 메인으로</a>
</body>
</html>