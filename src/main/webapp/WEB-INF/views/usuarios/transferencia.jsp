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
<title>Transferencia</title>
</head>
<body>
	<h3> Transferencia para outra conta</h3>
	<div>
		<form:form action="transferir" method="POST">
			<div>
				<label>Destinatario: Conta</label>
				<input type="text" name="numeroConta" />
			</div>
			<div>
				<label>Valor </label>
				<input type="text" name="valor" />
			</div>
			<button type="submit"> Transferir</button>
			<div>
				<a href="menu"> Voltar</a>
			</div>
		</form:form>
	</div>
</body>
</html>