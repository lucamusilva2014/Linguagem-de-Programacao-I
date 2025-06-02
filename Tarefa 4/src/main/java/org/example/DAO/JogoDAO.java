package org.example.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.example.Classe.Jogo;
import org.example.ConexaoBanco;

public class JogoDAO {

    public void salvar(Jogo jogo) {
        String sql = "INSERT INTO jogo (nome, plataforma, tipo) VALUES (?, ?, ?)";
        try (Connection conexao = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, jogo.getNome());
            stmt.setString(2, jogo.getPlataforma());
            stmt.setString(3, jogo.getTipo());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    jogo.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Jogo jogo) {
        String sql = "UPDATE jogo SET nome=?, plataforma=?, tipo=? WHERE id=?";
        try (Connection conexao = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, jogo.getNome());
            stmt.setString(2, jogo.getPlataforma());
            stmt.setString(3, jogo.getTipo());
            stmt.setInt(4, jogo.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM jogo WHERE id=?";
        try (Connection conexao = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Jogo> listarTodos() {
        List<Jogo> lista = new ArrayList<>();
        String sql = "SELECT * FROM jogo";
        try (Connection conexao = ConexaoBanco.obterConexao();
             Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Jogo(rs.getInt("id"), rs.getString("nome"), rs.getString("plataforma"), rs.getString("tipo")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
