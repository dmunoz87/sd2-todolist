<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
<head>
	<title>Add Item</title>
</head>

<body>
	<br><br>
	<div id="add" align="center">
		<form action="addItem" method="POST">
			<table>
				<tr>
					<td><label for="list">List Item:</label><input type="text" name="item" width="100"></td>			
				</tr>
				<tr>
					<td><input type="submit"></td>
				</tr>
			</table>
		</form>
		<a href='<c:url value="index.jsp" />'>Home</a>
	</div>
</body>
</html>