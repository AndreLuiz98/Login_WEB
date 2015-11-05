package br.edu.ifpb.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifpb.entidade.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet.do")
public class LoginServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		// Sessão
		HttpSession session = request.getSession();
		
		// Recuperar lista de usuários da sessão. Caso não exista ainda 
		// será recuperado null.
		List<Usuario> usuarios = (List<Usuario>) session.getAttribute(
				"usuarios");	
		
		if (usuarios != null && !usuarios.isEmpty()) {
			
			// Parâmetros passados pelo formulário de login.
			String nome = request.getParameter("nome");
			String senha = request.getParameter("senha");
			
			// Comparar o Login
			for (Usuario usuario: usuarios) {
				if (usuario.getNome().equals(nome)
						&& usuario.getSenha().equals(senha)){
					
					// Redireciona para a página de boas-vindas.
					RequestDispatcher rq = request.getRequestDispatcher(
							"boasvindas.jsp");
					rq.forward(request, response);
				}
			}
			
			// Redireciona para o cadastro caso o usuário não foi encontrado 
			// na lista de usuários.
			response.sendRedirect("cadastro.jsp");
			
		} else {
			
			// Redireciona para o cadastramento.
			response.sendRedirect("cadastro.jsp");
		}
	}
}
