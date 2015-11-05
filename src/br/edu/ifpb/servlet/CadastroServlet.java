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
	 * M�todo POST para cadastro de usu�rio.
	 * Os valores dos usu�rio cadastrados ser�o adicionados a sess�o.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, 
	 * 		HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		// Recuperar lista de usu�rios da sess�o. Caso n�o exista ainda 
		// ser� recuperado null.
		List<Usuario> usuarios = (List<Usuario>) session.getAttribute(
				"usuarios");
		
		// Criar a lista de usu�rios caso n�o exista.
		if (usuarios == null) {			
			usuarios = new ArrayList<Usuario>();		
		} 
		
		// Par�metros passados pelo formul�rio de login.
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha"); 
		String resenha = request.getParameter("resenha");
		String nascimento = request.getParameter("nascimento");
		
		// Campo select com os valores de g�nero.
		String genero = request.getParameter("generos");
		
		// Entidade usu�rio.
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setSenha(senha);
		usuario.setNascimento(nascimento);
		usuario.setGenero(genero);
		
		// Adicionando usu�rio a lista de usu�rios.
		usuarios.add(usuario);
		
		// Atualizando a sess�o.
		session.setAttribute("usuarios", usuarios);
		
		response.sendRedirect("index.html");
	}
}
