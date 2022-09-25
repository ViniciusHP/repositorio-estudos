<%@page import="br.com.alura.gerenciador.modelo.Empresa"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- Importamos a biblioteca do jstl, a partir do seu nome informado na uri, depois definimos uma prefixo,
Esse prefixo é adicionado na tag para indicar que a tag faz parte daquela biblioteca
 -->
<!-- 
Na Expression language (<%-- ${} --%>), é possivel acessar propriedades pelo nome dela, não pelo seu getter
 -->
<%-- <%
	List<Empresa> lista = (List<Empresa>) request.getAttribute("empresas"); 
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard Taglib</title>
</head>
<body>
	<c:if test="${ not empty empresa }">
		<p>Empresa ${ empresa } cadastrada com sucesso!</p>
	</c:if>
	<h2>Lista de empresas:</h2>
	<ul>
		<!-- Para referenciar a biblioteca, colocamos o prefixo dela seguido por dois pontos, depois o nome da tag desta biblioteca -->
		<c:forEach var="empresa" items="${empresas}">
			<li>
				${ empresa.nome } - <fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy - HH:mm:ss"/>
				<a href="/gerenciador/entrada?acao=MostraEmpresa&id=${empresa.id}">editar</a>
				<a href="/gerenciador/entrada?acao=RemovaEmpresa&id=${empresa.id}">remove</a>
			</li>
		</c:forEach>
	</ul>
	
	<%-- <ul>
		<%
			for(Empresa empresa: lista) {
		%>
			<li><%= empresa.getNome() %></li>
		<%
			}
		%>
	</ul> --%>
</body>
</html>