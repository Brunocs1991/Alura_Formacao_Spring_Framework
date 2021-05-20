package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import br.com.alura.gerenciador.model.Empresa;
import br.com.alura.gerenciador.persistence.Banco;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NovaEmpresaServlet() {
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa");		
		String nomeEmpresa = request.getParameter("nome");
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		
		Banco banco = new Banco();		
		banco.adiciona(empresa);
		
		//Chamar o JSP
		RequestDispatcher rd =  request.getRequestDispatcher("/novaEmpresaCriada.jsp");
		request.setAttribute("nomeEmpresa", empresa.getNome());
		rd.forward(request, response);
	}
}
