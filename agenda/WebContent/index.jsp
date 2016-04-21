<!DOCTYPE html>
<%@page import="java.text.SimpleDateFormat"%>
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
			<div class="panel-heading">
				<center>Lista de Contatos</center>
			</div>

			<div class="panel panel-primary">
				<div class="table-responsive">
					<table class="table">
						<tr>
							<td>ID</td>
							<td>NOME</td>
							<td>E-MAIL</td>
							<td>ENDEREÇO</td>
							<td>DATA DE NASCIMENTO</td>
							<td>Alterar</td>
						</tr>
						<%
							ContatoDao contatoDao = new ContatoDao();
							List<Contato> lista = contatoDao.getLista();

							for (Contato c : lista) {
						%>
						<tr>
							<td><%=c.getId()%></td>
							<td><%=c.getNome()%></td>
							<td><%=c.getEmail()%></td>
							<td><%=c.getEndereco()%></td>
							<td><%=new SimpleDateFormat("dd/MM/yyyy").format(c.getDataNascimento().getTime())%></td>
							<td><button id="<%=c.getId()%>" class="btn btn-primary"
									onclick="window.location.href='alterarContato.jsp?id=<%=c.getId()%>';">Alterar</button>

							</td>
						</tr>
						<%
							}
						%>
					</table>
				</div>
			</div>
			<center>
				<button class="btn btn-primary"
					onclick="window.location.href='adicionaContato.html';">ADD</button>
			</center>
		</div>
	</div>
</body>
</html>