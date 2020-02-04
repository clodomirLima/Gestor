<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<br><br>
	<center>
		<button><a href="listar.jsp">Listar</a></button>
	</center><br>

<center>Cadastar Gestor</center>

<form action="cad" method="post">
	<table align="center" border="0">
		<tr>
			<td>Nome:</td>
			<td><input type="text" name="nome" placeholder="Nome" required="required"></td>
		</tr>
		<tr>
			<td>Idade:</td>
			<td><input type="number" name="idade" placeholder="Idade" required="required"></td>
		</tr>
		<tr>
			<td>Endereco:</td>
			<td><input type="text" name="endereco" placeholder="Endereco" required="required"></td>
		</tr>
		<tr>
			<td>Telefone:</td>
			<td><input type="number" name="telefone" placeholder="Telefone" required="required"></td>
		</tr>
		<tr>
			<td><input type="submit" value="Cadastrar"></td>
			<td><input type="reset" value="Limpar"></td>
		</tr>
		
	</table>
	</form>
</body>
</html>