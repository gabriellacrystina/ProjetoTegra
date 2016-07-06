package model;

public class Item {
	private Produto produto;
	private int quantidade;
	private double subtotal;
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public void addQuantidade(){
		this.quantidade += 1;  
	}
	public void addSubtotal(double novoSubtotal){
		this.subtotal = novoSubtotal;
	}

}