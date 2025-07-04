<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%-- <c:url value="/alteraEmpresa" var="linkServletNovaEmpresa" /> --%>
<c:url value="/entrada" var="linkAlteraEmpresa" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="logout-parcial.jsp" />
	<form action="${linkAlteraEmpresa}" method="POST">
		<input type="hidden" name="id" value="${empresa.id}" />
		<input type="hidden" name="acao" value="AlteraEmpresa" />
		<label>
			Nome: <input type="text" name="nome" value="${empresa.nome}" />
		</label>
		<label>
			Data Abertura: <input type="text" name="data" value="<fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy"/>" />
		</label>
		<button type="submit">Cadastrar</button>
	</form>
</body>
</html>