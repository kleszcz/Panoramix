<%-- 
    Document   : image
    Created on : Nov 27, 2013, 6:39:12 PM
    Author     : Jan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>${image.description}</h1>
        <div style="position: relative">
            <c:forEach var="poi" items="${POIMap}" >
                <img alt ="" title="${poi.value.label} - ${poi.value.description}" style="position: absolute; top: ${poi.key.y-20}px; left: ${poi.key.x-10}px; width: 20px; height: 20px;" src="gfx/map_pin.png" />
                
            </c:forEach>        
        <img alt="${image.filename}" src="images/${image.filename}" />
        </div>
        
    </body>
</html>
