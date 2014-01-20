<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="org.springframework.stereotype.Component"%>
<%@page import="org.springframework.beans.factory.annotation.Value"%>
<%@page import="java.util.List"%>
<%@page import="bean.ImageInfo"%>
<%@page import="java.awt.Image"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Panoramix - Search results for ${searchName} </title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <div id="content" >
        <h1>Search results for ${searchName}:</h1>
        <c:if test="${noResults}">
            <p> Sorry, no results for ${searchName}. </p>
        </c:if>
        <c:if test="${!noResults}">
            <table>
                <c:forEach var="e" items="${searchList}" >
                    <tr>
                        <td> ${e.label} </td>
                        <td>
                            <a href="image.htm?iid=${e.iid}" ><img width="120px" height="90px" src="images/${e.filename}" /></a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        </div>
        
        <!-- Fun fact: due to rendering issues header must be last :) -->
        <div id="header" class="header" >
            <div>
            <a href="index.htm" >Home</a>
            <a href="search.htm" >Search</a>
            </div>
            <div>
            <form action="search.htm" method="get" >
                <span>Name:</span>
                <input id="name" type="text"  name="name"  placeholder="Type in name"/>
                <input id="search" type="submit" value="Search" />
            </form>
            </div>
            <div>
                Username
            </div>
        </div>

    </body>
</html>
