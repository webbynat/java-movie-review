<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section id="content">
	<div class="text-center">
		<h1 class="top-title ">Sign up to Movie Review</h1>
	</div>
	<c:if test="${ not empty requestScope.RegisterError }">
		<div class="text-center">
			<h1 class="top-title ">${ requestScope.RegisterError }</h1>
		</div>
	</c:if>
	<section class="login-form">
		<form action='<c:url value="/register"></c:url>' method="post">
		<fieldset>
			<div class="form-group">
				<label for="username">Username</label>
				<input class="form-control" name="username" required>
			</div>
			<div class="form-group">
				<label for="password">Password</label>
				<input class="form-control" name="password" type="password" required>
			</div>
			<div class="form-group">
				<label for="re-password">Retype Password</label>
				<input class="form-control" name="re-password" type="password" required>
			</div>
			<div class="form-group">
				<label for="display-name">Full name</label>
				<input class="form-control" name="display-name" required>
			</div>
			<div class="form-group">
				<label for="email">Email</label>
				<input class="form-control" name="email" type="email" required>
			</div>		
			<div class="form-group">
				<label for="phone">Phone</label>
				<input class="form-control" name="phone">
			</div>
			<button class="btn btn-primary btn-submit" id="sign-up">Sign Up</button>
		</fieldset>
		</form>
		<hr>
		<div class="text-center">
			<label for="3rdparty">Register via</label>
			<div class="row">
				<div class="col-xs-3 col-xs-offset-3">
					<a href="#"><img class="brand google-brand" src='<c:url value="resources/images/google-plus.svg"></c:url>' alt="google-brand"/></a>
				</div>
				<div class="col-xs-3">
					<a href="#"><img class="brand facebook-brand" src='<c:url value="resources/images/facebook.svg"></c:url>' alt="facebook-brand"/></a>
				</div>
			</div>
		</div>
	</section>
	<div class="text-center">Icons made by <a href="http://www.freepik.com" title="Freepik">Freepik</a> from <a href="http://www.flaticon.com" title="Flaticon">www.flaticon.com</a> is licensed by <a href="http://creativecommons.org/licenses/by/3.0/" title="Creative Commons BY 3.0" target="_blank">CC 3.0 BY</a></div>
</section>