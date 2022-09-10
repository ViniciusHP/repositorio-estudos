<%
	// Código java
	String nomeEmpresa = "Alura";
	System.out.println(nomeEmpresa);
	// No JSP existe uma variável chamada out
%>
<html>
	<body>
		<p>Empresa <% out.println(nomeEmpresa); %> cadastrada com sucesso!</p>
		<p>Empresa <%= nomeEmpresa %> cadastrada com sucesso!</p>
	</body>
</html>