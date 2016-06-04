<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section id="content">
	<div class="text-center">
		<h1 class="top-title ">Sign in to Movie Review</h1>
	</div>
	<c:if test="${ not empty requestScope.LoginError }">
		<div class="text-center">
			<h1 class="top-title ">${ requestScope.LoginError }</h1>
		</div>
	</c:if>
	<section class="login-form">
		<form action='<c:url value="/login"></c:url>' method="post">
		<fieldset>
			<div class="form-group">
				<label for="username">Username or email address</label>
				<input class="form-control" name="username" required>
			</div>
			<div class="form-group">
				<label for="password">Password<a href="#" class="forgot-password">Forgot password?</a></label>
				<input class="form-control" name="password" type="password" required>
			</div>
			<button class="btn btn-primary btn-submit" id="sign-in">Sign In</button>
		</fieldset>
		</form>
		<hr>
		<div class="text-center">
			<label for="3rdparty">Login via</label>
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