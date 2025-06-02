package org.example.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.example.Classe.Flor;
import org.example.ConexaoBanco;

public class FlorDAO {

    public void salvar(Flor flor) {
        String sql = "INSERT INTO flor (nome, cor, aroma) VALUES (?, ?, ?)";
        try (Connection conexao = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, flor.getNome());
            stmt.setString(2, flor.getCor());
            stmt.setString(3, flor.getAroma());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    // Dependendo do esquema do banco, pode ser necessário um ID
                    System.out.println("Flor cadastrada com ID: " + generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Flor flor) {
        String sql = "UPDATE flor SET cor=?, aroma=? WHERE nome=?";
        try (Connection conexao = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, flor.getCor());
            stmt.setString(2, flor.getAroma());
            stmt.setString(3, flor.getNome());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(String nome) {
        String sql = "DELETE FROM flor WHERE nome=?";
        try (Connection conexao = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Flor> listarTodas() {
        List<Flor> lista = new ArrayList<>();
        String sql = "SELECT * FROM flor";
        try (Connection conexao = ConexaoBanco.obterConexao();
             Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Flor(rs.getString("nome"), rs.getString("cor"), rs.getString("aroma")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
