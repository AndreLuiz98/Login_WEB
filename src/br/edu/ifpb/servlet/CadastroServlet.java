package br.edu.ifpb.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifpb.entidade.Usuario;

/**
 * Servlet implementation class CadastroServlet
 */
@WebServlet("/CadastroServlet.do")
public class CadastroServlet extends HttpServlet {

	/**
	 * Método POST para cadastro de usuário.
	 * Os valores dos usuário cadastrados serão adicionados a sessão.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, 
	 * 		HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		// Recuperar lista de usuários da sessão. Caso não exista ainda 
		// será recuperado null.
		List<Usuario> usuarios = (List<Usuario>) session.getAttribute(
				"usuarios");
		
		// Criar a lista de usuários caso não exista.
		if (usuarios == null) {			
			usuarios = new ArrayList<Usuario>();		
		} 
		
		// Parâmetros passados pelo formulário de login.
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha"); 
		String resenha = request.getParameter("resenha");
		String nascimento = request.getParameter("nascimento");
		
		// Campo select com os valores de gênero.
		String genero = request.getParameter("generos");
		
		// Entidade usuário.
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setSenha(senha);
		usuario.setNascimento(nascimento);
		usuario.setGenero(genero);
		
		// Adicionando usuário a lista de usuários.
		usuarios.add(usuario);
		
		// Atualizando a sessão.
		session.setAttribute("usuarios", usuarios);
		
		response.sendRedirect("index.html");
	}
}
