package br.com.vhp;

import br.com.vhp.db.DB;

import java.sql.*;

public class InsersaoComParametros {
    public static void main(String[] args) throws SQLException {
        try ( Connection con = DB.getConnection()){
            con.setAutoCommit(false);

            try (PreparedStatement stm = con.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)){

                adicionarProduto("SmartTV", "45 polegadas", stm);
                adicionarProduto("Rádio", "Rádio de bateria", stm);

                try(ResultSet rs = stm.getGeneratedKeys()) {
                    while(rs.next()) {
                        int id = rs.getInt(1);
                        System.out.println("O id criado foi: " + id);
                    }
                }

                con.commit();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("ROLLBACK EXECUTADO");
                con.rollback();
            }
        }
    }

    private static void adicionarProduto(String nome, String descricao, PreparedStatement stm ) throws SQLException {
        stm.setString(1, nome);
        stm.setString(2, descricao);

        if(nome.equals("Rádio")) {
            throw new IllegalArgumentException("Não foi possível incluir produto");
        }

        stm.execute();
    }
}
