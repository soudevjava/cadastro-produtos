package br.com.cadastro.dao;

import br.com.cadastro.modelo.DadosCadastroProduto;
import br.com.cadastro.modelo.Produto;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class ProdutoDAO {

    private Connection conn;

    ProdutoDAO(Connection connection) {
        this.conn = connection;
    }

    public void cadastrar(DadosCadastroProduto dadosCadastroProduto) {

        Produto produto = new Produto(dadosCadastroProduto);

        String sql = "INSERT INTO produto (nome, preco, quantidade, descricao)" +
                "VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setBigDecimal(2, produto.getPreco());
            preparedStatement.setInt(3, produto.getQuantidade());
            preparedStatement.setString(4, produto.getDescricao());

            preparedStatement.execute();
            preparedStatement.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Set<Produto> listar() {
        PreparedStatement ps;
        ResultSet resultSet;
        Set<Produto> produtos = new HashSet<>();

        String sql = "SELECT * FROM produto";

        try {
            ps = conn.prepareStatement(sql);
            resultSet = ps.executeQuery();

            while(resultSet.next()) {
                String nome = resultSet.getString(1);
                BigDecimal preco = resultSet.getBigDecimal(2);
                Integer quantidade = resultSet.getInt(3);
                String descricao = resultSet.getString(4);

                DadosCadastroProduto dadosCadastroProduto = new DadosCadastroProduto(nome, preco, quantidade, descricao);
                Produto produto = new Produto(dadosCadastroProduto);

                produtos.add(produto);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

        return produtos;
    }

    public Produto listarPorNome(String nome) {
        String sql = "SELECT * FROM produto WHERE nome = " + nome;

        PreparedStatement ps;
        ResultSet resultSet;
        Produto produto = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, nome);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                String nomeRecuperado = resultSet.getString(1);
                BigDecimal preco = resultSet.getBigDecimal(2);
                Integer quantidade = resultSet.getInt(3);
                String descricao = resultSet.getString(4);

                DadosCadastroProduto dadosCadastroProduto = new DadosCadastroProduto(nomeRecuperado, preco, quantidade, descricao);
                produto = new Produto(dadosCadastroProduto);

            }
            resultSet.close();
            ps.close();
            conn.close();

        } catch (SQLException e) {
            new RuntimeException(e);
        }
        return produto;
    }

    public void alterarQuantidade(String nomeProduto, Integer quantidade) {
        PreparedStatement ps;
        String sql = "UPDATE produto SET quantidade = ? WHERE nome = ?";

        try {
            conn.setAutoCommit(false);

            ps = conn.prepareStatement(sql);

            ps.setInt(1, quantidade);
            ps.setString(2, nomeProduto);

            ps.execute();
            ps.close();
            conn.close();
            conn.commit();

        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
    }

    public void alterarPreco(String nomeProduto, BigDecimal novoPreco) {

        PreparedStatement ps;
        String sql = "UPDATE produto SET preco = ? WHERE nome = ?";

        try {
            conn.setAutoCommit(false);

            ps = conn.prepareStatement(sql);

            ps.setBigDecimal(1, novoPreco);
            ps.setString(2, nomeProduto);

            ps.execute();
            ps.close();
            conn.close();
            conn.commit();

        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex.getMessage());
            }
            throw new RuntimeException(e.getMessage());
        }
    }

    public void alterarNome(String nomeProduto, String novoNomeProduto) {

        PreparedStatement ps;
        String sqlBusca = "UPDATE produto SET nome = ? WHERE nome = ?";


        try {
            conn.setAutoCommit(false);

            ps = conn.prepareStatement(sqlBusca);

            ps.setString(1, nomeProduto);
            ps.setString(2, novoNomeProduto);

            ps.execute();
            ps.close();
            conn.close();
            conn.commit();

        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex.getMessage());
            }
            throw new RuntimeException(e.getMessage());
        }
    }
}
