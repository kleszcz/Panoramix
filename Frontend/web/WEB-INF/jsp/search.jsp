<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
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
            <spring:nestedPath path="search">
                <form action="" method="get">
                    <span>Name:</span>
                    <spring:bind path="name">
                        <input type="text" name="${status.expression}" value="${status.value}">
                    </spring:bind>
                    <input type="submit" value="Search">
                </form>
            </spring:nestedPath>
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
