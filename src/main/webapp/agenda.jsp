<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>

<%
     ArrayList<JavaBeans> contatos = (ArrayList<JavaBeans>) request.getAttribute("contatos");
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Agenda de Contatos</title>

<link rel="icon" href="imagens/phone.png">
<link rel="stylesheet" href="style.css">

</head>
<body>

	<h1>Agenda de Contatos</h1>
	<a href="novo.html" class="Botao1">Novo Contato</a>

	<table id="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Telefone</th>
				<th>CPF</th>
				<th>RG</th>
			</tr>
		</thead>
		<tbody>

			<%
			for(int i = 0; i < contatos.size(); i++) {
			%>
			<tr>
				<td><%=contatos.get(i).getIdCliente()%></td>
				<td><%=contatos.get(i).getNome()%></td>
				<td><%=contatos.get(i).getFone()%></td>
				<td><%=contatos.get(i).getCpf()%></td>
				<td><%=contatos.get(i).getRg()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>

</body>
</html>