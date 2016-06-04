<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section id="content">
	<div class="text-center">
		<h1 class="top-title ">Sign up to Movie Review</h1>
	</div>
	<section class="login-form">
		<form action='<c:url value="/register"></c:url>' method="post">
		<fieldset>
			<div class="form-group">
				<label for="username">Username <span>*</span></label>
				<input class="form-control" name="username" tabindex="1" required>
			</div>
			<div class="form-group">
				<label for="password">Password <span>*</span></label>
				<input class="form-control" name="password" type="password" tabindex="2" required>
			</div>
			<div class="form-group">
				<label for="password">Re-enter Password <span>*</span></label>
				<input class="form-control" type="password" tabindex="3" required>
			</div>
			<div class="form-group">
				<label for="username">Display Name</label>
				<input class="form-control" name="displayName" tabindex="4">
			</div>
			<div class="form-group">
				<label for="username">Email <span>*</span></label>
				<input class="form-control" name="email" type="email" tabindex="5" required>
			</div>
			<div class="form-group">
				<label for="username">Phone</label>
				<input class="form-control" name="phone" tabindex="6">
			</div>
			<div style="color:red; font-style:italic;">
				<c:if test="${ not empty error }">
					<c:out value="${error}"></c:out>
				</c:if>
			</div>
			<button class="btn btn-primary btn-submit" id="sign-in" tabindex="7">Sign Up</button>
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