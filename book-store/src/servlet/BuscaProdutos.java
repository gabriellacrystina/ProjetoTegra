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
		Produto produto;
		double subtotal = 0, total=0;
		Integer indice, quantidade=0, qtdeLivros=0;
		Item itemEncontrado = null;
		
		//captura Lista de Produtos e LivrosEscolhidos da sessao.
		List<Produto> produtos = (ArrayList<Produto>) sessao.getAttribute("listaProdutos");
		ArrayList<Item> livrosEscolhidos = (ArrayList<Item>) sessao.getAttribute("listaItens");
		
		if(livrosEscolhidos == null){
			livrosEscolhidos = new ArrayList<Item>();
			sessao.setAttribute("listaItens", livrosEscolhidos);
		}
		
		/**Montando um item para adicionar em livrosEscolhidos.**/
		
		//Indice do livro
		indice = Integer.parseInt(request.getParameter("id-livro"));
		produto = produtos.get(indice);
		
		//Se a lista estiver vazia
		if(livrosEscolhidos.isEmpty()){
			//add item
			item.setProduto(produto);	
			
			quantidade = item.getQuantidade() + 1;
			item.setQuantidade(quantidade);
			
			subtotal = quantidade * produto.getPreco();
			item.setSubtotal(subtotal);

			livrosEscolhidos.add(item);
			
			produto.atualizaEstoqueVenda();
		}else{
			//Senao percorre a lista
			for(int i=0; i<livrosEscolhidos.size(); i++){
				//verifica se o item a ser adicionado j� existe na lista
				if(produto.getTitulo().equals(livrosEscolhidos.get(i).getProduto().getTitulo())){
					itemEncontrado = livrosEscolhidos.get(i);
				}
			}
			//item j� existe na lista?
			if(itemEncontrado != null){
				//atualiza a quantidade e o subtotal deste item
				itemEncontrado.adicionarQuantidade();
	
				itemEncontrado.adicionarSubtotal(produto.getPreco());
				
				produto.atualizaEstoqueVenda();
			}else{ 
				//adiciona um novo item na lista
				item.setProduto(produto);
				
				quantidade = item.getQuantidade() + 1;
				item.setQuantidade(quantidade);
				
				subtotal = quantidade * produto.getPreco();
				item.setSubtotal(subtotal);
				
				livrosEscolhidos.add(item);
				
				produto.atualizaEstoqueVenda();
			}	
		}
		
		//Total de livros e valor correspondente
		if( livrosEscolhidos != null){
			for(Item i: livrosEscolhidos){
				qtdeLivros = qtdeLivros + i.getQuantidade();
				total = total +  i.getProduto().getPreco() * i.getQuantidade();		
			}
		}
		sessao.setAttribute("qtdeLivros", qtdeLivros);
		sessao.setAttribute("total", total);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
