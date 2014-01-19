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
		<style type="text/css">
			.upvote   {color:   green;}
			.downvote {color:   red;  }

			div               {border: solid black 1px;}
			img.marker        {content:url("gfx/map_pin.png"); position: absolute; width: 20px; height: 20px;}
			img#active.marker {content:url("gfx/map_pin_sel.png");}
			div.poi           {background: lightgray;}
			div#active.poi    {background: lightpink;}
			/*
			div.poi        {display: none; }
			div#active.poi {display: block;}
			*/
		</style>
		<script type="text/javascript">
			sel_poi = sel_pin = null;
			function onPOIClick(pid) {
				if(sel_poi) sel_poi.id = '';
				if(sel_pin) sel_pin.id = '';
				(sel_poi = document.getElementsByName('poi_' + pid)[0]).id =
				(sel_pin = document.getElementsByName('pin_' + pid)[0]).id = 'active';
			}
		</script>
	</head>
	<body>
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
							<img name="pin_${obj.pid}" title="${obj.label} - ${obj.description}" class="marker" style="top: ${obj.y-20}px; left: ${obj.x-10}px;" onclick="onPOIClick(${obj.pid})"/>
							<c:set var="last_votes" value="${obj.votes}" />
						</c:when>
						<c:when test="${obj.pid != pid}" >
							<img name="pin_${obj.pid}" title="${obj.label} - ${obj.description}" class="marker" style="top: ${obj.y-20}px; left: ${obj.x-10}px;" onclick="onPOIClick(${obj.pid})"/>
							<c:set var="pid" value="${obj.pid}"/>
							<c:set var="last_votes" value="${obj.votes}" />
						</c:when>
					</c:choose>

				</c:forEach>
				<img alt="${image.filename}" src="images/${image.filename}" /> <br/>
					<!--<input type="image", src="images/${image.filename}", name="img" />
					</form>-->
				Photo by: ${image.uname} from ${image.taken_from_label}
			</div>
		</div>
		<div name="commentsContainer">
			<c:set var="id" value="${0}" />
			<div id="sentinel__man_this_is_fucky" style="display: none;" >
				<c:forEach var="ass" items="${objectsList}" >
					<c:if test="${ass.pid != id}" >
					</div>
					<div name="poi_${ass.pid}" class="poi" onclick="onPOIClick(${ass.pid})">
						<p><b>POI ${ass.pid}: by ${usersMap.get(ass.point_author.toString())}</b></p>
					</c:if>
					<div class="assumption">
						${ass.votes} :: ${ass.label} - ${ass.description} by ${usersMap.get(ass.assumption_author.toString())}
						<c:forEach var="comm" items="${commentsList}" >
							<c:if test="${comm.aid == ass.aid}" >
								<c:set var="vote" value="${comm.vote}" />
								<% Integer cv = (Integer) pageContext.getAttribute("vote");%>
								<p class="<%=(cv > 0) ? "upvote" : (cv < 0) ? "downvote" : ""%>" >${usersMap.get(comm.author.toString())}: ${comm.text}</p>
							</c:if>
						</c:forEach>
					</div>
					<c:set var="id" value="${ass.pid}" />
				</c:forEach>
			</div>
		</div>
	</body>
</html>
