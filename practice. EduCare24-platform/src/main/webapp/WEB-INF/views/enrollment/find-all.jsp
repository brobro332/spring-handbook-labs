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
			<th>courseId</th>
			<th>paymentMethod</th>
			<th>amount</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
			<c:forEach var="enrollment" items="${enrollmentPage.content}">
				<tr>
					<td>${enrollment.enrollmentId}</td>
					<td>${enrollment.student.studentId}</td>
					<td>${enrollment.course.courseId}</td>
					<td>${enrollment.paymentMethod}</td>
					<td>${enrollment.amount}</td>
					<td><a href="update/${enrollment.enrollmentId}">수정</a></td>
					<td><a href="delete/${enrollment.enrollmentId}">삭제</a></td>
				</tr>
			</c:forEach>
	</table>
	
	<c:if test="${startPage > 0}">
	    <a href="?page=${startPage - 1}&size=${enrollmentPage.size}">Prev</a>
	</c:if>
	
	<c:forEach var="i" begin="${startPage}" end="${endPage}">
	    <c:choose>
	        <c:when test="${i == enrollmentPage.number}">
	            <strong>${i + 1}</strong>
	        </c:when>
	        <c:otherwise>
	            <a href="?page=${i}&size=${enrollmentPage.size}">${i + 1}</a>
	        </c:otherwise>
	    </c:choose>
	</c:forEach>
	
	<c:if test="${endPage < enrollmentPage.totalPages - 1}">
	    <a href="?page=${endPage + 1}&size=${enrollmentPage.size}">Next</a>
	</c:if>
	
	<br/>
	
	<a href="/enrollment">등록 관리 메인으로</a>
</body>
</html>