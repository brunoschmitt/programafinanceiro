<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">

    <meta charset="UTF-8">
    <title>Detalhe da Conta</title>
</head>
<body>
<div class="m-3">
    <div class="form-group w-25">
        <label class="form-control">Login:  ${conta.usuario.login}</label>
        <label class="form-control">Nome:   ${conta.usuario.nome}</label>
    </div>
    <table class="table table-bordered">
        <tr>
            <th scope="col">Conta</th>
            <th scope="col">Saldo</th>
        </tr>

        <tr>
            <td>${conta.numeroConta}</td>
            <td>${conta.saldo}</td>
        </tr>
    </table>

    <div>
        <ul>
            <li><a href="${s:mvcUrl('MFC#voltar').build()}"  class="badge badge-primary"> Menu</a></li>
        </ul>
    </div>

</div>
</body>
</html>