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
<title>Adicionar Movimentação Financeira</title>
</head>
<body>
	<div class="conteiner m-2 w-25 p-2"">
		<form:form action="${s:mvcUrl('MFC#adicionar').build()}" modelAttribute="movimentacao" method="POST">
			<div class="form-group">
				<label>Valor</label> 
				<form:input type="text" path="valor" class="form-control" />
				<form:errors path="valor" class="help-inline"/>
			</div>
			<div class="form-group">
				<label>Tipo de Valor</label> 
				<select name="tipoValor" class="custom-select">
					<option value="ENTRADA"> Entrada</option>
					<option value="SAIDA"> Saida</option>
				</select>
			</div>
			<div class="form-group">
				<label>Tipo</label> 
				<select name="tipo" class="custom-select">
					<option value="CARTAO">Cartão</option>
					<option value="CHEQUE">Cheque</option>
				</select>
			</div>
			<div class="form-group">
				<label>Data</label> 
				<form:input type="dateTime" path="data" class="form-control" />
				<form:errors path="data" class="help-inline"></form:errors>
			</div>
			<div class="form-group">
				<label>Descrição</label> 
				<form:input type="text" path="descricao" class="form-control" />
				<form:errors path="descricao" class="help-inline"></form:errors>
			</div>

			<button type="submit" class="btn btn-primary">Adicionar</button>
			<div>
				<a href="${s:mvcUrl('MFC#voltar').build()}"  class="badge badge-primary"> Voltar</a>
			</div>
		</form:form>
	</div>
</body>
</html>