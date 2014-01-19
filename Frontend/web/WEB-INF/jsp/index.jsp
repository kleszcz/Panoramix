<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Panoramix</title>
        <style type="text/css">
            .upvote   {color: green;}
            .downvote {color: red;}
        </style>
    </head>
    <body>
        <form action="search.htm" method="get">
            <span>Name:</span>                
            <input type="text" name="name" > 
            <input type="submit" value="Search"> 
        </form>
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

                                while (images.next()) {
                                        int iid = images.getInt("iid");
        %>
        <hr>
        <a name="<%=iid%>"><img alt="panorama" src="images/<%=images.getString("filename")%>"></a>
        <ul>
            <%
                                java.sql.ResultSet POI = connection.createStatement().executeQuery(
                                        "select * from POI where iid = " + iid
                                );
                                while (POI.next()) {%>
            <li>
                <p>(<%=POI.getInt("x")%>, <%=POI.getInt("y")%>)</p>
                <%
                                        java.sql.ResultSet assumptions = connection.createStatement().executeQuery(
                                                "select * from (select A.*,"
                                                + " (select coalesce(sum(vote),0) from Comments as C where C.aid = A.aid) as votes"
                                                + " from Assumptions as A where pid = " + POI.getInt("pid") + ") as AV"
                                                + " left join Objects using (oid)"
                                                + " order by votes desc, AV.added"
                                        );
                                        while (assumptions.next()) {%>
                <b><%=assumptions.getString("label")%></b> (ocena: <%=assumptions.getInt("votes")%>): <%=assumptions.getString("description")%>

                <ul>
                    <%
                                                java.sql.ResultSet comments = connection.createStatement().executeQuery(
                                                        "select * from Comments join Users using (uid) where aid = " + assumptions.getInt("aid") + " order by added"
                                                );

                                                while (comments.next()) {
                                                        int v = comments.getInt("vote");%>
                    <li class="<%=(v > 0) ? "upvote" : (v < 0) ? "downvote" : ""%>"><b><%=comments.getString("uname")%></b>: <%=comments.getString("text")%></li>
                            <%}%>
                </ul>
                <%}%>

            </li>
            <%}%>
        </ul>
        <%}%>
        <%} catch (Exception e) {%>

        <h1> <%=e%> </h1>

        <%}%>
    </body>
</html>
