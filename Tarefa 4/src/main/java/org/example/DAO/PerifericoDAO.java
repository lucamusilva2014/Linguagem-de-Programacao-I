package org.example.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.example.Classe.Periferico;
import org.example.ConexaoBanco;

public class PerifericoDAO {

    public void salvar(Periferico periferico) {
        String sql = "INSERT INTO periferico (nome, modelo, preco) VALUES (?, ?, ?)";
        try (Connection conexao = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, periferico.getNome());
            stmt.setString(2, periferico.getModelo());
            stmt.setFloat(3, periferico.getPreco());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    periferico.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Periferico periferico) {
        String sql = "UPDATE periferico SET nome=?, modelo=?, preco=? WHERE id=?";
        try (Connection conexao = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, periferico.getNome());
            stmt.setString(2, periferico.getModelo());
            stmt.setFloat(3, periferico.getPreco());
            stmt.setInt(4, periferico.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM periferico WHERE id=?";
        try (Connection conexao = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Periferico> listarTodos() {
        List<Periferico> lista = new ArrayList<>();
        String sql = "SELECT * FROM periferico";
        try (Connection conexao = ConexaoBanco.obterConexao();
             Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Periferico(rs.getInt("id"), rs.getString("nome"), rs.getString("modelo"), rs.getFloat("preco")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
