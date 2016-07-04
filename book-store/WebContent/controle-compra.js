/**
 * Controle de Compra. Arquivo que valida dados do arquivo index.jsp
 */

function validaCarrinho(){                     
	var qtdeItens = document.getElementById("qtde-itens").textContent;
	
	if(qtdeItens == 0){
		alert("Não há itens no carrinho!!");
	}
}	

function validaEstoque(){
	var trLivros = document.getElementsByClassName("livros");
	
	for(var i=0; i < trLivros.length; i++ ){
		var livro = trLivros[i];
	
		var estoque = livro.getElementsByClassName("estoque");
		
		if(estoque == 0){
			alert("Produto indisponível em estoque!!");
		}
	}
	
}