package model;

public class Item {
	private Produto produto;
	private int quantidade;
	private double subtotal;
	private double valorDesconto;
	
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
	public void setValorDesconto(double valorDesconto) {
		this.valorDesconto = valorDesconto;
	}
	public double getValorDesconto(){
		return valorDesconto;
	}
	public void adicionarQuantidade(){
		this.quantidade += 1;  
	}
	public void subtrairQuantidade(){
		this.quantidade -= 1;  
	}
	public void adicionarSubtotal(double valor){
		this.subtotal += valor;  
	}
	public void subtrairSubtotal(double valor){
		this.subtotal -= valor;  
	}
	public void subtrairDesconto(double valor){
		this.valorDesconto -= valor;  
	}
}