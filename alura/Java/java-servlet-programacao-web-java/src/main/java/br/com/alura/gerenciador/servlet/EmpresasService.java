package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

@WebServlet("/empresas")
public class EmpresasService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banco banco = new Banco();
		List<Empresa> empresas = banco.getEmpresas();
		
//		Gson gson = new Gson();
//		String resposta = gson.toJson(empresas);
//		response.setContentType("application/json");
		
		XStream xstream = new XStream();
		xstream.alias("empresa", Empresa.class);
		String resposta = xstream.toXML(empresas);
		response.setContentType("application/xml");
		
		PrintWriter writer = response.getWriter();
		writer.print(resposta);
	}

}
