<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
	<title>To-Do-List Web UI</title>
</head>

<body>
<br><br>
	<div align="center">
		<p>Welcome! Please select a link below to perform the desired list method</p><br>
		<form action="link" method="POST">
			<table>
				<tr>
					<td><label for="link">Type in "add" or "show" without quotations, then press submit to be redirected to that page</label><br>
					<input type="text" name="link"></td>			
				</tr>
				<tr>
					<td><input type="submit"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>