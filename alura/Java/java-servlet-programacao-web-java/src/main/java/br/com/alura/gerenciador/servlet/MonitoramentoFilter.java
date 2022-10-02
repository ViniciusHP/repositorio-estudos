package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//@WebFilter(urlPatterns = "/entrada")
public class MonitoramentoFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Instant antes = Instant.now();
		
		String acao = request.getParameter("acao");
		
		// executa a ação
		chain.doFilter(request, response);
		
		Instant depois = Instant.now();
		long duracao = ChronoUnit.MILLIS.between(antes, depois);
		System.out.printf("Tempo de execução da ação '%s': %dms%n", acao,duracao);
	}

}
