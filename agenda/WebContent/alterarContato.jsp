<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.ufpr.dao.ContatoDao"%>
<%@page import="br.ufpr.modelo.Contato"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Altera Contato</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js">
	
</script>
<body>
	<jsp:useBean id="contatoDao" class="br.ufpr.dao.ContatoDao" />
	<jsp:useBean id="contato" class="br.ufpr.modelo.Contato" />

	<%
		String id = request.getParameter("id");
		contato = contatoDao.buscaContato(Long.parseLong(id));
	%>

	<form role="form" action="alteraContatoServlet?id=<%=contato.getId() %>" method="POST">
		<div class="container">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<center>Alterar</center>
				</div>
				<div class="panel-body">
					<div class="form-group">
						<label for="nome">Nome:</label> <input type="nome"
							class="form-control" name="nome" value="<%=contato.getNome()%>">
					</div>
					<div class="form-group">
						<label for="email">E_Mail:</label> <input type="email"
							class="form-control" name="email" value="<%=contato.getEmail()%>">
					</div>
					<div class="form-group">
						<label for="endereco">Endereço:</label> <input type="endereco"
							class="form-control" name="endereco"
							value="<%=contato.getEndereco()%>">
					</div>
					<div class="form-group">
						<label for="dataNascimento">Data de Nascimento:</label> <input
							type="date" class="form-control" name="dataNascimento"
							value="<%=new SimpleDateFormat("dd/MM/yyyy").format(contato.getDataNascimento().getTime())%>">
					</div>
					<button type="submit" class="btn btn-primary">Alterar</button>
					<button type="button" class="btn btn-primary"
						onclick="window.location.href='index.jsp';">Cancelar</button>
				</div>
			</div>
		</div>
	</form>
</body>
</html>