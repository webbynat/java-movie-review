<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section id="content">
	<div class="text-center">
		<h1 class="top-title ">Edit your profile</h1>
	</div>
	
	<c:if test="${ not empty requestScope.ProfileSuccess }">
		<div class="text-center">
			<div class="alert alert-success">
				<h1 class="top-title "><strong>Success!</strong>${ requestScope.ProfileSuccess }</h1>
  			</div>
		</div>
	</c:if>
	
	<c:if test="${ not empty requestScope.ProfileError }">
		<div class="text-center">
			<div class="alert alert-danger">
  			  <h1 class="top-title "><strong>Error!</strong>${ requestScope.ProfileError }</h1>
  			</div>
		</div>
	</c:if>
	
	<section class="login-form" >
		<form action='<c:url value="/profile"></c:url>' method="post">
		<fieldset>
			<div class="form-group">
				<label for="username">Username</label>
				<input class="form-control" name="username" required disabled value ="${ requestScope.user.username }" >
			</div>
			<div class="form-group">
				<label for="old-password">Old Password</label>
				<input class="form-control" name="old-password" type="password" required placeholder="**********" >
			</div>
			<div class="form-group">
				<label for="password">New Password</label>
				<input class="form-control" name="password" type="password" required value = "888888888888888">
			</div>

			<div class="form-group">
				<label for="display-name">Full name</label>
				<input class="form-control" name="display-name" required value ="${ requestScope.user.displayName }" >
			</div>
			<div class="form-group">
				<label for="email">Email</label>
				<input class="form-control" name="email" type="email" required value ="${ requestScope.user.email }" >
			</div>		
			<div class="form-group">
				<label for="phone">Phone</label>
				<input class="form-control" name="phone" value ="${ requestScope.user.phone }" >
			</div>
			<button class="btn btn-primary btn-submit" id="save">Save</button>
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