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
 * Classe responsavel pelo controle do uso do cupom.
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
		
		request.getRequestDispatcher("ConcluirCompra.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Carrinho carrinho = new Carrinho();
		Item item = null;
		String cupom = null, resultado=null;
		
		ArrayList<Item> livrosEscolhidos = (ArrayList<Item>) sessao.getAttribute("listaItens");
		cupom = (String)request.getParameter("cupom");
		
		
		if(livrosEscolhidos != null){
			carrinho.setListaItens(livrosEscolhidos);
			carrinho.calculaTotal();
			
			//verifica��o do cupom
			if(cupom.isEmpty() || cupom.equals(null)){
				carrinho.setCupom(null);
			}else{
				if(carrinho.validaCupom(cupom)){
					carrinho.setCupom(cupom);
					item = carrinho.contemNaLista();
					if(item != null){
						if(item.getValorDesconto() == 0.0){//este item j� sofreu algum desconto?
							carrinho.calculaDesconto(item);
							resultado = "Parab�ns voc� acaba de ganhar 10% de desconto no(s) livros de Martin Fowler!!";
						}else{
							//se o item possui valor de desconto, significa que o cupom j� foi utilizado para este item.
							resultado = "Cupom j� foi utilizado!";
						}
					}else{
						resultado = "Cupom v�lido apenas pra livros do autor Martin Fowler!!";
					}
				}else{
					resultado = "Cupom inv�lido!!";
				}		
			}
		}else{
			resultado = "Carrinho nao possu itens!!";
		}
		
		if(resultado != null){
			sessao.setAttribute("resultado", resultado);
		}
		
		sessao.setAttribute("total", carrinho.getTotal());
		sessao.setAttribute("carrinho", carrinho);
		
		request.getRequestDispatcher("meuCarrinho.jsp").forward(request, response);
	}
}
