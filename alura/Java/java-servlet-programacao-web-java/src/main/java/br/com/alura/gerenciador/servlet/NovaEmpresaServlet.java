package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeEmpresa = request.getParameter("nome");
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		System.out.println("Cadastrando nova empresa");
		PrintWriter out = response.getWriter();
		out.println("<html><body>Empresas cadastradas: ");
		
		String listaEmpresas = banco.getEmpresas().stream()
		.map(Empresa::getNome)
		.reduce("", (acc, nome) -> {
			return acc.concat("<br \\>").concat(nome);
		});
		
		out.println(listaEmpresas);
		
		out.println("</body></html>");
	}

}
