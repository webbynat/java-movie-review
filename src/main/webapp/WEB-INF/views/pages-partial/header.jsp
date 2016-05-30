<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="header">
	<nav class="navbar navbar-default">
		<div class="navbar-header logo">
			<a class="navbar-brand" href='<c:url value="/"></c:url>'>MOVIE REVIEW</a>
		</div>
		<div class="container-fluid">
			<ul class="nav navbar-nav navbar-right">
				<!-- If not logged in -->
				<li><a href='<c:url value="/login"></c:url>'>Sign In</a></li>
				<li><a href='<c:url value="/register"></c:url>'>Sign Up</a></li>
				
				<!-- If logged in -->
				<%-- <li><a href='<c:url value="#"></c:url>'><!-- Show Username --></a></li>
				<li><a href='<c:url value="/logout"></c:url>'>Sign Out</a></li> --%>
			</ul>
		</div>
		<!-- Navigation Bar -->
	</nav>
</header>