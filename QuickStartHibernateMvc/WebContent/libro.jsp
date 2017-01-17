<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Libri</h1>

<form action="ControllerLibro" method="POST">
	<table>
		<tr>
			<td>Id:</td>
			<td><input type="text" name="id" value="${libro.id}" /></td>
		</tr>
		<tr>
			<td>Titolo:</td>
			<td><input type="text" name="titolo" value="${libro.titolo}" /></td>
		</tr>
		<tr>
			<td>ISBN:</td>
			<td><input type="text" name="isbn" value="${libro.isbn}" /></td>
		</tr>
		<tr>
			<td>Prezzo:</td>
			<td><input type="text" name="prezzo" value="${libro.prezzo}" /></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" name="Add" value="Add" />
				<input type="submit" name="Edit" value="Edit" />
				<input type="submit" name="Delete" value="Delete" />
				<input type="submit" name="Find" value="Search" />
			</td>
		</tr>
	</table>
</form>

<table border="1">
	<th>Id</th>
	<th>Titolo</th>
	<th>ISBN</th>
	<th>Prezzo</th>
	<c:forEach items="${allLibri}" var="l">
	<tr>
		<td>${l.id}</td>
		<td>${l.titolo}</td>
		<td>${l.isbn}</td>
		<td>${l.prezzo}</td>
	</tr>
	</c:forEach>
</table>

</body>
</html>