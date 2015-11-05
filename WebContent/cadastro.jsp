<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Cadastro</title>
	</head>
	<body>
		<h1>Cadastro</h1>
		<form action="CadastroServlet.do" method="POST">
			<!-- Formulário do Cadastro -->
			<form action="CadastrarServlet.do" method="POST">
				Usuário: <input type="text" name="usuario">
				Senha: <input type="password" name="senha">
				Re-senha: <input type="password" name="resenha">
				Nascimento: <input type="text" name="resenha">
				Gênero: 
				<select name="generos">
					<option value="masculino">Masculino</option>
					<option value="feminino">Feminino</option>
				</select>
				<input type="submit" value="Cadastrar">
		</form>
	</body>
</html>