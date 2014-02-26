<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="add_object">
	<h3>Add object</h3>
	<form method="post" action="addobject.do">
		<input type="text" placeholder="label"       name="label" />
		<input type="text" placeholder="description" name="description" />
		<input type="submit" value="Submit" />
	</form>
</div>
<div id="upload_image">
	<h3>Upload image</h3>
	<p>Taken from:<select name="oid" form="addimage">
		<option value="null">(no idea)</option>
		<c:forEach var="object" items="${objects}" >
			<option value="${object.oid}">${object.label}</option>
		</c:forEach>
	</select></p>
	<form method="post" enctype="multipart/form-data" action="upload.do" id="addimage">
		<input type="file" name="image" />
		<input type="text" name="description" placeholder="descripton" />
		<input type="submit" value="Submit" />
	</form>
</div>