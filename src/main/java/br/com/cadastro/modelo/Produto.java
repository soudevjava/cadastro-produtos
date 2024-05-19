package br.com.cadastro.modelo;

import java.math.BigDecimal;
import java.util.Objects;

public class Produto {

    private String nome;
    private BigDecimal preco;
    private Integer quantidade;
    private String descricao;

    public Produto(DadosCadastroProduto dados) {
        this.nome = dados.nome();
        this.preco = dados.preco();
        this.quantidade = dados.quantidade();
        this.descricao = dados.descricao();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void alterarNome(String nome) {
        this.setNome(nome);
    }

    public void alterarPreco(BigDecimal preco) {
        this.setPreco(preco);
    }

    public void alterarQuantidade(Integer quantidade) {
        this.setQuantidade(quantidade);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(nome, produto.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
