package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.vo.RelatorioDeVendasVo;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.List;

public class PedidoDAO {
    private EntityManager em;

    public PedidoDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Pedido pedido) {
        this.em.persist(pedido);
    }

    public Pedido buscarPorId(Long id) {
        return this.em.find(Pedido.class, id);
    }

    public BigDecimal valorTotalVendido() {
        String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
        return this.em.createQuery(jpql, BigDecimal.class)
                .getSingleResult();
    }

//    public List<Object[]> relatorioDeVendas() {
//        String jpql = """
//                SELECT produto.nome,
//                SUM(item.quantidade),
//                MAX(pedido.data)
//                FROM Pedido pedido
//                JOIN pedido.itens item
//                JOIN item.produto produto
//                GROUP BY produto.nome
//                ORDER BY item.quantidade DESC""";
//        return this.em.createQuery(jpql, Object[].class)
//        .getResultList();
//    }

    public List<RelatorioDeVendasVo> relatorioDeVendas() {
        String jpql = """
                SELECT new br.com.alura.loja.vo.RelatorioDeVendasVo( produto.nome,
                SUM(item.quantidade),
                MAX(pedido.data) )
                FROM Pedido pedido
                JOIN pedido.itens item
                JOIN item.produto produto
                GROUP BY produto.nome
                ORDER BY item.quantidade DESC""";
        return this.em.createQuery(jpql, RelatorioDeVendasVo.class)
        .getResultList();
    }

    public Pedido buscarPedidoComCliente(Long id) {
        return em.createQuery("""
                        SELECT p 
                        FROM Pedido p 
                        JOIN FETCH p.cliente 
                        WHERE p.id = :id
                    """, Pedido.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
