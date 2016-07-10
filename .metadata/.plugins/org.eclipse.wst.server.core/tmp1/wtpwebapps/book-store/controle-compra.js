/**
 * Controle de Compra. Arquivo que valida dados do arquivo index.jsp
 */
//valida se carrinho contém itens!!
function validaCarrinho(){                     
	var qtdeItens = document.getElementById("qtde-itens").textContent;
	
	if(qtdeItens == 0){
		alert("Não há itens no carrinho!!");
		return false;
	}
	return true;
}	

//verifica se o input do cupom foi informado
function validarCupom(){
	var cupom = document.getElementById("cupom").value;
	
	if(cupom == ""){
		alert("Informe o cupom!!");
		return false;
	}
	return true;
}
