<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Search</title>
	</head>
	<body>
		<h1>Search for images.</h1>
		<spring:nestedPath path="search">
			<form action="" method="get">
				<span>Name:</span>
				<spring:bind path="name">
					<input type="text" name="${status.expression}" value="${status.value}">
				</spring:bind>
				<input type="submit" value="Search">
			</form>
		</spring:nestedPath>
	</body>
</html>
