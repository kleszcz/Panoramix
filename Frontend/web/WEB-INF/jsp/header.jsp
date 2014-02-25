<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="header" class="header" >
	<div class="left">
		<a href="index.do" >Panoramix</a>
	</div>
	<div>
		<form action="search.do" method="get" >
			<input type="text"   name="name"  placeholder="POI"/>
			<input type="submit" value="Search" />
		</form>
	</div>
	<div class="right">
		<c:choose>
			<c:when test="${uname == null}">
				<p><form action="login.do" method="post" style="display: inline;">
					<input type="text"     name="uname"     placeholder="Username"/>
					<input type="password" name="password"  placeholder="Password"/>
					<input type="submit" value="Log in" />
				</form>
				or <a href="register.do">register</a></p>
			</c:when>
			<c:otherwise>
				Logged in as ${uname}. (<a href="logout">Logout</a>)
			</c:otherwise>
		</c:choose>
	</div>
</div>
