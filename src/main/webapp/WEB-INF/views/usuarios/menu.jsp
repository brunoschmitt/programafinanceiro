<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet"
		  href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		  integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
		  crossorigin="anonymous">

<meta charset="UTF-8">
<title>Menu</title>
</head>
<body>
	<c:if test="${not empty login}">
		<h3>${login}</h3>
	</c:if>

	<div class="container w-50">
		<h1>Bem Vindo ao Controle de Finanças</h1>
		<ul class="list-group">
			<li class="list-group-item"><a href="${s:mvcUrl('MFC#form').build()}">Adicionar Movimentação Financeira</a></li>
			<li class="list-group-item"><a href="${s:mvcUrl('MFC#listar').build()}">Lista/Remover Movimentação Financeira</a></li>
			<li class="list-group-item"><a href="${s:mvcUrl('MFC#detalhe').build()}"> Detalhes da Conta</a></li>
			<li class="list-group-item"><a href="${s:mvcUrl('MFC#formTransferencia').build()}"> Transferir </a></li>
			<li class="list-group-item"><a href="<c:url value="/logout" />"> Sair </a></li>
		</ul>
	</div>
</body>
</html>