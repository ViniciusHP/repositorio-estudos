package br.com.alura.loja;

import br.com.alura.loja.dao.CategoriaDAO;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.CategoriaId;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.util.List;

public class CadastroDeProduto {

    public static void main(String[] args) {
        cadastrarProduto();

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDAO produtoDAO = new ProdutoDAO(em);

        Produto produto = produtoDAO.buscarPorId(1l);
        System.out.println(produto.getPreco());

        List<Produto> todos = produtoDAO.buscarPorNomeCategoria("CELULARES");
        todos.forEach((p) -> System.out.println(p.getNome()));

        BigDecimal precoProduto = produtoDAO.buscarPrecoDoProdutoComNome("Xiaomi Redmi");
        System.out.println("Preço do produto" + precoProduto);
    }

    public static void cadastrarProduto() {
        Categoria categoriaCelulares = new Categoria("CELULARES");
        Produto celular = new Produto("Xiaomi Redmi", "Celular lançamento", new BigDecimal(800), categoriaCelulares);

        EntityManager em = JPAUtil.getEntityManager();
        CategoriaDAO categoriaDAO = new CategoriaDAO(em);
        ProdutoDAO produtoDAO = new ProdutoDAO(em);

        em.getTransaction().begin();
        categoriaDAO.cadastrar(categoriaCelulares);
        produtoDAO.cadastrar(celular);

        em.getTransaction().commit();

        Categoria categoria = em.find(Categoria.class, new CategoriaId("CELULARES", "GERAL"));
        System.out.println(categoria.getNome());
        em.close();
    }
}
