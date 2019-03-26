<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<div>
		<h1>Login</h1>
		<form:form action="efetuaLogin" method="post">
			<div>
				<label>Login</label> 
				<input type="text" name="login" />
				
			</div>
			<div>
				<label>Senha</label> 
				<input type="password" name="senha" />
			</div>
			<button type="submit">Logar</button>
			<div>
				<a href="${s:mvcUrl('UC#form').build()}">Cadastrar-se </a>
			</div>
		</form:form>
		<c:if test="${not empty loginInvalido}">
			<h3>${loginInvalido}</h3>
		</c:if>
	</div>
</body>
</html>