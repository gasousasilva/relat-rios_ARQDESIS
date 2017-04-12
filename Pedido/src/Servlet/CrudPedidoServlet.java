package Servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ItemPedido_Beans.ItemPedido;
import Service.PedidoService;
//import model.ItemPedido;
//import service.PedidoService;

@WebServlet("/CrudPedido")
public class CrudPedidoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id_pedido");
		String pedido = request.getParameter("nome_pedido");
		String produto = request.getParameter("nome_produto");
		String qtde = request.getParameter("qtde_produto");
		String valor = request.getParameter("valor_produto");

		
		
		// instanciar o javabean
		ItemPedido iPedido = new ItemPedido();
		Integer idFinal = Integer.parseInt(id);
		Integer quantidade = Integer.parseInt(qtde);
		iPedido.setId(idFinal);
		iPedido.setPedido(pedido);
		iPedido.setProduto(produto);
		iPedido.setQtde(quantidade); 	
		iPedido.setValor(valor);
		
		// instanciar o service
		PedidoService service = new PedidoService();
			
		
		String oQueFazer = request.getParameter("oQueFazer");
		switch (oQueFazer){
		case "Cadastrar":
		service.criar(iPedido);
		request.setAttribute("Pedidos", iPedido);
		RequestDispatcher view = request.getRequestDispatcher("Cadastrar.jsp");
		view.forward(request, response);
		break;
		case "Consultar":
			service.carregar(iPedido);
			request.setAttribute("Pedidos", iPedido);
			RequestDispatcher view3 = request.getRequestDispatcher("Consultar.jsp");
			view3.forward(request, response);
		break;
		case "Alterar":
			service.atualizar(iPedido);
			request.setAttribute("Pedidos", iPedido);
			RequestDispatcher view1 = request.getRequestDispatcher("Alterar.jsp");
			view1.forward(request, response);
		break;
		case "Excluir":
			service.excluir(iPedido);
			request.setAttribute("Pedidos", iPedido);
			RequestDispatcher view2 = request.getRequestDispatcher("Excluir.jsp");
			view2.forward(request, response);
		break;
		}

		
	}
}