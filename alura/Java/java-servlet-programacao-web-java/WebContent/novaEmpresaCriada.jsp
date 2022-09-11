<%-- <%
	// Código java Scriptlet
	
	String nomeEmpresa = (String) request.getAttribute("empresa");
	System.out.println(nomeEmpresa);
	// No JSP existe uma variável chamada out
%> --%>
<html>
	<body>
		<%-- <p>Empresa <% out.println(nomeEmpresa); %> cadastrada com sucesso!</p> --%>
		<p>Empresa ${ empresa } cadastrada com sucesso!</p>
	</body>
</html>
