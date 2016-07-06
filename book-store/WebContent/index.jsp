<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Produto" %>
<%@ page import="model.Item" %>
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
		<div class="cabecalho">
			<h1>Bem vindo as Compras</h1>
		</div>
		<%
			//Retirar esta lógica daqui!!
			ArrayList<Item> livrosEscolhidos = (ArrayList<Item>)session.getAttribute("listaItens");
			int qtde=0;
			double total=0;
			if( livrosEscolhidos != null){
				for(Item i: livrosEscolhidos){
					qtde = qtde + i.getQuantidade();
					total = total +  i.getProduto().getPreco() * i.getQuantidade();
					
				}	
			}
		%>
			<div class="meu-carrinho">
				<div class="carrinho">	
					<label id="meu-carrinho">Meu Carrinho</label><br>
					<form action="Carrinho" method="post">	
						Itens: <output class="lbl-itens" id="qtde-itens" name="quantidade-itens"><%=qtde%></output><br>
						Total: <output class="lbl-total" id="total" name="total-itens"><%=total%></output><br>
						<button type="submit" class="btn" id="btn-finalizar-compra">Finalizar Compras</button>
					</form>
				</div>
			</div>
			
			<table id="tbl-books">
			  <tr>
			    <th>Titulo</th>
			    <th>Autor</th> 
			    <th>Preço (R$)</th>
			    <th>Quantidade de Estoque</th>
			    <th>Comprar</th>
			  </tr>
			  <%
				List<Produto> produtos = (ArrayList<Produto>)session.getAttribute("listaProdutos");
			  	for(Produto p: produtos){
		  		%>
		  			<tr class="livros">
						<td class="nome-livro"><%= p.getTitulo() %></td>
						<td class="nome-autor"><%= p.getAutor() %></td>
						<td class="preco"><%= p.getPreco() %></td>
						<td class="estoque"><%= p.getEstoque() %></td>
						<td>
							<form action="Produtos" method="post" name="produtos" >
								<input type="hidden" name="id-livro" value="<%=p.getId()%>">
								<button class="btn btn-comprar" type="submit">Comprar</button>
							</form>
							
						</td>
					</tr>
		  		<% 
			  	}
			  %>
			</table>
		</body>
</html>