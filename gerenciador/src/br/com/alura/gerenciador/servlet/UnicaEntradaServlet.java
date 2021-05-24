package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.acao.Acao;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramAcao = request.getParameter("acao");		
		HttpSession sessao = request.getSession();
		
		boolean usuarioNaoLogado = sessao.getAttribute("usuarioLogado") == null;
		boolean ehAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
		if(ehAcaoProtegida && usuarioNaoLogado) {
			response.sendRedirect("entrada?acao=LoginForm");
			return;
		}
				
		String nomeDaClasse = "br.com.alura.gerenciador.acao." + paramAcao;		
		String nomeJsp;
		
		try {			
			@SuppressWarnings("rawtypes")
			Class classe =Class.forName(nomeDaClasse); //Carregando a classe com o nomeDaClasse
			@SuppressWarnings("deprecation")
			Acao acao = (Acao) classe.newInstance(); 
			nomeJsp = acao.executa(request, response);			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException | IOException e) {			
			throw new ServletException(e);			
		}		
		
		String[] tipoEENdereco=nomeJsp.split(":");		
		if(tipoEENdereco[0].equals("forward")) {			
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEENdereco[1]);
			rd.forward(request, response);				
		}else {			
			response.sendRedirect(tipoEENdereco[1]);			
		}
	}
}
