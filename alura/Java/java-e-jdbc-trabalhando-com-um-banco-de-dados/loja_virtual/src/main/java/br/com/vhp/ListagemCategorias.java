package br.com.vhp;

import br.com.vhp.modelo.dao.DAOFactory;
import br.com.vhp.modelo.dao.impl.CategoriaDAO;

import java.sql.SQLException;

public class ListagemCategorias {

    public static void main(String[] args) throws SQLException {
        CategoriaDAO dao = DAOFactory.getDAO(CategoriaDAO.class);
        dao.listar().forEach(System.out::println);
    }
}
