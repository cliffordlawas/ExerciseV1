<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<html>
<head>
<title>Login</title>
<link rel="icon" href="https://aca.asiainspection.com/favicon.ico" type="image/x-icon"/>

<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
<style>.alert-p,.logo-wrapper{position:absolute;width:100%}.logo-wrapper{background:#b1181f;top:0;left:0}.alert-p{margin:0 auto -85px;display:block;bottom:0;left:auto;right:0;text-align:center}.login-box{background:#fff;border:1px solid #f1ecec;margin-top:18vh;padding:38px;-webkit-box-shadow:0 0 22px -6px rgba(0,0,0,.11);-moz-box-shadow:0 0 22px -6px rgba(0,0,0,.11);box-shadow:0 0 22px -6px rgba(0,0,0,.11);border-bottom:4px solid #b1181f}.title{margin-top:26px;color:#fff}form{margin-top:57px}.btn-primary-custom{background-color:#3c3c3c;border-color:#3c3c3c}.btn-primary-custom:focus,.btn-primary-custom:hover{background-color:#6d6b6b;border-color:#6d6b6b}.logo{height:80px;width:80px;margin:0 auto;display:block}body{background:url(https://www.toptal.com/designers/subtlepatterns/patterns/photography.png)}</style>
</head>
<body onload='document.loginForm.username.focus();'>

	<div class='container'>
		<div class='row'>
			<div class='col-sm-4'></div>
			<div class='col-sm-4 login-box'>
			<div class='logo-wrapper'>
			<div class='row'>
			<div class='col-sm-4'><img src='https://aca.asiainspection.com/images/login/ailogo.png' class='logo'></div>
			<div class='col-sm-8'><h5 class='title'>Product Management</h5></div>
			</div>
		</div>
		

		<form name='loginForm'
		  action="<c:url value='/j_spring_security_check' />" method='POST'>
<c:if test="${not empty error}">
			<div class="alert alert-danger alert-p">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="alert alert-success alert-p">${msg}</div>
		</c:if>
		<div class='form-group'>
		 	<label for="username">Username: </label>
		 	<td><input class='form-control' type='text' name='username'></td>
		</div>
		<div class='form-group'>
		 	<label for="password">Password: </label>
		 	<input class='form-control'  type='password' name='password' />
		</div>	
			<input name="submit" class='btn btn-primary btn-block btn-primary-custom' type="submit"  value="Sign in" />
		  	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

		</form>
		</div>
			<div class='col-xs-4'></div>
		
		</div>
	</div>

</body>
</html>