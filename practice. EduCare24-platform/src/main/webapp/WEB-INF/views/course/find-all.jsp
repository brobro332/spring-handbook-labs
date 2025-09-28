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
			<th>수정</th>
			<th>삭제</th>
		</tr>
			<c:forEach var="course" items="${coursePage.content}">
				<tr>
					<td>${course.courseId}</td>
					<td>${course.courseName}</td>
					<td>${course.price}</td>
					<td>${course.category.catId}</td>
					<td>${course.category.catName}</td>
					<td><a href="update/${course.courseId}">수정</a></td>
					<td><a href="delete/${course.courseId}">삭제</a></td>
				</tr>
			</c:forEach>
	</table>
	
	<c:if test="${startPage > 0}">
	    <a href="?page=${startPage - 1}&size=${coursePage.size}">Prev</a>
	</c:if>
	
	<c:forEach var="i" begin="${startPage}" end="${endPage}">
	    <c:choose>
	        <c:when test="${i == coursePage.number}">
	            <strong>${i + 1}</strong>
	        </c:when>
	        <c:otherwise>
	            <a href="?page=${i}&size=${coursePage.size}">${i + 1}</a>
	        </c:otherwise>
	    </c:choose>
	</c:forEach>
	
	<c:if test="${endPage < coursePage.totalPages - 1}">
	    <a href="?page=${endPage + 1}&size=${coursePage.size}">Next</a>
	</c:if>
	
	<br/>
	
	<a href="/course">강좌 관리 메인으로</a>
</body>
</html>