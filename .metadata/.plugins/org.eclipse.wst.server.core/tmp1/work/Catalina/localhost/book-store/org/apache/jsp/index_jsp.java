/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.35
 * Generated at: 2016-07-05 18:26:28 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Produto;
import model.Item;
import java.util.ArrayList;
import java.util.List;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.ArrayList");
    _jspx_imports_classes.add("model.Produto");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("model.Item");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"book_store_stile.css\">\r\n");
      out.write("\t\t<script src=\"controle-compra.js\"></script>\r\n");
      out.write("\t\t<title>BookStore</title>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t<div class=\"cabecalho\">\r\n");
      out.write("\t\t\t<h1>Bem vindo as Compras</h1>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t");

			//Retirar esta lógica daqui!!
			ArrayList<Item> livrosEscolhidos = (ArrayList<Item>)session.getAttribute("listaItens");
			int qtde=0;
			double total=0;
			if( livrosEscolhidos != null){
				for(Item i: livrosEscolhidos){
					qtde = qtde + i.getQuantidade();
					total = total +  i.getProduto().getPreco() * i.getQuantidade();
					
				}	
			}
		
      out.write("\r\n");
      out.write("\t\t\t<div class=\"meu-carrinho\">\r\n");
      out.write("\t\t\t\t<div class=\"carrinho\">\t\r\n");
      out.write("\t\t\t\t\t<label id=\"meu-carrinho\">Meu Carrinho</label><br>\r\n");
      out.write("\t\t\t\t\tItens: <label class=\"lbl-itens\" id=\"qtde-itens\"/>");
      out.print(qtde);
      out.write("<br>\r\n");
      out.write("\t\t\t\t\tTotal: <label class=\"lbl-total\" id=\"total\" />");
      out.print(total);
      out.write("<br>\r\n");
      out.write("\t\t\t\t\t<button class=\"btn\" id=\"btn-finalizar-compra\" onclick=\"validaCarrinho()\">Finalizar Compras</button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<table id=\"tbl-books\">\r\n");
      out.write("\t\t\t  <tr>\r\n");
      out.write("\t\t\t    <th>Titulo</th>\r\n");
      out.write("\t\t\t    <th>Autor</th> \r\n");
      out.write("\t\t\t    <th>Preço (R$)</th>\r\n");
      out.write("\t\t\t    <th>Quantidade de Estoque</th>\r\n");
      out.write("\t\t\t    <th>Comprar</th>\r\n");
      out.write("\t\t\t  </tr>\r\n");
      out.write("\t\t\t  ");

				List<Produto> produtos = (ArrayList<Produto>)session.getAttribute("listaProdutos");
			  	for(Produto p: produtos){
		  		
      out.write("\r\n");
      out.write("\t\t  \t\t\t<tr class=\"livros\">\r\n");
      out.write("\t\t\t\t\t\t<td class=\"nome-livro\">");
      out.print( p.getTitulo() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"nome-autor\">");
      out.print( p.getAutor() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"preco\">");
      out.print( p.getPreco() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"estoque\">");
      out.print( p.getEstoque() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<form action=\"Produtos\" method=\"post\" name=\"produtos\" >\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"id-livro\" value=\"");
      out.print(p.getId());
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<button class=\"btn btn-comprar\" type=\"submit\" onclick=\"validaEstoque\">Comprar</button>\r\n");
      out.write("\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t  \t\t");
 
			  	}
			  
      out.write("\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
