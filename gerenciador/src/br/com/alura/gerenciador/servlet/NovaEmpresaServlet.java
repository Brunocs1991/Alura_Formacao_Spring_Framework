package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.DataFormatException;

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

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa");
		String nomeEmpresa = request.getParameter("nome");
		String paramDataAbertura = request.getParameter("data");

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Date dataAbertura = null;
		try {
			dataAbertura = sdf.parse(paramDataAbertura);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}

		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);

		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		request.setAttribute("nomeEmpresa", empresa.getNome());
		response.sendRedirect("listaEmpresas");
		
		// Chamar o JSP
		/*
		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
		request.setAttribute("nomeEmpresa", empresa.getNome());
		rd.forward(request, response);
		*/
	}
}
