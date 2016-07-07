package model;

public class Produto {
	
	private int id;
	private String titulo;
	private String autor;
	private Double preco;
	private int estoque;
	
	public Produto(int id) {
		super();
		this.id = id;
	}

	public Produto(String titulo, String autor, Double preco, int estoque) {
		this.titulo = titulo;
		this.autor = autor;
		this.preco = preco;
		this.estoque = estoque;
	}

	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public Double getPreco() {
		return preco;
	}
	
	public int getEstoque() {
		return estoque;
	}
	
	public void atualizaEstoqueVenda(){
		this.estoque -= 1;
	}
	
	public void atualizaEstoqueDevolucao(){
		this.estoque += 1;
	}
	
	public void cupomDesconto(){
		this.preco = preco - (preco * 0.1);
	}
}
