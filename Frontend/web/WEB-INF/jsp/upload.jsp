<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Panoramix: upload file</title>
	</head>
	<body>
		<form:form method="post" enctype="multipart/form-data" modelAttribute="imageUpload" action="upload.do">
			<input type="file" name="image" />
			<input type="submit" value="Upload" />
		</form:form>
	</body>
</html>