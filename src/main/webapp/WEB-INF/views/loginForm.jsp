<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<div class="conteiner  m-2 w-25 p-2">
		<h1>Login</h1>
		<form:form action="efetuaLogin" method="post">
			<div class="form-group">
				<label>Login</label> 
				<input type="text" name="login" class="form-control "  />
				
			</div>
			<div class="form-group">
				<label>Senha</label> 
				<input type="password" name="senha" class="form-control "  />
			</div>
			<button type="submit" class="btn btn-primary">Logar</button>
			<div class="form-group">
				<a href="${s:mvcUrl('UC#form').build()}">Cadastrar-se </a>
			</div>
		</form:form>
		<c:if test="${not empty msg}">
			<h3>${msg}</h3>
		</c:if>
	</div>
</body>
</html>