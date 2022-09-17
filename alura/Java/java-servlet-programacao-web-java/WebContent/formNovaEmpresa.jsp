<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/novaEmpresa" var="linkServletNovaEmpresa" /> <!-- Usando para pegar o contexto da aplicação dinamicamente -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="${linkServletNovaEmpresa}" method="POST">
		<label>
			Nome: <input type="text" name="nome" />
		</label>
		<label>
			Data Abertura: <input type="text" name="data" />
		</label>
		<button type="submit">Cadastrar</button>
	</form>
</body>
</html>