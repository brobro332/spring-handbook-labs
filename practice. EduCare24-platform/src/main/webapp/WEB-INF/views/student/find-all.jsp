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
			<th>수정</th>
			<th>삭제</th>
		</tr>
			<c:forEach var="student" items="${studentPage.content}">
				<tr>
					<td>${student.studentId}</td>
					<td>${student.name}</td>
					<td>${student.email}</td>
					<td><a href="update/${student.studentId}">수정</a></td>
					<td><a href="delete/${student.studentId}">삭제</a></td>
				</tr>
			</c:forEach>
	</table>
	
	<c:if test="${startPage > 0}">
	    <a href="?page=${startPage - 1}&size=${studentPage.size}">Prev</a>
	</c:if>
	
	<c:forEach var="i" begin="${startPage}" end="${endPage}">
	    <c:choose>
	        <c:when test="${i == studentPage.number}">
	            <strong>${i + 1}</strong>
	        </c:when>
	        <c:otherwise>
	            <a href="?page=${i}&size=${studentPage.size}">${i + 1}</a>
	        </c:otherwise>
	    </c:choose>
	</c:forEach>
	
	<c:if test="${endPage < studentPage.totalPages - 1}">
	    <a href="?page=${endPage + 1}&size=${studentPage.size}">Next</a>
	</c:if>
	
	<br/>
	
	<a href="/student">학생 관리 메인으로</a>
</body>
</html>