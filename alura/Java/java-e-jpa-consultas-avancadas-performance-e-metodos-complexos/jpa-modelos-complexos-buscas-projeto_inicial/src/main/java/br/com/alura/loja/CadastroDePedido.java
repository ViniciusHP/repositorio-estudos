package br.com.alura.loja;

import br.com.alura.loja.dao.CategoriaDAO;
import br.com.alura.loja.dao.ClienteDAO;
import br.com.alura.loja.dao.PedidoDAO;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.modelo.*;
import br.com.alura.loja.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.List;

public class CadastroDePedido {
    public static void main(String[] args) {
        popularBanco();

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDAO produtoDAO = new ProdutoDAO(em);
        ClienteDAO clienteDAO = new ClienteDAO(em);

        Produto produto = produtoDAO.buscarPorId(1l);
        Cliente cliente = clienteDAO.buscarPorId(1l);

        em.getTransaction().begin();


        Pedido pedido = new Pedido(cliente);
        pedido.adicionarItem(new ItemPedido(10, pedido, produto));

        PedidoDAO pedidoDAO = new PedidoDAO(em);
        pedidoDAO.cadastrar(pedido);

        em.getTransaction().commit();

        BigDecimal totalVendido = pedidoDAO.valorTotalVendido();
        System.out.println("VALOR TOTAL: " + totalVendido);

        List<Object[]> relatorio = pedidoDAO.relatorioDeVendas();
        relatorio.forEach(obj -> {
            System.out.println(obj[0]);
            System.out.println(obj[1]);
            System.out.println(obj[2]);
        });
    }

    public static void popularBanco() {
        Categoria categoriaCelulares = new Categoria("CELULARES");
        Produto celular = new Produto("Xiaomi Redmi", "Celular lançamento", new BigDecimal(800), categoriaCelulares);
        Cliente cliente = new Cliente("Rodrigo", "123456");

        EntityManager em = JPAUtil.getEntityManager();
        CategoriaDAO categoriaDAO = new CategoriaDAO(em);
        ProdutoDAO produtoDAO = new ProdutoDAO(em);
        ClienteDAO clienteDAO = new ClienteDAO(em);

        em.getTransaction().begin();
        categoriaDAO.cadastrar(categoriaCelulares);
        produtoDAO.cadastrar(celular);
        clienteDAO.cadastrar(cliente);

        em.getTransaction().commit();
        em.close();
    }
}
