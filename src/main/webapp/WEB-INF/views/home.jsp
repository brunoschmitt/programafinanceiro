<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pagina inicial</title>
</head>
<body>
	<h1>Bem Vindo ao Controle de Finanças</h1>
	<div>
		<ul>
			<li><a href="${s:mvcUrl('LC#formulario').build()}"> Login</a></li>
			<li><a href="${s:mvcUrl('UC#form').build()}"> Cadastrar</a></li>
		</ul>
	</div>
</body>
</html>