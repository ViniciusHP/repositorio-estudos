package br.com.alura.loja;

import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class EstadosEntidade {
    public static void main(String[] args) {
        Categoria categoriaCelulares = new Categoria("CELULARES");

        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();
        em.persist(categoriaCelulares);
        categoriaCelulares.setNome("XPTO");

        em.flush();
        em.clear();

        categoriaCelulares = em.merge(categoriaCelulares);
        categoriaCelulares.setNome("12345");
        em.flush();

    }
}
