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
<title>Cadastro</title>
</head>
<body>
	<div class="conteiner m-2 w-25 p-2">
		<h1>Cadastro de Usuario</h1>
		<form:form action="${s:mvcUrl('UC#gravar').build()}"
			modelAttribute="usuario" method="POST">
			<div>
				<div class="form-group">
					<label>Nome</label> 
					<input type="text" name="nome" class="form-control " />
					<form:errors path="nome" class="help-inline"></form:errors>
				</div>
				<div class="form-group">
					<label>login</label> 
					<input type="text" name="login" class="form-control" />
					<form:errors path="login" class="help-inline"></form:errors>
				</div>
				<div class="form-group">
					<label>senha</label> 
					<input type="password" name="senha" class="form-control" />
					<form:errors path="senha" class="help-inline"></form:errors>

				</div>
				<div class="form-group">
					<label>Tipo da Conta </label> 
					<select name="conta.tipo" class="custom-select">
						<option value="POUPANCA">Conta Poupança</option>
						<option value="CORRENTE">Conta Corrente</option>
					</select>
				</div>

				<button type="submit" class="btn btn-primary">Cadastrar</button>
				<a href="${s:mvcUrl('LC#formulario').build()}"> Ja é
					cadastrado?? Clique aqui</a>
			</div>
		</form:form>
		<c:if test="${not empty msg}">
			<h3>${msg}</h3>
		</c:if>
	</div>

</body>
</html>