<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Panoramix - Search results for ${searchName}</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	<body>
		<div id="content" >
			<h1>Search results for "${searchName}":</h1>
			<c:if test="${searchList.isEmpty()}">
				<p>There were none.</p>
			</c:if>
			<table>
				<c:forEach var="e" items="${searchList}" >
					<tr>
						<td>${e.label}</td>
						<td>
							<a href="image.do?iid=${e.iid}" ><img class="thumb" src="images/${e.filename}" /></a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<%@include file="header.jsp"%>
	</body>
</html>
