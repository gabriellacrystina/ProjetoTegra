package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Carrinho;
import model.Item;
import model.Produto;

/**
 * Servlet implementation class FinalizarCompra
 */
@WebServlet("/FinalizarCompra")
public class FinalizarCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalizarCompra() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Carrinho carrinho = new Carrinho();
		Produto produto = null;
		double total = 0;
		Item itemDeDesconto = null;
		String cupom = null, resultado=null;
		
		ArrayList<Item> livrosEscolhidos = (ArrayList<Item>) sessao.getAttribute("listaItens");
		cupom = (String)request.getParameter("cupom");
		total = (Double) sessao.getAttribute("total");
		
		

		carrinho.setListaItens(livrosEscolhidos);
		carrinho.setTotal(total);
		
		//verifica��o do cupom
		if(cupom.isEmpty() || cupom.equals(null)){
			carrinho.setCupom(null);
		}else{
			if(carrinho.validaCupom(cupom)){
				carrinho.setCupom(cupom);
				itemDeDesconto = carrinho.contemNaLista();
				if(itemDeDesconto != null){
					carrinho.calculaDesconto(itemDeDesconto);
					resultado = "Parab�ns voc� acaba de ganhar 10% de desconto no(s) livros de Martin Fowler!!";
				}else{
					resultado = "Cupom v�lido apenas pra livros do autor Martin Fowler!!";
				}
			}else{
				resultado = "Cupom inv�lido!!";
			}		
		}

		if(resultado != null){
			sessao.setAttribute("resultado", resultado);
		}
		
		total = carrinho.getTotal();
		sessao.setAttribute("total", total);
		sessao.setAttribute("carrinho", carrinho);
		
		request.getRequestDispatcher("meuCarrinho.jsp").forward(request, response);
	}
}
