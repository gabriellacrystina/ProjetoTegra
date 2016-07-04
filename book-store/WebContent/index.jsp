<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Produto" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="book_store_stile.css">
		<script src="controle-compra.js"></script>
		<title>BookStore</title>
	</head>
	<body>
		<header>
			<div class="cabecalho">
				<h1>Bem vindo as Compras</h1>
			</div>
		</header>
		<form>
			<div class="meu-carrinho">
				<div class="carrinho">	
					<label id="meu-carrinho">Meu Carrinho</label></br>
					Itens: <label class="lbl-itens" id="qtde-itens">0</label></br>
					Total: <label class="lbl-total" id="total">150</label></br>
					<button class="btn" id="btn-finalizar-compra" onclick="validaCarrinho()">Finalizar Compras</button>
				</div>
			</div>
			<%
				List<Produto> produtos = (ArrayList<Produto>) session.getAttribute("listaProdutos");
			%>
			<table id="tbl-books">
			  <tr>
			    <th>Titulo</th>
			    <th>Autor</th> 
			    <th>Preço (R$)</th>
			    <th>Quantidade de Estoque</th>
			    <th>Comprar</th>
			  </tr>
			  <%
			  	for(Produto p: produtos){
		  		%>
		  			<tr class="livros">
						<td class="nome-livro"><%= p.getTitulo() %></td>
						<td class="nome-autor"><%= p.getAutor() %></center></td>
						<td class="preco"><%= p.getPreco() %></center></td>
						<td class="estoque"><%= p.getEstoque() %></center></td>
						<td><button class="btn" id="btn-comprar" onclick="validaEstoque()">Comprar</button></td>
					</tr>
		  		<% 
			  	}
			  %>
			  <!--   TESTE DE RECUPERACAO DE LISTA VINDA DO SERVLET.
				  <tr class="livros">
				    <td class="nome-livro">The Pragmatic Programmer: From Journeyman to Master</td>
				    <td class="nome-autor">Andrew Hunt & Dave Thomas</td> 
				    <td class="preco">40,00</td>
				    <td class="estoque">0</td>
				    <td><button class="btn" id="btn-comprar" onclick="validaEstoque()">Comprar</button></td>
				  </tr>
				  <tr>
				    <td>The Mythical Man-Month: Essays on Software Engineering</td>
				    <td>Frederick P. Brooks</td> 
				    <td>80,00</td>
				    <td>1</td>
				    <td><button class="btn" id="btn-comprar">Comprar</button></td>
				  </tr>
				  <tr>
				    <td>Expressões Regulares - Uma Abordagem Divertida</td>
				    <td>Aurelio Marinho Jargas</td> 
				    <td>20,00</td>
				    <td>13</td>
				    <td><button class="btn" id="btn-comprar">Comprar</button></td>
				  </tr>
				  <tr>
				    <td>Domain Driven Design: Tackling Complexity in the Heart of Software</td>
				    <td>Eric Evans</td> 
				    <td>120,00</td>
				    <td>42</td>
				    <td><button class="btn" id="btn-comprar">Comprar</button></td>
				  </tr>
				  <tr>
				    <td>Patterns of Enterprise Application Architecture</td>
				    <td>Martin FowIer</td> 
				    <td>32,00</td>
				    <td>42</td>
				    <td><button class="btn" id="btn-comprar">Comprar</button></td>
				  </tr>
				  <tr>
				    <td>Epigrams in Programming</td>
				    <td>Alan Perils</td> 
				    <td>31,00</td>
				    <td>0</td>
				    <td><button class="btn" id="btn-comprar">Comprar</button></td>
				  </tr>
				  <tr>
				    <td>Implementing Domain-Driven Design</td>
				    <td>Vaughn Vernon</td> 
				    <td>31,00</td>
				    <td>42</td>
				    <td><button class="btn" id="btn-comprar">Comprar</button></td>
				  </tr>
				  <tr>
				    <td>Dive Into HTML5</td>
				    <td>Mark Pilgrim</td> 
				    <td>22,00</td>
				    <td>42</td>
				    <td><button class="btn" id="btn-comprar">Comprar</button></td>
				  </tr>
				   <tr>
				    <td>Scalable Internet Architectures</td>
				    <td>Theo Schlossnagle</td> 
				    <td>18,00</td>
				    <td>4</td>
				    <td><button class="btn" id="btn-comprar">Comprar</button></td>
				  </tr>
				   <tr>
				    <td>Refactoring: Improving the Design of Existing Code</td>
				    <td>Martin Fowler</td> 
				    <td>33,00</td>
				    <td>2</td>
				    <td><button class="btn" id="btn-comprar">Comprar</button></td>
				  </tr>
				   <tr>
				    <td>Treinamento Em C</td>
				    <td>Victorine Viviane Mizrahi</td> 
				    <td>42,00</td>
				    <td>6</td>
				    <td><button class="btn" id="btn-comprar">Comprar</button></td>
				  </tr>
				   <tr>
				    <td>Algoritmos: Teoria e Prática</td>
				    <td>Thomas H. Cormen</td> 
				    <td>4,60</td>
				    <td>1</td>
				    <td><button class="btn" id="btn-comprar">Comprar</button></td>
				  </tr>
			  -->
			</table>
		</form>
	</body>
</html>