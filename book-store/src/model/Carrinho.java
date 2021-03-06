package model;

import java.util.ArrayList;

public class Carrinho {
	
	private ArrayList<Item> listaItens;
	private double total;
	private String cupom;

	public ArrayList<Item> getListaItens() {
		return listaItens;
	}
	public void setListaItens(ArrayList<Item> listaItens) {
		this.listaItens = listaItens;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getCupom() {
		return cupom;
	}
	public void setCupom(String cupom) {
		this.cupom = cupom;
	}
	
	public boolean validaCupom(String cupom){
		if(cupom.equals("TrabalheNaTegra")){
			return true;
		}else{
			return false;
		}
	}
	/*Metodo que percorre os itens escolhidos e verifica 
	 * se o autor da promo��o est� contido em algum item na lista de livros Escolhidos*/
	public Item contemNaLista(){
		Item item = null;
		if(this.listaItens != null){
			for(Item i: this.listaItens){
				if(i.getProduto().getAutor().equals("Martin Fowler")){
					item = i;
				}
			}
			return item;
		}
		return null;
	}
	
	// Aplica o desconto
	public void calculaDesconto(Item item){
		if(item != null){
			item.setValorDesconto((item.getSubtotal() * 0.1));
			item.subtrairSubtotal(item.getValorDesconto());
			this.total -= item.getValorDesconto();
		}
	}
	
	public void calculaTotal(){
		double total = 0.0;
		if(this.listaItens != null){
			for(Item i : this.listaItens){
				total += i.getProduto().getPreco() * i.getQuantidade();
			}
			this.total = total;
		}
	}
}

 