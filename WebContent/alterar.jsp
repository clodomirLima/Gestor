<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br>
	<br>
	<center>
		<button>
			<a href="cadastrar.jsp">Cadastrar</a>
		</button>
		<button>
			<a href="listar.jsp">Listar</a>
		</button>
	</center>
	<br>

	<center>Alterar Gestor</center>
	<%
		String id = "";
		String nome = "";
		String idade = "";
		String endereco = "";
		String telefone = "";

		id = (String) request.getAttribute("id").toString();
		nome = (String) request.getAttribute("nome").toString();
		idade = (String) request.getAttribute("idade").toString();
		endereco = (String) request.getAttribute("endereco").toString();
		telefone = (String) request.getAttribute("telefone").toString();
	%>

	<form action="alt" method="post">
		<table align='center'>
			<tr>
				<td colspan="2"><input type="hidden" name="id" value="<%=id%>"></td>
			</tr>
			<tr>
				<td>Nome:</td>
				<td><input type="text" name=nome value="<%=nome%>"
					required="required"></td>
			</tr>
			<tr>
				<td>Idade:</td>
				<td><input type="text" name="idade" value="<%=idade%>"
					required="required"></td>
			</tr>
			<tr>
				<td>Endereco:</td>
				<td><input type="text" name="endereco" value="<%=endereco%>"
					required="required"></td>
			</tr>
			<tr>
				<td>Telefone:</td>
				<td><input type="text" name="telefone" value="<%=telefone%>"
					required="required"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Alterar"></td>
			</tr>
		</table>
	</form>
</body>
</html>