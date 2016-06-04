<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="header">
	<nav class="navbar navbar-default">
		<div class="navbar-header logo">
			<!-- Toggle button, appear in xs and sm size -->
			<button type = "button" class = "navbar-toggle" data-toggle = "collapse" data-target = "#toggler">
				<span class = "sr-only">Toggle navigation</span>
				<span class = "icon-bar"></span>
				<span class = "icon-bar"></span>
				<span class = "icon-bar"></span>
			</button>
			
			<!-- Home Navigation -->
			<a class="navbar-brand" href='<c:url value="/"></c:url>'>MOVIE REVIEW</a>
		</div>
		<div class="container-fluid collapse navbar-collapse" id="toggler">
			<ul class="nav navbar-nav navbar-right">
			<c:choose>
			  <c:when test="${ empty sessionScope.username }">
				<!-- If not logged in -->
				<li><a href='<c:url value="/login"></c:url>'>Sign In</a></li>
				<li><a href='<c:url value="/register"></c:url>'>Sign Up</a></li>
			  </c:when>
			  <c:otherwise>
				<!-- If logged in -->
				<li><a href='<c:url value="#"></c:url>'>${ sessionScope.displayname }</a></li>
				<li><a href='<c:url value="/logout"></c:url>'>Sign Out</a></li>
			  </c:otherwise>
			</c:choose>
			</ul>
		</div>
		<!-- Navigation Bar -->
	</nav>
</header>