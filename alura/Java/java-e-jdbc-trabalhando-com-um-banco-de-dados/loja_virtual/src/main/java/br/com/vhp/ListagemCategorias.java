package br.com.vhp;

import br.com.vhp.modelo.dao.DAOAbstract;
import br.com.vhp.modelo.dao.DAOFactory;
import br.com.vhp.modelo.dao.DAOList;
import br.com.vhp.modelo.dao.impl.CategoriaDAO;
import br.com.vhp.modelo.dao.impl.ProdutoDAO;
import br.com.vhp.modelo.entity.Categoria;

import java.sql.SQLException;
import java.util.List;

public class ListagemCategorias {

    public static void main(String[] args) throws SQLException {
        DAOList daoList = DAOFactory.getDAOsWithSameConnection(CategoriaDAO.class);

        CategoriaDAO categoriaDAO = daoList.getDao(CategoriaDAO.class);
        //ProdutoDAO produtoDAO = daoList.getDao(ProdutoDAO.class);

        categoriaDAO.listarComProdutos().forEach((c) -> {
            System.out.println(c);
            c.getProdutos().forEach((p) -> System.out.println("\t" + p));
        });
    }
}
