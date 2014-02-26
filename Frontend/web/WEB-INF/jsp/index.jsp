<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Panoramix</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	<body>
		<div id="content">
			<c:forEach var="img" items="${images}" >
				<a name="${img.getIid()}" href="image.do?iid=${img.getIid()}"><img class="thumb" src="images/${img.getFilename()}"></a>
			</c:forEach>
			<c:if test="${uname != null}">
				<div id="upload_image">
					<form method="post" enctype="multipart/form-data" action="upload.do">
						<input type="file" name="image" />
						<input type="text" name="description" />
						<input type="submit" value="Add image" />
					</form>
				</div>
			</c:if>
		</div>
		<%@include file="header.jsp"%>
	</body>
</html>
