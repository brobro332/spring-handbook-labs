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
		</tr>
			<tr>
				<td>${category.catId}</td>
				<td>${category.catName}</td>
			</tr>
	</table>
	
	<br/>
	
	<a href="/category">카테고리 관리 메인으로</a>
</body>
</html>