<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- FIXME: fix votes if already voted -->
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Panoramix</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<script src="js/jquery.js"></script>
		<script type="text/javascript">
			sel_poi = sel_pin = null;
			function onPOIClick(pid) {
				if (sel_poi)
					sel_poi.id = '';
				if (sel_pin)
					sel_pin.id = '';
				(sel_poi = document.getElementsByName('poi_' + pid)[0]).id = (sel_pin = document.getElementsByName('pin_' + pid)[0]).id = 'active';
			}
			function onCommentClick(aid) {
				document.getElementsByName('commentbox_' + aid)[0].style.display = 'block';
				window.event.target.style.display = 'none';
			}
			<c:if test="${uname != null}">
			function onImgClick() {
				e = window.event;
				$("#newmarker").remove();
				if (e.button === 0) {
					x = e.offsetX / $("#img").width();
					y = e.offsetY / $("#img").height();
					s = $('<img class="marker" id="newmarker" style="top: ' + y * 100 + '%; left: ' + x * 100 + '%;"/>');
					s.id = 'newmarker';
					$("#img").append(s);
					$("#poiform").show();
					$('#poiform form input[name="x"]').val(x);
					$('#poiform form input[name="y"]').val(y);
				} else {
					$("#poiform").hide();
				}
			}

			$(document).ready(function() {
				$("#img").click(onImgClick);
			});
			</c:if>
		</script>
	</head>
	<body>
		<div id="content" >
			<div id="imageContainer">
				<h1>${image.description}</h1>
				<div id="img" style="position: relative; display: inline-block;">
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
					<img alt="${image.filename}" src="images/${image.filename}" id="picture" />
				</div>
				<br/>
				Photo by ${image.uname}<c:if test="${image.taken_from_label != null}">, taken from ${image.taken_from_label}</c:if>
				<c:if test="${uname != null}">
					<div id="poiform" style="display: none;">
						<form method="post" action="addpoi.do">
							<input type="hidden" name="x" />
							<input type="hidden" name="y" />
							<input type="hidden" name="iid" value="${image.iid}" />
							<input type="submit" value="add POI"/>
						</form>
					</div>
					<div id="add_object">
						<form method="post" action="addobject.do">
							<input type="text" placeholder="label"       name="label" />
							<input type="text" placeholder="lat"         name="lat" />
							<input type="text" placeholder="long"        name="long" />
							<input type="text" placeholder="description" name="description" />
							<input type="submit" value="Add Object" />
						</form>
					</div>
				</c:if>
			</div>
			<div id="commentsContainer">
				<c:set var="id" value="${0}" />
				<div id="sentinel__man_this_is_fucky" style="display: none;" >
					<c:forEach var="ass" items="${objectsList}" >
						<c:if test="${ass.pid != id}" >
						</div>
						<hr/>
						<div name="poi_${ass.pid}" class="poi" onclick="onPOIClick(${ass.pid})">
							<p>POI added by ${usersMap.get(ass.point_author)}.</p>
							<c:if test="${uname != null}">
								<div id="assform" style="display: inline;">
									<form method="post" action="addassumption.do" id="assform_${ass.pid}" style="display: inline;">
										<input type="hidden" name="pid" value="${ass.pid}" />
										<input type="submit" value="add assumption:"/>
									</form>
									<select name="oid" form="assform_${ass.pid}" style="display: inline;">
										<c:forEach var="object" items="${objects}" >
											<option value="${object.oid}">${object.label}</option>
										</c:forEach>
									</select>
								</div>
							</c:if>
						</c:if>
						<c:if test="${ass.votes != null}" >
							<c:set var="votes" value="${ass.votes}" />
							<% Integer v = (Integer) pageContext.getAttribute("votes");%>
							<div class="assumption <%=(v > 0) ? "good" : (v < 0) ? "bad" : "controversial"%>">
								${usersMap.get(ass.assumption_author)} (${ass.votes}) :: <a href="search.do?name=${ass.label}&oid=${ass.oid}">${ass.label}</a> - ${ass.description}
								<c:forEach var="comm" items="${commentsList}" >
									<c:if test="${comm.aid == ass.aid}" >
										<c:set var="vote" value="${comm.vote}" />
										<% Integer cv = (Integer) pageContext.getAttribute("vote");%>
										<p class="<%=(cv > 0) ? "upvote" : (cv < 0) ? "downvote" : ""%>" >${usersMap.get(comm.author)}: ${comm.text}</p>
									</c:if>
								</c:forEach>
								<c:if test="${uname != null}">
									<button onclick="onCommentClick(${ass.aid})">comment</button>
									<div class="commentbox" style="display: none;" name="commentbox_${ass.aid}" onclick="onPOIClick(${ass.aid})">
										<select name="vote" form="commform_${ass.aid}">
											<option value="1">upvote</option>
											<option value="0" selected="selected">neutral</option>
											<option value="-1">downvote</option>
										</select>
										<form action="addcomment.do" method="post" id="commform_${ass.aid}">
											<textarea name="text" rows="20" cols="80"></textarea>
											<input type="hidden" name="aid" value="${ass.aid}"/>
											<br/>
											<input type="submit" value="Comment"/>
										</form>
									</div>
								</c:if>
							</div>
						</c:if>
						<c:set var="id" value="${ass.pid}" />
					</c:forEach>
				</div>
			</div>
		</div>
		<jsp:include page="header.jsp"/>
	</body>
</html>
