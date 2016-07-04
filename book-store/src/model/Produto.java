package model;

public class Produto {
	
	private int id;
	private String titulo;
	private String autor;
	private Double preco;
	private int estoque;
	
	
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
}
