<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <c:url value="/novaEmpresa" var="linkServletNovaEmpresa" /> --%> <!-- Usando para pegar o contexto da aplicação dinamicamente -->
<c:url value="/entrada" var="linkLogin" /> <!-- Usando para pegar o contexto da aplicação dinamicamente -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="${linkLogin}" method="POST">
		<input type="hidden" name="acao" value="Login" />
		<label>
			Login: <input type="text" name="login" />
		</label>
		<label>
			Senha: <input type="password" name="senha" />
		</label>
		<button type="submit">Enviar</button>
	</form>
</body>
</html>