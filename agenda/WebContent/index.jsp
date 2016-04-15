<!DOCTYPE html>
<%@page import="java.io.PrintWriter"%>
<%@page import="br.ufpr.dao.ContatoDao"%>
<%@page import="br.ufpr.modelo.Contato"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta charset="UTF-8">
<title>agenda</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js">
	
</script>
</head>
<body>

	<div class="container">
		<div class="panel panel-primary">
			<div class="table-responsive">
				<table class="table">
					<tr>
						<td>ID</td>
						<td>NOME</td>
						<td>E-MAIL</td>
						<td>ENDEREÇO</td>
						<td>DATA DE NASCIMENTO</td>
					</tr>
					<%
						ContatoDao contatoDao = new ContatoDao();
						List<Contato> lista = contatoDao.getLista();

						for (Contato c : lista) {
					%>
					<tr>
					<tr>
						<td><%=c.getId()%></td>
						<td><%=c.getNome()%></td>
						<td><%=c.getEmail()%></td>
						<td><%=c.getEndereco()%></td>
						<td><%=c.getDataNascimento()%></td>
					</tr>
					<%
						}
					%>

					<!-- 	System.out.println("ID="+ c.getId()+ " NOME="+ c.getNome()+ " EMAIL="+ c.getEmail()+ " ENDERECO="+ -->
					<!-- 			c.getEndereco()+ " DATA NASC="+ c.getDataNascimento()); -->
					<!-- } -->

					<tr>
						<td><button
								onclick="window.location.href='adicionaContato.html';">ADD</button></td>

					</tr>
				</table>
			</div>

		</div>
	</div>
</body>
</html>