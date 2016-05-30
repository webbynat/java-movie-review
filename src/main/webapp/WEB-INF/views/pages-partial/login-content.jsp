<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section id="content">
	<div class="text-center">
		<h1 class="top-title ">Sign in to Movie Review</h1>
	</div>
	<section class="login-form">
		<form action='<c:url value="/login"></c:url>' method="post">
		<fieldset>
			<div class="form-group">
				<label for="username">Username or email address</label>
				<input class="form-control" name="username">
			</div>
			<div class="form-group">
				<label for="password">Password<a href="#" class="forgot-password">Forgot password?</a></label>
				<input class="form-control" name="password" type="password">
			</div>
			<button class="btn btn-primary btn-submit" id="sign-in">Sign In</button>
		</fieldset>
		</form>
	</section>
</section>