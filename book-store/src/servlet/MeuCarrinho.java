package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Item;
import model.Produto;

/**
 * Servlet implementation class MeuCarrinho
 */
@WebServlet("/MeuCarrinho")
public class MeuCarrinho extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MeuCarrinho() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("meuCarrinho.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		Produto produto = null;
		Item item = null;
		int indice = 0;	
		
		ArrayList<Item> itensEscolhidos = (ArrayList<Item>) sessao.getAttribute("listaItens");
		double total = (Double)sessao.getAttribute("total");
		int  qtdeLivros = (int)sessao.getAttribute("qtdeLivros");
				
		//Recebe o indice do livro
		indice = Integer.parseInt(request.getParameter("id-livro"));
		
		//Removendo livro do Carrinho
		for(int i=0;i< itensEscolhidos.size(); i++){
			if(indice == itensEscolhidos.get(i).getProduto().getId()){
				produto = itensEscolhidos.get(i).getProduto();
				item = itensEscolhidos.get(i);
			}
		}
		
		//Verificar se este � um item com desconto
		if(item.getDesconto() > 0.0){
			double descontoUnitario = (item.getDesconto()/item.getQuantidade());
			item.subtrairSubtotal((produto.getPreco() - descontoUnitario));
			item.subtrairDesconto(descontoUnitario);
			total -= produto.getPreco() - descontoUnitario;
		}else{
			item.subtrairSubtotal(produto.getPreco());
			total -= produto.getPreco();
		}
		
		//reduzir a quantidade
		item.subtrairQuantidade();

		produto.atualizaEstoqueDevolucao();
		qtdeLivros--;
		
		
		if(item.getQuantidade() == 0){
			itensEscolhidos.remove(item);
		}
		
		//Atualizando qtdeLivros adquiridos e o total;
		sessao.setAttribute("qtdeLivros", qtdeLivros);
		sessao.setAttribute("total", total);
	
		request.getRequestDispatcher("meuCarrinho.jsp").forward(request, response);
	}
}
