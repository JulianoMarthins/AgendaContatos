<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="icon" href="imagens/phone.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Editar Contato</h1>
	<form name="frmContato" action="">
		<table>
		<tr>
				<td><input type="text" name="idCliente" class="Caixa2"
				 readonly value="<%out.print(request.getAttribute("idCliente"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="nome" class="Caixa1"
				value="<%out.print(request.getAttribute("nome")); %>"></td>
			</tr>
			<tr>
				<td><input type="tel" name="fone" class="Caixa1"
				value="<%out.print(request.getAttribute("fone")); %>"></td>
			</tr>
			<tr>
				<td><input type="text" name="cpf" class="Caixa1"
				value="<%out.print(request.getAttribute("cpf")); %>"></td>
			</tr>
			<tr>
				<td><input type="text" name="rg" class="Caixa1"
				value="<%out.print(request.getAttribute("rg")); %>"></td>
			</tr>
		</table>
		<input type="button" value="Salvar" class="Botao1"
			onclick="validar()">
	</form>

	<script src="scripts/validador.js"></script>
</body>
</html>