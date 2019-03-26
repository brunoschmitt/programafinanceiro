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
<title>Menu</title>
</head>
<body>
	<c:if test="${not empty login}">
		<h3>${login}</h3>
	</c:if>
	<h1>Bem Vindo ao Controle de Finanças</h1>
	<div>
		<ul>
			<li><a href="${s:mvcUrl('MFC#form').build()}">Adicionar Movimentação Financeira</a></li>
			<li><a href="${s:mvcUrl('MFC#listar').build()}">Lista/Remover Movimentação Financeira</a></li>
			<li><a href="${s:mvcUrl('MFC#detalhe').build()}"> Detalhes da Conta</a></li>
			<li><a href="${s:mvcUrl('MFC#formTransferencia').build()}"> Transferir </a></li>
			<li><a href="<c:url value="/logout" />"> Sair </a></li>
		</ul>
	</div>
</body>
</html>