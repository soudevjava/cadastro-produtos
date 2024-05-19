package br.com.cadastro.modelo.service;

import br.com.cadastro.modelo.DadosCadastroProduto;
import br.com.cadastro.modelo.Produto;
import br.com.cadastro.modelo.service.exceptions.RegraDeNegocioException;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class ProdutoService {

    private Set<Produto> produtos = new HashSet<>();

    public Set<Produto> listarProdutos() {
        return produtos;
    }

    public void cadastrar(DadosCadastroProduto dadosCadastroProduto) {
        Produto produto = new Produto(dadosCadastroProduto);
        produtos.add(produto);
    }

    public void excluir(String nome) {
        var produto = buscarProdutoPorNome(nome);
        produtos.remove(produto);
    }

    public void alterarNome(String nome, String novoNome) {

        var produto = buscarProdutoPorNome(nome);

        if(novoNome.equalsIgnoreCase(produto.getNome())) {

            throw new RegraDeNegocioException("O nome do novo produto não ser igual ao nome do produto atual");
        }

        produto.alterarNome(novoNome);
    }

    public void alterarPreco(String nome, BigDecimal novoPreco) {

        var produto = buscarProdutoPorNome(nome);

        if(novoPreco.compareTo(BigDecimal.ZERO) <= 0) {

            throw new RegraDeNegocioException("O novo preço deve ser superior a zero!");
        }

        produto.alterarPreco(novoPreco);
    }

    public void alterarQuantidade(String nome, Integer novaQuantidade) {

        var produto = buscarProdutoPorNome(nome);

        if(novaQuantidade.compareTo(produto.getQuantidade()) == 0) {

            throw new RegraDeNegocioException("A nova quantidade deve ser diferente da quantidade atual");
        }

        produto.alterarQuantidade(novaQuantidade);
    }

    public Produto buscarProdutoPorNome(String nome) {
        return produtos
                .stream()
                .filter(p -> p.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Não existe produto cadastrado com esse nome!"));
    }
}
