package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import model.Carrinho;
import model.Item;
import model.Produto;
import dao.ProdutoDAO;

/**
 * Servlet implementation class BuscaProdutos
 */
@WebServlet("/Produtos")
public class BuscaProdutos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscaProdutos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		
		//Gerando lista estatica.
		List<Produto> produtos = new ProdutoDAO().getListaProdutos();
		
		//colocando na sessao a lista de produtos
		sessao.setAttribute("listaProdutos", produtos);
		
		//redirecionar pro index.
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession sessao = request.getSession();
		Item item = new Item();
		
		//captura Lista de Produtos e LivrosEscolhidos da sessao.
		List<Produto> produtos = (ArrayList<Produto>) sessao.getAttribute("listaProdutos");
		ArrayList<Item> livrosEscolhidos = (ArrayList<Item>) sessao.getAttribute("listaItens");
		
		if(livrosEscolhidos == null){
			livrosEscolhidos = new ArrayList<Item>();
			sessao.setAttribute("listaItens", livrosEscolhidos);
		}
		
		Produto produto;
		Integer indice, quantidade=0;
		Item itemEncontrado = null;
		
		//**Montando um item para adicionar em livrosEscolhidos.
		
		//Recebe o indice do livro;
		indice = Integer.parseInt(request.getParameter("id-livro"));
		produto = produtos.get(indice);
		
		//Se a lista estiver vazia
		if(livrosEscolhidos.isEmpty()){
			//add item
			item.setProduto(produto);	
			
			quantidade = item.getQuantidade() + 1;
			item.setQuantidade(quantidade);

			System.out.println(" 1.LISTA ESTA VAZIA -> ADD O PRIMEIRO ITEM - Titulo do livro: " 
			+ produto.getTitulo() + " Quantidade: " + quantidade);
			
			livrosEscolhidos.add(item);
		}else{
			
			System.out.println("2.LISTA NAO ESTA VAZIA PERCORRENDO A LISTA PARA VERIFICAR ITENS ESCOLHIDOS");
			//Senao percorre a lista
			System.out.println("Apresentando lista de livros escolhidos: ");
			for(int i=0; i<livrosEscolhidos.size(); i++){
				System.out.println("index: " + i + " -> Item: " + livrosEscolhidos.get(i).getProduto().getTitulo());
				//verifica se o item a ser adicionado j� existe na lista
				System.out.println("Compara itens: " + produto.getTitulo() +  " == ou != " + livrosEscolhidos.get(i).getProduto().getTitulo());
				if(produto.getTitulo().equals(livrosEscolhidos.get(i).getProduto().getTitulo())){
					//Se sim guarda o item;
					itemEncontrado = livrosEscolhidos.get(i);
				}
			}
			if(itemEncontrado != null){
				System.out.println("� IGUAL!!"); 
				System.out.println("Quantidade deste item-> ANTES: " + itemEncontrado.getQuantidade());
				//atualiza a quuantidade
				quantidade = itemEncontrado.getQuantidade() + 1;
				itemEncontrado.setQuantidade(quantidade);
				System.out.println("Quantidade desse item-> DEPOIS: " + itemEncontrado.getQuantidade());
			}else{
				System.out.println("� DIFERENTE!!"); 
				item.setProduto(produto);	
				
				quantidade = item.getQuantidade() + 1;
				item.setQuantidade(quantidade);

				System.out.println("Adiciona o novo item no final da lista!!");
				
				livrosEscolhidos.add(item);	
			}
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
