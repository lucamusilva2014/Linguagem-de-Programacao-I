package org.example.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.example.Classe.Animal;
import org.example.ConexaoBanco;

public class AnimalDAO {

    public void salvar(Animal animal) {
        String sql = "INSERT INTO animais (nome, especie, peso) VALUES (?, ?, ?)";
        try (Connection conexao = ConexaoBanco.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, animal.getNome());
            stmt.setString(2, animal.getEspecie());
            stmt.setFloat(3, animal.getPeso());
            stmt.executeUpdate();

            // Obter o ID gerado pelo banco
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    animal.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Animal animal) {
        String sql = "UPDATE animais SET nome=?, especie=?, peso=? WHERE id=?";
        try (Connection conexao = ConexaoBanco.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, animal.getNome());
            stmt.setString(2, animal.getEspecie());
            stmt.setFloat(3, animal.getPeso());
            stmt.setInt(4, animal.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM animais WHERE id=?";
        try (Connection conexao = ConexaoBanco.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Animal> listarTodos() {
        List<Animal> lista = new ArrayList<>();
        String sql = "SELECT * FROM animais";
        try (Connection conexao = ConexaoBanco.getConnection();
             Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Animal(rs.getInt("id"), rs.getString("nome"), rs.getString("especie"), rs.getFloat("peso")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
