<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adicionar Movimentação Financeira</title>
</head>
<body>
	<div>
		<form:form action="${s:mvcUrl('MFC#adicionar').build()}" modelAttribute="movimentacao" method="POST">
			<div>
				<label>Valor</label> 
				<form:input type="text" path="valor" />
				<form:errors path="valor" class="help-inline"/>
			</div>
			<div>
				<label>Tipo de Valor</label> 
				<select name="tipoValor">
					<option value="ENTRADA"> Entrada</option>
					<option value="SAIDA"> Saida</option>
				</select>
			</div>
			<div>
				<label>Tipo</label> 
				<select name="tipo">
					<option value="CARTAO">Cartão</option>
					<option value="CHEQUE">Cheque</option>
				</select>
			</div>
			<div>
				<label>Data</label> 
				<form:input type="dateTime" path="data" />
				<form:errors path="data" class="help-inline"></form:errors>
			</div>
			<div>
				<label>Descrição</label> 
				<form:input type="text" path="descricao" />
				<form:errors path="descricao" class="help-inline"></form:errors>
			</div>

			<button type="submit">Adicionar</button>
			<div>
				<a href="${s:mvcUrl('MFC#voltar').build()}"> Voltar</a>
			</div>
		</form:form>
	</div>
</body>
</html>