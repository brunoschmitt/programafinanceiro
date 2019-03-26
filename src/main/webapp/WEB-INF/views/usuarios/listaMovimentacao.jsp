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
	<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<title>Lista de Movimentações Financeiras</title>
</head>
<body>
	<div class="conteiner m-2 w-25 p-2">
		<table  class="table table-bordered">
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Entrada</th>
				<th scope="col">Saída</th>
				<th scope="col">Tipo</th>
				<th scope="col">Data</th>
				<th scope="col">Descrição</th>
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
	</div>

	<div class="conteiner m-2 w-25 p-2">
		<form action="listarPorPeriodo" method="GET">
			<label> Filtrar por data</label> 
			<div>
				<input type="dateTime" name="inicio" id="inicio"/> 
				<input type="dateTime" name="termino" id="termino"/>
				<input type="submit" value="Filtrar" class="btn btn-primary ml-1">
			</div>
		</form>
		<form action="listarPorTipoValor" method="GET">
			<label> Filtrar por Tipo Valor</label>
			<div class="form-check form-check-inline">
				<input class="form-check-input" type="radio" name="tipoValor" value='ENTRADA' />
				<label class="form-check-label" for="inlineCheckbox1"> Entrada</label>
			</div>	
			<div class="form-check form-check-inline">	
				<input class="form-check-input" type="radio" name="tipoValor"  value='SAIDA'/>
				<label  class="form-check-label" for="inlineCheckbox1"> Saida</label>
				<input type="submit" value="Filtrar" class="btn btn-primary ml-2"> 
			</div>
		</form>
		<div>
			<ul>
				<li><a href="menu"> Voltar</a></li>
			</ul>
		</div>
	</div>


</body>
</html>