package org.example.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.example.Classe.Calcado;
import org.example.ConexaoBanco;

public class CalcadoDAO {

    public void salvar(Calcado calcado) {
        String sql = "INSERT INTO calcado (tipo, cor, tamanho) VALUES (?, ?, ?)";
        try (Connection conexao = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, calcado.getTipo());
            stmt.setString(2, calcado.getCor());
            stmt.setInt(3, calcado.getTamanho());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    calcado.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Calcado calcado) {
        String sql = "UPDATE calcado SET tipo=?, cor=?, tamanho=? WHERE id=?";
        try (Connection conexao = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, calcado.getTipo());
            stmt.setString(2, calcado.getCor());
            stmt.setInt(3, calcado.getTamanho());
            stmt.setInt(4, calcado.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM calcado WHERE id=?";
        try (Connection conexao = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Calcado> listarTodos() {
        List<Calcado> lista = new ArrayList<>();
        String sql = "SELECT * FROM calcado";
        try (Connection conexao = ConexaoBanco.obterConexao();
             Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Calcado(rs.getInt("id"), rs.getString("tipo"), rs.getString("cor"), rs.getInt("tamanho")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
