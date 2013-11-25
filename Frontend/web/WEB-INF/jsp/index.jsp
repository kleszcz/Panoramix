<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Dżawa! Dżawa! Dżawa!</title>
	</head>
	<body>
		<p>Wipe your mind on the welcome mat and enter... THE SCARY DOOR</p>
		<%
		java.sql.Connection connection;
		java.sql.ResultSet  result;
		try {
			// THE BEST KIND OF PASSWORDS? HARDCODED PASSWORDS!
			connection = java.sql.DriverManager.getConnection("jdbc:derby://localhost:1527/Panoramix","panoramix","panoramix");
			result       = connection.createStatement().executeQuery("select * from Images");
		%>
		<%while(result.next()) {%>
			<%=result.getInt("iid")%>
			<img alt="panorama" src="images/<%=result.getString("filename")%>">
		<%}%>
		<%} catch(Exception e) { %>
			<h1> <%= e %> </h1>
		<%}%>
	</body>
</html>
