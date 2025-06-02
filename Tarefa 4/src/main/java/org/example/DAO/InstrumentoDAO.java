package org.example.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.example.Classe.Instrumento;
import org.example.ConexaoBanco;

public class InstrumentoDAO {

    public void salvar(Instrumento instrumento) {
        String sql = "INSERT INTO instrumento (tipo, marca, preco) VALUES (?, ?, ?)";
        try (Connection conexao = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, instrumento.getTipo());
            stmt.setString(2, instrumento.getMarca());
            stmt.setFloat(3, instrumento.getPreco());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    System.out.println("Instrumento cadastrado com ID: " + generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Instrumento instrumento) {
        String sql = "UPDATE instrumento SET marca=?, preco=? WHERE tipo=?";
        try (Connection conexao = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, instrumento.getMarca());
            stmt.setFloat(2, instrumento.getPreco());
            stmt.setString(3, instrumento.getTipo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(String tipo) {
        String sql = "DELETE FROM instrumento WHERE tipo=?";
        try (Connection conexao = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, tipo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Instrumento> listarTodos() {
        List<Instrumento> lista = new ArrayList<>();
        String sql = "SELECT * FROM instrumento";
        try (Connection conexao = ConexaoBanco.obterConexao();
             Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Instrumento(rs.getString("tipo"), rs.getString("marca"), rs.getFloat("preco")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
