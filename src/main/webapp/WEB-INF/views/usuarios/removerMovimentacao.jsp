<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Remvover Movimentacao</title>
</head>
<body>
	<div>
		<form:form action="deletar" method="DELETE" modelAtribute="movimentacoes">
			<div>
				<form:select path="movimentacoes">
					<form:options items="${listaDeMovimentacoes.id}" />
				</form:select>
			</div>
			<div>
				<ul>
					<li> <a href="remover/${movimentacao.id}"> Remover</a></li>
				</ul>
			</div>
		</form:form>
	</div>
	<div>
		<ul>
			<li><a href="menu"> Voltar</a></li>
		</ul>
	</div>

</body>
</html>