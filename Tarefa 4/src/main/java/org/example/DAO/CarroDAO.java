package org.example.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.example.Classe.Carro;
import org.example.ConexaoBanco;

public class CarroDAO {

    public void salvar(Carro carro) {
        String sql = "INSERT INTO carro (placa, modelo, ano, cor) VALUES (?, ?, ?, ?)";
        try (Connection conexao = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, carro.getPlaca());
            stmt.setString(2, carro.getModelo());
            stmt.setInt(3, carro.getAno());
            stmt.setString(4, carro.getCor());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Carro carro) {
        String sql = "UPDATE carro SET modelo=?, ano=?, cor=? WHERE placa=?";
        try (Connection conexao = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, carro.getModelo());
            stmt.setInt(2, carro.getAno());
            stmt.setString(3, carro.getCor());
            stmt.setString(4, carro.getPlaca());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(String placa) {
        String sql = "DELETE FROM carro WHERE placa=?";
        try (Connection conexao = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, placa);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Carro> listarTodos() {
        List<Carro> lista = new ArrayList<>();
        String sql = "SELECT * FROM carro";
        try (Connection conexao = ConexaoBanco.obterConexao();
             Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Carro(rs.getString("placa"), rs.getString("modelo"), rs.getInt("ano"), rs.getString("cor")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
