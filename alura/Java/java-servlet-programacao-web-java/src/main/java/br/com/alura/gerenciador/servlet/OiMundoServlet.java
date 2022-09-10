package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/oi")
public class OiMundoServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		
		out.write(
		"""
		<html>
			<body>
					Oi mundo, parabéns você escreveu o primeiro servlet.
			</body>
		</html>
		""");
		
		System.out.println("O Servlet OiMundoServlet foi chamado!");
		
	}
}
