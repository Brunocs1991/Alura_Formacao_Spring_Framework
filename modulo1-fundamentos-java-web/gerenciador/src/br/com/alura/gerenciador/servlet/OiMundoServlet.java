package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//oi
@WebServlet(urlPatterns = "/oi")
public class OiMundoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	

	public OiMundoServlet() {
		System.out.println("Criando o servlet oiMundo");
	}



	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Ola mundo, primeiro servlet");
		out.println("</body>");
		out.println("</html>");

		System.out.println("Servlet chamado oiMundo");
	}

}
