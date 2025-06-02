package org.example.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.example.Classe.Livro;
import org.example.ConexaoBanco;

public class LivroDAO {

    public void salvar(Livro livro) {
        String sql = "INSERT INTO livro (isbn, titulo, autor, ano) VALUES (?, ?, ?, ?)";
        try (Connection conexao = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, livro.getIsbn());
            stmt.setString(2, livro.getTitulo());
            stmt.setString(3, livro.getAutor());
            stmt.setInt(4, livro.getAno());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Livro livro) {
        String sql = "UPDATE livro SET titulo=?, autor=?, ano=? WHERE isbn=?";
        try (Connection conexao = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setInt(3, livro.getAno());
            stmt.setInt(4, livro.getIsbn());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int isbn) {
        String sql = "DELETE FROM livro WHERE isbn=?";
        try (Connection conexao = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, isbn);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Livro> listarTodos() {
        List<Livro> lista = new ArrayList<>();
        String sql = "SELECT * FROM livro";
        try (Connection conexao = ConexaoBanco.obterConexao();
             Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Livro(rs.getInt("isbn"), rs.getString("titulo"), rs.getString("autor"), rs.getInt("ano")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
