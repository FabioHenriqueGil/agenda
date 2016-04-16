package br.ufpr.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.ufpr.dao.ContatoDao;
import br.ufpr.modelo.Contato;

/**
 * Servlet implementation class AddContatoServlet
 */
@WebServlet("/adicionaContato")
public class AddContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddContatoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String dataNascimentoTXT = request.getParameter("dataNascimento");
		Calendar dataNascimento = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			dataNascimento.setTime(format.parse(dataNascimentoTXT));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			throw new RuntimeException();
		}
		ContatoDao contatoDao = new ContatoDao();
		Contato contato = new Contato(nome, email, endereco, dataNascimento);
		contatoDao.adiciona(contato);
		
		response.sendRedirect("index.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
