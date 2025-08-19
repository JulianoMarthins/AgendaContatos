package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.JavaBeans;
import model.DAO;


import java.io.IOException;


@WebServlet(urlPatterns = { "/Controller", "/main", "/insert" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	JavaBeans contato = new JavaBeans();
	DAO dao = new DAO();
	

	public Controller() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		if (action.equals("/main")) {
			contatos(request, response);
		}
		else if (action.equals("/insert")) {
			novoContato(request, response);
		}
		else {
			response.sendRedirect("index.html");
		}
	}

	// Lista de contatos
	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.sendRedirect("agenda.jsp");
	}
	
	// Inserir novo contato.
	protected void novoContato(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {		
		
		// Criando objeto com os dados do usuário
		contato.setNome(request.getParameter("nome"));			
		contato.setFone(request.getParameter("fone"));
		contato.setCpf(request.getParameter("cpf"));
		contato.setRg(request.getParameter("rg"));
		
		// Insere o objeto a classe DAO
		dao.inserirContato(contato);
		
		response.sendRedirect("main");
		
	}

}
