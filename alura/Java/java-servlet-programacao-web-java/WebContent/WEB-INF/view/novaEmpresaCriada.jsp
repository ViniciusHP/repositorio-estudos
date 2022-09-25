<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%
	// Código java Scriptlet
	
	String nomeEmpresa = (String) request.getAttribute("empresa");
	System.out.println(nomeEmpresa);
	// No JSP existe uma variável chamada out
%> --%>
<html>
	<body>
		<%-- <p>Empresa <% out.println(nomeEmpresa); %> cadastrada com sucesso!</p> --%>
		<c:if test="${ not empty empresa }">
			<p>Empresa ${ empresa } cadastrada com sucesso!</p>
		</c:if>
		<c:if test="${ empty empresa }">
			<p>Nenhum empresa cadastrada!</p>
		</c:if>
	</body>
</html>
