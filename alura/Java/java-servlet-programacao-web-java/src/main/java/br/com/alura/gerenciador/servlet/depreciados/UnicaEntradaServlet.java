package br.com.alura.gerenciador.servlet.depreciados;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.Acao;

//@WebServlet(urlPatterns = "/entrada")
public class UnicaEntradaServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramAcao = request.getParameter("acao");
		
//		HttpSession sessao = request.getSession();
//		boolean usuarioNaoEstaLogado = sessao.getAttribute("usuarioLogado") == null;
//		boolean ehUmaAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
//		
//		if(usuarioNaoEstaLogado && ehUmaAcaoProtegida) {
//			response.sendRedirect("entrada?acao=LoginForm");
//			return;
//		}
		
		
		
		String nome = null;
		try {
			String nomeClasse = "br.com.alura.gerenciador.acao." + paramAcao;
			Class<Acao> classe = (Class<Acao>) Class.forName(nomeClasse); // Carrega classe com nome da string
			Acao instancia = classe.getConstructor().newInstance();
			nome = instancia.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException e) {
			new ServletException(e);
		}
		
//		if(paramAcao.equals("ListaEmpresas")) {
//			ListaEmpresas acao = new ListaEmpresas();
//			nome = acao.executa(request, response);
//		} else if(paramAcao.equals("RemovaEmpresa")) {
//			RemovaEmpresa acao = new RemovaEmpresa();
//			nome = acao.executa(request, response);
//		} else if(paramAcao.equals("MostraEmpresa")) {
//			MostraEmpresa acao = new MostraEmpresa();
//			nome = acao.executa(request, response);
//		} else if(paramAcao.equals("AlteraEmpresa")) {
//			AlteraEmpresa acao = new AlteraEmpresa();
//			nome = acao.executa(request, response);
//		} else if(paramAcao.equals("NovaEmpresa")) {
//			NovaEmpresa acao = new NovaEmpresa();
//			nome = acao.executa(request, response);
//		} else if(paramAcao.equals("CadastraEmpresa")) {
//			CadastraEmpresa acao = new CadastraEmpresa();
//			nome = acao.executa(request, response);
//		}
		
		String[] tipoEEndereco = nome.split(":");
		String tipo = tipoEEndereco[0];
		String endereco = tipoEEndereco[1];
		
		if( tipo.equals("forward")) {
			String pasta = "WEB-INF/view/";
			RequestDispatcher rd = request.getRequestDispatcher(pasta + endereco);
			rd.forward(request, response);
		} else {
			response.sendRedirect(endereco);
		}
	}
}
