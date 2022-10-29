package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Produto;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ProdutoDAO {
    private EntityManager em;

    public ProdutoDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Produto produto) {
        this.em.persist(produto);
    }

    public Produto buscarPorId(Long id) {
        return this.em.find(Produto.class, id);
    }

    public List<Produto> buscarTodos() {
        String jpql = "SELECT p FROM Produto p";
        return this.em.createQuery(jpql, Produto.class).getResultList();
    }
}
