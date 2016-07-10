<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="book-store-style.css">
	</head>
	<body>
		
		<h2>Compra Finalizada com Sucesso!</h2>
		
		<h5>Voc� adquiriu o(s) livro(s):</h5>
		
		<c:forEach var="item" items="${listaItens}">
			<ul>
				<li class="titulo-livro">${item.getProduto().getTitulo()}</li>
			</ul>
		</c:forEach>
		
		<h5>Total: ${total} R$</h5>
		
		<h4>Volte Sempre!!</h4>
	</body>
</html>