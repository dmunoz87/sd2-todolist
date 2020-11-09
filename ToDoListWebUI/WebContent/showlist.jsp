<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>

<!DOCTYPE html>

<html>
<head>
	<title>Show List</title>
</head>

<body>
	<div align="center">
		<c:if test="${list != null}">
			<table border="1">
				<caption>Show To-Do-List</caption>
				<tr>
					<td>Item Number</td>
					<td>Item Description</td>
				</tr>
				<c:forEach var="entry" items="${list}">
					<tr>
						<td><c:out value="${entry.key}"/></td>
						<td><c:out value="${entry.value}"/></td>
						<td><a href="delete?id=<c:out value='${entry.key}'/>">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<c:if test="${list == null}">
			<c:redirect url="index.jsp"/>
		</c:if>
		<a href='<c:url value="index.jsp" />'>Home</a>
	</div>

</body>
</html>