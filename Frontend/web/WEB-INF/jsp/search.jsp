<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Panoramix - Search</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	<body>
		<div id="content" >
			<h1>Search for images.</h1>
			<s:nestedPath path="search">
				<form action="" method="get">
					<span>Name:</span>
					<s:bind path="name">
						<input type="text" name="${status.expression}" value="${status.value}">
					</s:bind>
					<input type="submit" value="Search">
				</form>
			</s:nestedPath>
		</div>
		<%@include file="header.jsp"%>
	</body>
</html>
