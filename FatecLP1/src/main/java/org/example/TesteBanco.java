package org.example;

import java.sql.Connection;

public class TesteBanco {
    public static void main(String[] args) {
        try (Connection conexao = ConexaoBanco.getConnection()) {
            System.out.println("Conexão bem-sucedida!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
