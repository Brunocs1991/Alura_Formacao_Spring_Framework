<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.alura.gerenciador.model.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Java Standard Taglib</title>
	</head>
	<body>
		<c:if test="${not empty nomeEmpresa}">
			Empresa ${ nomeEmpresa } cadastrada com sucesso!
		</c:if>
		<br/>
		<br/>
		Lista de empresas: <br />
		<ul>
			<c:forEach items="${empresas}" var="empresa">
				<li>
					${empresa.nome } - <fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy"/>
					<a href="/gerenciador/removeEmpresa?id=${empresa.id}">Remove</a>
				</li>
			</c:forEach>
		</ul>		
	</body>
</html>