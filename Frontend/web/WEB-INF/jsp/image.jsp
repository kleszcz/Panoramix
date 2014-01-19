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
        <style type="text/css">
            .upvote   {color: green;}
            .downvote {color: red;}
        </style>

    </head>
    <body>
        <script type="text/javascript">
            sel_poi = null;
            sel_pin = null;
            map_pin_sel = new Image(20, 20);
            map_pin_sel.src = "gfx/map_pin_sel.png";
            function onPOIClick(pid)
            {
                pois = document.getElementsByName(pid);
                pins = document.getElementsByName("pin" + pid);
                if (sel_poi)
                {
                    sel_poi.style.display = 'none';
                }
                if (sel_pin)
                    sel_pin.src = "gfx/map_pin.png";
                pois[0].style.display = 'block';
                pins[0].src = map_pin_sel.src;
                sel_poi = pois[0];
                sel_pin = pins[0];

            }
        </script>
        <div name="imageContainer" >
            <h1>${image.description}</h1>
            <h2>Click on a pin to see its discussion.</h2>
            <div style="position: relative">
                <!-- Wykomentowane rzeczy do wykrywania kliku kliku -->
                <!-- <form method="POST"> -->
                <c:set var="pid" value="${0}" />
                <c:set var="last_votes" value="${0}" />
                <c:forEach var="obj" items="${objectsList}" >
                    <c:choose>
                        <c:when test="${obj.pid == pid && obj.votes > last_votes}" >
                            <img name="pin${obj.pid}" title="${obj.label} - ${obj.description}" style="position: absolute; top: ${obj.y-20}px; left: ${obj.x-10}px; width: 20px; height: 20px;" src="gfx/map_pin.png" onclick="onPOIClick(${obj.pid})"/>
                            <c:set var="last_votes" value="${obj.votes}" />
                        </c:when>
                        <c:when test="${obj.pid != pid}" >
                            <img name="pin${obj.pid}" title="${obj.label} - ${obj.description}" style="position: absolute; top: ${obj.y-20}px; left: ${obj.x-10}px; width: 20px; height: 20px;" src="gfx/map_pin.png" onclick="onPOIClick(${obj.pid})"/>
                            <c:set var="pid" value="${obj.pid}"/>
                            <c:set var="last_votes" value="${obj.votes}" />
                        </c:when>
                    </c:choose>

                </c:forEach>        
                <img alt="${image.filename}" src="images/${image.filename}" /> <br/>
                  <!--      <input type="image", src="images/${image.filename}", name="img" />
                    </form> -->
                Photo by: ${image.uname} from ${image.taken_from_label}
            </div>
        </div>
        <div name="commentsContainer">
            <c:set var="id" value="${0}" />
            <div style="display: none;" >
                <c:forEach var="ass" items="${objectsList}" >
                    <c:if test="${ass.pid != id}" >
                    </div>
                    <div name="${ass.pid}" style="display: none;" ><p><b>POI ${ass.pid}: (${ass.x}  ${ass.y}) by ${ass.point_author}</b></p>               
                    </c:if>                            
                    <div name="assumption">
                        ${ass.votes} :: ${ass.label} - ${ass.description} by ${ass.assumption_author}
                        <c:forEach var="comm" items="${commentsList}" >
                            <c:if test="${comm.aid == ass.aid}" >
                                <c:set var="vote" value="${comm.vote}" />
                                <% Integer cv = (Integer) pageContext.getAttribute("vote");%>
                                <p class="<%=(cv > 0) ? "upvote" : (cv < 0) ? "downvote" : ""%>" >${comm.author}: ${comm.text}</p>
                            </c:if>
                        </c:forEach>  
                    </div>
                    <c:set var="id" value="${ass.pid}" />
                </c:forEach>
            </div>

        </div>
    </body>
</html>
