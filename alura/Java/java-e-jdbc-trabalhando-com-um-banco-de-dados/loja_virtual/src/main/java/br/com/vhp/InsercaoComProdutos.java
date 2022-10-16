package br.com.vhp;

import br.com.vhp.modelo.dao.DAOFactory;
import br.com.vhp.modelo.dao.impl.ProdutoDAO;
import br.com.vhp.modelo.entity.Produto;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class InsercaoComProdutos {
    public static void main(String[] args) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Produto comoda = Produto.builder()
                .nome("Cômoda")
                .descricao("Cômoda Vertical")
                .build();
        ProdutoDAO produtoDAO = DAOFactory.getDAO(ProdutoDAO.class);
        produtoDAO.salvar(comoda);

        System.out.println("\n### LISTA DE PRODUTOS ###");
        produtoDAO.listar().forEach(System.out::println);
    }
}
