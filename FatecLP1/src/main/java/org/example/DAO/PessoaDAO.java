package org.example.DAO;

import org.example.Classe.Pessoa;
import org.example.ConexaoBanco;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {

    private Connection obterConexao() throws SQLException {
        return ConexaoBanco.obterConexao();
    }

    public void salvar(Pessoa pessoa) throws SQLException {
        String sql = "INSERT INTO pessoas (cpf, nome, idade) VALUES (?, ?, ?)";
        try (Connection conexao = obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, pessoa.getCpf());
            stmt.setString(2, pessoa.getNome());
            stmt.setInt(3, pessoa.getIdade());
            stmt.executeUpdate();
        }
    }

    public void atualizar(Pessoa pessoa) throws SQLException {
        String sql = "UPDATE pessoas SET nome=?, idade=? WHERE cpf=?";
        try (Connection conexao = obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, pessoa.getNome());
            stmt.setInt(2, pessoa.getIdade());
            stmt.setString(3, pessoa.getCpf());
            stmt.executeUpdate();
        }
    }

    public void excluir(String cpf) throws SQLException {
        String sql = "DELETE FROM pessoas WHERE cpf=?";
        try (Connection conexao = obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            stmt.executeUpdate();
        }
    }

    public List<Pessoa> listarTodos() throws SQLException {
        List<Pessoa> lista = new ArrayList<>();
        String sql = "SELECT cpf, nome, idade FROM pessoas";

        try (Connection conexao = obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(new Pessoa(rs.getString("cpf"), rs.getString("nome"), rs.getInt("idade")));
            }
        }

        return lista;
    }
}
