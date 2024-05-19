package br.com.cadastro.modelo;

import java.math.BigDecimal;

public record DadosCadastroProduto(String nome, BigDecimal preco, Integer quantidade, String descricao) {
}
