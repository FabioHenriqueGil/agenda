<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<script src="../js/bootstrap.min.js">
	
</script>
</head>
<body><form action="mostraIdade.jsp">
	<div class="container">
		<div class="panel panel-primary">
		<div class="panel-heading">
				<center>Qual é sua Idade?</center>
			</div>
			<div class="panel-body">
				<div class="form-group">
					<label for="nome">Nome:</label> <input type="nome"
						class="form-control" name="nome">
				</div>
				<div class="form-group">
					<label for="iadde">Idade:</label> <input type="idade"
						class="form-control" name="idade">
				</div>
				<button type="submit" class="btn btn-primary">Gravar</button>
			</div>
		</div>
	</div>
</form>

</body>
</html>