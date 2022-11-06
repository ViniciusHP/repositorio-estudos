package br.com.alura.loja;

import br.com.alura.loja.dao.CategoriaDAO;
import br.com.alura.loja.dao.ClienteDAO;
import br.com.alura.loja.dao.PedidoDAO;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.modelo.*;
import br.com.alura.loja.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;

public class PerformanceConsultas {
    public static void main(String[] args) {
        popularBanco();
        EntityManager em = JPAUtil.getEntityManager();
//        Pedido pedido = em.find(Pedido.class, 1l);
//
//        em.close();
//        System.out.println(pedido.getItens().size());
        PedidoDAO pedidoDAO = new PedidoDAO(em);
        Pedido pedido = pedidoDAO.buscarPedidoComCliente(1l);

        em.close();
        System.out.println(pedido.getCliente().getDadosPessoais().getNome());
    }

    public static void popularBanco() {
        Categoria celulares = new Categoria("CELULARES");
        Categoria videogames = new Categoria("VIDEOGAMES");
        Categoria informatica = new Categoria("INFORMATICA");

        Produto celular = new Produto("Xiaomi Redmi", "Celular lançamento", new BigDecimal(800), celulares);
        Produto videogame = new Produto("PS5", "Playstation 5", new BigDecimal(2000), videogames);
        Produto macbook = new Produto("Macbook", "Macbook pro", new BigDecimal(5000), informatica);

        Cliente cliente = new Cliente("Rodrigo", "123456");

        EntityManager em = JPAUtil.getEntityManager();
        CategoriaDAO categoriaDAO = new CategoriaDAO(em);
        ProdutoDAO produtoDAO = new ProdutoDAO(em);
        ClienteDAO clienteDAO = new ClienteDAO(em);
        PedidoDAO pedidoDAO = new PedidoDAO(em);

        em.getTransaction().begin();
        categoriaDAO.cadastrar(celulares, videogames, informatica);
        produtoDAO.cadastrar(celular, videogame, macbook);
        clienteDAO.cadastrar(cliente);

        Produto produto = produtoDAO.buscarPorId(1l);
        Produto produto2 = produtoDAO.buscarPorId(2l);
        Produto produto3 = produtoDAO.buscarPorId(3l);

        Pedido pedido = new Pedido(cliente);
        pedido.adicionarItem(new ItemPedido(10, pedido, produto));
        pedido.adicionarItem(new ItemPedido(40, pedido, produto2));

        Pedido pedido2 = new Pedido(cliente);
        pedido.adicionarItem(new ItemPedido(2, pedido, produto3));
        pedidoDAO.cadastrar(pedido);
        pedidoDAO.cadastrar(pedido2);

        em.getTransaction().commit();
        em.close();
    }
}
