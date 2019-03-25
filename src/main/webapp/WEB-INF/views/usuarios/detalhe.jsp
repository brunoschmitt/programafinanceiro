<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalhe da Conta</title>
</head>
<body>
	<div>	
		<label>${usuario.login}</label>
		<label>${usuario.nome}</label>
	</div>
	<table>
		<tr>
			<th>Conta</th>
			<th>Saldo</th>
		</tr>

		<tr>
			<td>${conta.numeroConta}</td>
			<td>${conta.saldo}</td>
		</tr>
	</table>

	<div>
		<ul>
			<li><a href="${s:mvcUrl('MFC#voltar').build()}"> Menu</a></li>
		</ul>
	</div>
</body>
</html>