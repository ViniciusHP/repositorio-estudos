package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Pedido;
import jakarta.persistence.EntityManager;

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
}
