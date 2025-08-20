package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;

import java.util.ArrayList;

import model.JavaBeans;
import model.DAO;

import java.io.IOException;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/excluir", "/update" })

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
		} else if (action.equals("/insert")) {
			novoContato(request, response);
		} else if (action.equals("/select")) {
			listarContato(request, response);
		} else if (action.equals("/update")) {
			editarContato(request, response);
		} else if (action.equals("/excluir")) {
			excluirContato(request, response);
		}

		else {
			response.sendRedirect("index.html");
		}
	}

	// Listar contatos
	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<JavaBeans> lista = dao.listarContatos();

		request.setAttribute("contatos", lista);

		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response);
	}

	// Inserir novo contato ao banco de dados.
	protected void novoContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setCpf(request.getParameter("cpf"));
		contato.setRg(request.getParameter("rg"));

		dao.inserirContato(contato);

		response.sendRedirect("main");

	}

	// Edição de contatos
	protected void listarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idContato = request.getParameter("idCliente");
		contato.setIdCliente(idContato);

		dao.selecionarContato(contato);

		request.setAttribute("idCliente", contato.getIdCliente());
		request.setAttribute("nome", contato.getNome());
		request.setAttribute("fone", contato.getFone());
		request.setAttribute("cpf", contato.getCpf());
		request.setAttribute("rg", contato.getRg());

		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);

	}

	// Editar o contato
	protected void editarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contato.setIdCliente(request.getParameter("idCliente"));
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setCpf(request.getParameter("cpf"));
		contato.setRg(request.getParameter("rg"));
		
		dao.alterarContato(contato);
		
		response.sendRedirect("main");
	}

	// Exclusão de contatos
	protected void excluirContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idContato = request.getParameter("idCliente");
		System.out.println("botão de exclusão.");
		System.out.println(idContato);
	}

	public void teste() {
		System.out.println("ID: " + contato.getIdCliente());
		System.out.println("Nome: " + contato.getNome());
		System.out.println("Telefone: " + contato.getFone());
		System.out.println("CPF: " + contato.getCpf());
		System.out.println("RG: " + contato.getRg());
	}

}
