package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class NovaEmpresa {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("Cadastrando nova empresa");
		String nomeEmpresa = request.getParameter("nome");
		String paramDataAbertura = request.getParameter("data");

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Date dataAbertura = null;
		try {
			dataAbertura = sdf.parse(paramDataAbertura);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);

		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		request.setAttribute("nomeEmpresa", empresa.getNome());
		return "redirect:entrada?acao=ListaEmpresas";
	}
}
