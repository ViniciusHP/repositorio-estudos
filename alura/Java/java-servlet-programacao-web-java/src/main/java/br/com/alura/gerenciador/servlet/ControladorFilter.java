package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.Acao;

public class ControladorFilter implements Filter {
       
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String paramAcao = request.getParameter("acao");
		
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
