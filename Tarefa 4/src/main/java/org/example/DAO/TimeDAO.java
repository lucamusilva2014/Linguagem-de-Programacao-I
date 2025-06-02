package org.example.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.example.Classe.Time;
import org.example.ConexaoBanco;

public class TimeDAO {

    public void salvar(Time time) {
        String sql = "INSERT INTO time (nome, pais, titulos) VALUES (?, ?, ?)";
        try (Connection conexao = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, time.getNome());
            stmt.setString(2, time.getPais());
            stmt.setInt(3, time.getTitulos());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    System.out.println("Time cadastrado com ID: " + generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Time time) {
        String sql = "UPDATE time SET pais=?, titulos=? WHERE nome=?";
        try (Connection conexao = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, time.getPais());
            stmt.setInt(2, time.getTitulos());
            stmt.setString(3, time.getNome());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(String nome) {
        String sql = "DELETE FROM time WHERE nome=?";
        try (Connection conexao = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Time> listarTodos() {
        List<Time> lista = new ArrayList<>();
        String sql = "SELECT * FROM time";
        try (Connection conexao = ConexaoBanco.obterConexao();
             Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Time(rs.getString("nome"), rs.getString("pais"), rs.getInt("titulos")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
