<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<title>Transferencia</title>
</head>
<body>

	<div class="ml-5 mt-5">
		<h3> Transferencia para outra conta</h3>
		<form:form action="transferir" method="POST">
			<div class="form-group">
				<label>Destinatario: Conta</label>
				<input class="form-control w-25" type="text" name="numeroConta" />
			</div>
			<div class="form-group">
				<label>Valor </label>
				<input class="form-control w-25" type="text" name="valor" />
			</div>
			<button type="submit" class="btn btn-primary"> Transferir</button>
			<div class="form-group mt-3">
				<a href="menu"> Voltar</a>
			</div>
		</form:form>
	</div>
</body>
</html>