package br.ufpr.servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
		String dataNascimento = request.getParameter("dataNascimento");
		
		ContatoDao contatoDao = new ContatoDao();
		Contato contato = new Contato(nome, email, endereco, Calendar.getInstance());
		contatoDao.adiciona(contato);
		
		
		response.sendRedirect("index.jsp");
		
		//new ContatoDao().adiciona(contato);
		
		
	//	PrintWriter out = response.getWriter();
//		out.println("<html>");
//		out.println("<head><title>exemplo</title></head>");
//		out.println("<body>");
//		
//		out.println("<br>Nome: "+nome);
//		out.println("<br>E-Mail: "+email);
//		out.println("<br>Endereço: "+endereco);
//		out.println("<br>Data de Nascimento: "+dataNascimento);
//		
//		
//		out.println("</body>");
//		out.println("</html>");

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
