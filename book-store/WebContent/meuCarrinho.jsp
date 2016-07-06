<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Item" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="book_store_stile.css">
		<title>Carrinho</title>
	</head>
	<body>
			<div class="meu-carrinho">
				<div class="carrinho">	
					<h1>Colocar alguma coisa aqui</h1>
				</div>
			</div>
	
			<table id="tbl-books">
			  <tr>
			    <th>Titulo</th>
			    <th>Autor</th> 
			    <th>Pre�o (R$)</th>
			    <th>Quantidade</th>
			    <th>Subtotal (R$)</th>
			    <th>Remover</th>
			  </tr>
			  <%
			  	
			  	ArrayList<Item> livrosEscolhidos = (ArrayList<Item>)session.getAttribute("listaItens");
				for(Item i: livrosEscolhidos){
		  		%>
		  			<tr class="livros">
						<td class="nome-livro"><%= i.getProduto().getTitulo()%></td>
						<td class="nome-autor"><%= i.getProduto().getAutor()%></td>
						<td class="preco"><%= i.getProduto().getPreco() %></td>
						<td class="quantidade"><%= i.getQuantidade()%></td>
						<td class="subtotal"><%= i.getSubtotal() %></td>
						<td>
							<form action="MeuCarrinho" method="post">
								<input type="hidden" name="id-item" value="<%=i.getId()%>">
								<button class="btn btn-comprar" type="submit">Remover</button>
							</form>
						</td>
					</tr>
		  		<% 
			  	}
			  %>
			</table>
			<br><a href="index.jsp">Voltar</a>
	</body>
</html>