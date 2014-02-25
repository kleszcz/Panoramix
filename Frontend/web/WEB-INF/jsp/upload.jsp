<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Panoramix: user control</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	<body>
		<%
			java.sql.Connection connection = java.sql.DriverManager.getConnection(
					"jdbc:derby://localhost:1527/Panoramix",
					"panoramix",
					"panoramix"
			);
			java.sql.ResultSet objects = connection.createStatement().executeQuery(
					"select oid,label from Objects order by label"
			);
		%>
		<s:nestedPath path="upload">
			<form method="post" enctype="multipart/form-data">
				<s:bind path="image">
					<input type="file" name="${status.expression}" value="${status.value}"/>
				</s:bind>
				<s:bind path="description">
					<input type="text" name="${status.expression}" value="${status.value}"/>
				</s:bind>
				<input type="submit" value="Add image" />
			</form>
		</s:nestedPath>
	</body>
</html>
