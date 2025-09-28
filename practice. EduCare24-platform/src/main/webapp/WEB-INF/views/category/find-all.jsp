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
			<th>catId</th>
			<th>categoryName</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
			<c:forEach var="category" items="${categoryPage.content}">
				<tr>
					<td>${category.catId}</td>
					<td>${category.catName}</td>
					<td><a href="update/${category.catId}">수정</a></td>
					<td><a href="delete/${category.catId}">삭제</a></td>
				</tr>
			</c:forEach>
	</table>
	
	<c:if test="${startPage > 0}">
	    <a href="?page=${startPage - 1}&size=${categoryPage.size}">Prev</a>
	</c:if>
	
	<c:forEach var="i" begin="${startPage}" end="${endPage}">
	    <c:choose>
	        <c:when test="${i == categoryPage.number}">
	            <strong>${i + 1}</strong>
	        </c:when>
	        <c:otherwise>
	            <a href="?page=${i}&size=${categoryPage.size}">${i + 1}</a>
	        </c:otherwise>
	    </c:choose>
	</c:forEach>
	
	<c:if test="${endPage < categoryPage.totalPages - 1}">
	    <a href="?page=${endPage + 1}&size=${categoryPage.size}">Next</a>
	</c:if>
	
	<br/>
	
	<a href="/category">카테고리 관리 메인으로</a>
</body>
</html>