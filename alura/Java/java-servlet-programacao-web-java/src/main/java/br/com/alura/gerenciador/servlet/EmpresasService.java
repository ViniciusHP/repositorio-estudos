package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

@WebServlet("/empresas")
public class EmpresasService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banco banco = new Banco();
		List<Empresa> empresas = banco.getEmpresas();
		
		String tipoDeValores = request.getHeader("Accept");
		
		List<String> listaTiposDeValores = new ArrayList<>();
		
		if(tipoDeValores != null) {
			listaTiposDeValores = Stream.of(tipoDeValores.split(","))
				.map(str -> str.trim())
				.flatMap(str -> Stream.of(str.split(";")))
				.map(str -> str.trim())
				.toList();
		}
		System.out.println(listaTiposDeValores);
		String resposta = null;
		
		if(isConteudoXml(listaTiposDeValores)) {
			XStream xstream = new XStream();
			xstream.alias("empresa", Empresa.class);
			resposta = xstream.toXML(empresas);
			response.setContentType("application/xml");
		} else if(isConteudoJson(listaTiposDeValores)) {
			Gson gson = new Gson();
			resposta = gson.toJson(empresas);
			response.setContentType("application/json");
		} else {
			response.setContentType("application/json");
			resposta = "{ 'message': 'no content' }";
		}
		
		PrintWriter writer = response.getWriter();
		writer.print(resposta);
	}
	
	private boolean isConteudoJson(List<String> listaTiposDeValores) {
		return isConteudoTipo("application/json", listaTiposDeValores);
	}
	
	private boolean isConteudoXml(List<String> listaTiposDeValores) {
		return isConteudoTipo("application/xml", listaTiposDeValores);
	}
	
	private boolean isConteudoTipo(String tipo, List<String> listaTiposDeValores) {
		if(tipo == null || listaTiposDeValores == null || listaTiposDeValores.isEmpty()) {
			return false;
		}
		
		return listaTiposDeValores.stream()
			.anyMatch(tipoValor -> tipoValor.equalsIgnoreCase(tipo));
	}

}
