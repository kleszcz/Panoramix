<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="usersMap" class="java.util.HashMap" />
<c:forEach var="u" items="${usersList}">
    <c:set target="${usersMap}" property="${u.uid}" value="${u.uname}" />
</c:forEach>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Panoramix</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <style type="text/css">
            div {border: solid black 1px;}

            img#picture  {width: 600px;}
            img.marker {
                content:url("gfx/map_pin.png");
                position: absolute;
                -webkit-transform:translate(-50%, -100%); /*FIXME: FUGLY*/
                transform:translate(-50%, -100%);
            }
            img#active.marker {content:url("gfx/map_pin_sel.png");}

            div.poi           {background: lightgray;}
            div#active.poi    {background: lightyellow;}

            .assumption               {opacity:    .6;}

            .assumption.good          {background: lightgreen;}
            .assumption.bad           {background: lightpink;}
            .assumption.controversial {background: gray;}

            .assumption .upvote       {color:   green;}
            .assumption .downvote     {color:   red;  }
            /*
            div.poi        {display: none; }
            div#active.poi {display: block;}
            */
        </style>
        <script type="text/javascript">
            sel_poi = sel_pin = null;
            function onPOIClick(pid) {
                if (sel_poi)
                    sel_poi.id = '';
                if (sel_pin)
                    sel_pin.id = '';
                (sel_poi = document.getElementsByName('poi_' + pid)[0]).id =
                        (sel_pin = document.getElementsByName('pin_' + pid)[0]).id = 'active';
            }
        </script>
    </head>
    <body>
        
        <div id="content" >
            <div id="imageContainer">
                <h1>${image.description}</h1>
                <div id="img" style="position: relative; display: inline-block;">
                    <!-- Wykomentowane rzeczy do wykrywania kliku kliku -->
                    <!-- <form method="POST"> -->
                    <c:set var="pid" value="${0}" />
                    <c:set var="last_votes" value="${0}" />
                    <c:forEach var="obj" items="${objectsList}" >
                        <c:choose>
                            <c:when test="${obj.pid == pid && obj.votes > last_votes}" >
                                <img name="pin_${obj.pid}" title="${obj.label} - ${obj.description}" class="marker" style="top: ${obj.y*100}%; left: ${obj.x*100}%;" onclick="onPOIClick(${obj.pid})"/>
                                <c:set var="last_votes" value="${obj.votes}" />
                            </c:when>
                            <c:when test="${obj.pid != pid}" >
                                <img name="pin_${obj.pid}" title="${obj.label} - ${obj.description}" class="marker" style="top: ${obj.y*100}%; left: ${obj.x*100}%;" onclick="onPOIClick(${obj.pid})"/>
                                <c:set var="pid" value="${obj.pid}"/>
                                <c:set var="last_votes" value="${obj.votes}" />
                            </c:when>
                        </c:choose>
                    </c:forEach>
                    <img alt="${image.filename}" src="images/${image.filename}" id="picture"/>
                </div>
                <br/>
                <!--<input type="image", src="images/${image.filename}", name="img" />
                </form>-->
                Photo by: ${image.uname} from ${image.taken_from_label}
            </div>
            <div id="commentsContainer">
                <c:set var="id" value="${0}" />
                <div id="sentinel__man_this_is_fucky" style="display: none;" >
                    <c:forEach var="ass" items="${objectsList}" >
                        <c:if test="${ass.pid != id}" >
                        </div>
                        <div name="poi_${ass.pid}" class="poi" onclick="onPOIClick(${ass.pid})">
                            <p><b>POI ${ass.pid}: by ${usersMap.get(ass.point_author.toString())}</b></p>
                        </c:if>
                        <c:if test="${ass.votes != null}" >
                            <c:set var="votes" value="${ass.votes}" />
                            <% Integer v = (Integer) pageContext.getAttribute("votes");%>
                            <div class="assumption <%=(v > 0) ? "good" : (v < 0) ? "bad" : "controversial"%>">
                                ${ass.votes} :: ${ass.label} - ${ass.description} by ${usersMap.get(ass.assumption_author.toString())}
                                <c:forEach var="comm" items="${commentsList}" >
                                    <c:if test="${comm.aid == ass.aid}" >
                                        <c:set var="vote" value="${comm.vote}" />
                                        <% Integer cv = (Integer) pageContext.getAttribute("vote");%>
                                        <p class="<%=(cv > 0) ? "upvote" : (cv < 0) ? "downvote" : ""%>" >${usersMap.get(comm.author.toString())}: ${comm.text}</p>
                                    </c:if>
                                </c:forEach>
                            </div>
                        </c:if>
                        <c:set var="id" value="${ass.pid}" />
                    </c:forEach>
                </div>
            </div>
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
