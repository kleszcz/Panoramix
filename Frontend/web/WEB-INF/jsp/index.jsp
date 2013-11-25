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
		try {
			// THE BEST KIND OF PASSWORDS? HARDCODED PASSWORDS!
			java.sql.Connection connection = java.sql.DriverManager.getConnection(
				"jdbc:derby://localhost:1527/Panoramix",
				"panoramix",
				"panoramix"
			);
			java.sql.ResultSet images = connection.createStatement().executeQuery(
				"select * from Images"
			);
		%>
		<%while(images.next()) {%>
		<hr>
		<img alt="panorama" src="images/<%=images.getString("filename")%>">
		<ul>
			<%
			// FIXME:
			// the code below is stupid: it should first loop over POIs, then Assumptions, then Comments
			// now there's no distinction between assumptions with equal oids but different pids
			java.sql.ResultSet assumptions = connection.createStatement().executeQuery(
				"select * from POI left join Assumptions using (pid) left join Objects using (oid) where iid = " + images.getInt("iid")
			);
			while(assumptions.next()) {%>
			<li>
				<b><%=assumptions.getString("label")%></b>: <%=assumptions.getString("description")%>
				<ul>
					<%
					java.sql.ResultSet comments = connection.createStatement().executeQuery(
						"select * from Comments join Users using (uid) where aid = " + assumptions.getInt("aid") + " order by added"
					);
					while(comments.next()) {%>
					<li><b><%=comments.getString("uname")%></b>: <%=comments.getString("text")%></li>
					<%}%>
				</ul>
			</li>
			<%}%>
		</ul>
		<%}%>
		<%} catch(Exception e) { %>
		<h1> <%= e %> </h1>
		<%}%>
	</body>
</html>
