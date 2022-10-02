package br.com.alura.cliente;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;

public class ClienteWebService {

	public static void main(String[] args) throws ClientProtocolException, IOException  {
		String conteudo = Request
			.Get("http://localhost:8080/gerenciador/empresas")
			.addHeader("Accept", "application/json")
			.execute()
			.returnContent()
			.asString();
		
		System.out.println("JSON:");
		System.out.println(conteudo);
		
		conteudo = Request
				.Get("http://localhost:8080/gerenciador/empresas")
				.addHeader("Accept", "application/xml")
				.execute()
				.returnContent()
				.asString();
		
		System.out.println("\nXML:");
		System.out.println(conteudo);
		
		conteudo = Request
				.Get("http://localhost:8080/gerenciador/empresas")
				.execute()
				.returnContent()
				.asString();
		System.out.println("\nSem tipo de conteúdo:");
		System.out.println(conteudo);
	}
}
