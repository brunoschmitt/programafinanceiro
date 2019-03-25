<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro</title>
</head>
<body>
	<div>
		<h1>Cadastro de Usuario</h1>
		<form:form action="${s:mvcUrl('UC#gravar').build()}"
			modelAttribute="usuario" method="POST">
			<div>
				<label>Nome</label> <input type="text" name="nome" />
				<form:errors path="nome" class="help-inline"></form:errors>
			</div>
			<div>
				<label>login</label> <input type="text" name="login" />
				<form:errors path="login" class="help-inline"></form:errors>
			</div>
			<div>
				<label>senha</label> <input type="password" name="senha" />
				<form:errors path="senha" class="help-inline"></form:errors>

			</div>

			<div>
				<label>Tipo da Conta </label> <select name="conta.tipo">
					<option value="POUPANCA">Conta Poupança</option>
					<option value="CORRENTE">Conta Corrente</option>
				</select>
			</div>
			<button type="submit">Cadastrar</button>
			<a href="${s:mvcUrl('LC#formulario').build()}"> Ja é cadastrado?? Clique aqui</a>
		</form:form>
	</div>

</body>
</html>