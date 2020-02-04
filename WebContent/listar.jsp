<%@page import="java.util.ArrayList"%>
<%@page import="DAO.Conexao"%>
<%@page import="java.sql.Connection"%>
<%@page import="DTO.GestorDTO"%>
<%@page import="DAO.GestorDAO"%>

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
		<button><a href="cadastrar.jsp">Cadastrar</a></button>
	</center><br>
	<center>Lista de Gestores</center><br>

<table border=1 cellpadding=0 cellspacing=0 width='30%' align="center" style="text-align: center">
            <tr>
                <th>Nome: </th>
                <th>Alterar</th>
                <th>Excluir</th>
            </tr>

            <%
                String id = "";
                String nome = "";
                

                Connection con;
                con = Conexao.conect();
                
                GestorDAO dao = new GestorDAO(con);
                GestorDTO dto = new GestorDTO();

                ArrayList<GestorDTO> nomes = dao.pesquisarTudo();

                for (int i = 0; i < nomes.size(); i++) {
                    dto = nomes.get(i);
                    
                    id = String.valueOf(dto.getId());
                    nome = String.valueOf(dto.getNome());
            %>

            <tr>
                <td><%=nome%></td>
                <td><a href="bus?id=<%=id%>" >Alterar</a></td>
                <td><a href="exc?id=<%=id%>" >Excluir</a></td>
                    <%}%>
            </tr>
        </table>
</body>
</html>