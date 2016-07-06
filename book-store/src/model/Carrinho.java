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
	public boolean validaCupom(){
		if(this.cupom.equals("TrabalheNaTegra")){
			return true;
		}else{
			return false;
		}
	}
}