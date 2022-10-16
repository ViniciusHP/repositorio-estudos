package br.com.vhp;

import br.com.vhp.modelo.dao.DAOFactory;
import br.com.vhp.modelo.dao.ProdutoDAO;
import br.com.vhp.modelo.entity.Produto;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class InsercaoComProduto {
    public static void main(String[] args) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Produto comoda = Produto.builder()
                .nome("Cômoda")
                .descricao("Cômoda Vertical")
                .build();
        ProdutoDAO produtoDAO = DAOFactory.getDAO(ProdutoDAO.class);
        produtoDAO.salvar(comoda);

        System.out.println(comoda);
    }
}
