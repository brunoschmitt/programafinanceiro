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
<title>Lista de Movimentações Financeiras</title>
</head>
<body>
	<table>
		<tr>
			<th>Id</th>
			<th>Entrada</th>
			<th>Saída</th>
			<th>Tipo</th>
			<th>Data</th>
		</tr>

		<c:forEach items="${movimentacoes}" var="movimentacao">
			<tr>
				<td>${movimentacao.id}</td>
				<td>${movimentacao.valor}</td>
				<td>${movimentacao.tipoValor}</td>
				<td>${movimentacao.tipo}</td>
				<td><span><fmt:formatDate value="${movimentacao.data}" pattern="dd/MM/yyyy" /></span></td>
				<td><ul><li>${movimentacao.descricao}</li></ul></td>
				<td><a href="remover/${movimentacao.id}"> Remover</a></td>
			</tr>

		</c:forEach>
	</table>

	<form action="listarPorPeriodo" method="GET">
		<div>
			<label> Filtrar por data</label> 
			<input type="dateTime" name="inicio" id="inicio" /> 
			<input type="dateTime" name="termino" id="termino" />
			<input type="submit" value="Filtrar">
		</div>
	</form>
	<form action="listarPorTipoValor" method="GET">
		<div>
			<label> Filtrar por Tipo Valor</label>
			<label><input type="radio" name="tipoValor" value='ENTRADA' /> Entrada</label>
			<label><input type="radio" name="tipoValor"  value='SAIDA'/> Saida</label>
			<input type="submit" value="Filtrar"> 
		</div>
	</form>
	<div>
		<ul>
			<li><a href="menu"> Voltar</a></li>
		</ul>
	</div>


</body>
</html>