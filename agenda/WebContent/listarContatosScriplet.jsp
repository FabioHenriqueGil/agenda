<%@page import="org.apache.jasper.compiler.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.ufpr.modelo.Contato"%>
<%@page import="java.util.List"%>
<%@page import="br.ufpr.dao.ContatoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Contatos</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js">
	
</script>
</head>
<body>
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
				<jsp:useBean id="contatoDao" class="br.ufpr.dao.ContatoDao"/>
				<%
			
					//ContatoDao contatoDao = new ContatoDao();
					List<Contato> lista = contatoDao.getLista();

					for (Contato c : lista) {
				%>
				<tr>
					<td><%=c.getId()%></td>
					<td><%=c.getNome()%></td>
					<td><%=c.getEmail()%></td>
					<td><%=c.getEndereco()%></td>
					<td><%=new SimpleDateFormat("dd/MM/yyyy").format(c.getDataNascimento().getTime()) %></td>
				</tr>
				<%
					}
				%>
			</table>
		</div>
	</div>

</body>
</html>