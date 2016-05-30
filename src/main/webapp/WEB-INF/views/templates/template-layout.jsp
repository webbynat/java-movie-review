<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>
		<tiles:insertAttribute name="title"/>
	</title>
	<link rel="stylesheet" type="text/css" href='<c:url value="resources/bootstrap-3.3.6-dist/css/bootstrap.min.css"></c:url>'>
	<link rel="stylesheet" type="text/css" href='<c:url value="resources/stylesheets/stylesheet.css"></c:url>'>
	<script type="text/javascript" src='<c:url value="resources/javascripts/jquery-1.12.4.min.js"></c:url>'></script>
	<script type="text/javascript" src='<c:url value="resources/bootstrap-3.3.6-dist/js/bootstrap.min.js"></c:url>'></script>
</head>
<body>
	<tiles:insertAttribute name="header"/>
	<tiles:insertAttribute name="menu"/>
	<tiles:insertAttribute name="content"/>
	<tiles:insertAttribute name="footer"/>
</body>
</html>