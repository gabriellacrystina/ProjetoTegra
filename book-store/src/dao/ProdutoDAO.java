package dao;

import java.util.ArrayList;
import java.util.List;

import model.Produto;

/**
 * Produto(Data Object Access)
 * 
 * Classe que simula acesso ao banco de dados
 */

public class ProdutoDAO {
	
	private final static List<Produto> listaProdutos = new ArrayList<>();
	
	static{
		adicionaProduto(new Produto("The Pragmatic Programmer: From Journeyman to Master", "Andrew Hunt & Dave Thomas", 40.00, 12));
		adicionaProduto(new Produto("The Mythical Man-Month: Essays on Software Engineering", "Frederick P. Brooks", 80.00, 1));
		adicionaProduto(new Produto("Express�es Regulares - Uma Abordagem Divertida", "Aurelio Marinho Jargas",20.00 ,13 ));
		adicionaProduto(new Produto("Domain Driven Design: Tackling Complexity in the Heart of Software", "Eric Evans", 120.00, 42));
		adicionaProduto(new Produto("Patterns of Enterprise Application Architecture", "Martin FowIer", 32.00, 42));
		adicionaProduto(new Produto("Epigrams in Programming", "Alan Perils", 31.00, 0));
		adicionaProduto(new Produto("Implementing Domain-Driven Design", "Vaughn Vernon", 31.00, 42));
		adicionaProduto(new Produto("Dive Into HTML5", "Mark Pilgrim", 22.00, 42));
		adicionaProduto(new Produto("Scalable Internet Architectures", "Theo Schlossnagle", 18.00, 4));
		adicionaProduto(new Produto("Refactoring: Improving the Design of Existing Code", "Martin Fowler", 33.00, 2));
		adicionaProduto(new Produto("Treinamento Em C", "Victorine Viviane Mizrahi", 42.00, 6));
		adicionaProduto(new Produto("Algoritmos: Teoria e Pr�tica", "Thomas H. Cormen", 4.60, 1));
	}
	
	
	//Metodo que gera id autom�tico e adiciona um produto na lista.
	private static void adicionaProduto(Produto produto){
		int id = listaProdutos.size() + 1;
		produto.setId(id);
		listaProdutos.add(produto);
	}
	
	public List<Produto> getListaProdutos(){
		return listaProdutos;
	}
}