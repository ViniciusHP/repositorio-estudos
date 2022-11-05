package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class ProdutoDAO {
    private EntityManager em;

    public ProdutoDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Produto ...produtos) {
        for (Produto produto : produtos) {
            cadastrar(produto);
        }
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

    public List<Produto> buscarPorNome(String nome) {
        String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";
        return this.em.createQuery(jpql, Produto.class)
                .setParameter("nome", nome)
                .getResultList();
//        String jpql = "SELECT p FROM Produto p WHERE p.nome = ?1";
//        return this.em.createQuery(jpql, Produto.class)
//                .setParameter(1, nome)
//                .getResultList();
    }

    public BigDecimal buscarPrecoDoProdutoComNome(String nome) {
        String jpql = "SELECT p.preco FROM Produto p WHERE p.nome = :nome";
        return this.em.createQuery(jpql, BigDecimal.class)
                .setParameter("nome", nome)
                .getSingleResult();
    }

    public List<Produto> buscarPorNomeCategoria(String nome) {
        return this.em.createNamedQuery("Produto.produtosPorCategoria", Produto.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    public List<Produto> buscarPorParametros(String nome, BigDecimal preco, LocalDate dataCadastro) {
        String jpql = "SELECT p FROM Produto p WHERE 1=1 ";

        boolean isComFiltroNome = nome != null && !nome.trim().isEmpty();
        boolean isComFiltroPreco = preco != null;
        boolean isComFiltroDataCadastro = dataCadastro != null;

        if(isComFiltroNome) {
            jpql += " AND p.nome = :nome";
        }

        if(isComFiltroPreco) {
            jpql += " AND p.preco = :preco";
        }

        if(isComFiltroDataCadastro) {
            jpql += " AND p.dataCadastro = :dataCadastro";
        }

        TypedQuery<Produto> query = em.createQuery(jpql, Produto.class);

        if(isComFiltroNome) {
            query.setParameter("nome", nome);
        }

        if(isComFiltroPreco) {
            query.setParameter("preco", preco);
        }

        if(isComFiltroDataCadastro) {
            query.setParameter("dataCadastro", dataCadastro);
        }

        return query.getResultList();
    }
}
