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
		<s:nestedPath path="register">
			<h1>Register</h1>
			<form method="post">
				<s:bind path="uname">
					<p>Username: <c:if test="${status.error}"><span class="error">(${status.errorMessage})</span></c:if></p>
					<input type="text" name="${status.expression}" value="${status.value}">
				</s:bind>
				<br />
				<s:bind path="password">
					<p>Password: <c:if test="${status.error}"><span class="error">(${status.errorMessage})</span></c:if></p>
					<input type="password" name="${status.expression}" value="${status.value}">
				</s:bind>
				<br />
				<input type="submit" value="Register">
			</form>
		</s:nestedPath>
	</body>
</html>
