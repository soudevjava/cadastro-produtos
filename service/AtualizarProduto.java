package service;

import vo.Produto;

public class AtualizarProduto {
    public void atualizar(Produto produto, String nome, String descricao, Double preco, Integer quantidade){
        if(produto != null){
            produto.setNome(nome);
            produto.setDescricao(descricao);
            produto.setPreco(preco);
            produto.setQuantidade(quantidade);
            System.out.println("vo.Produto atualizado com sucesso: "+produto);
        }else {
            System.out.println("vo.Produto inválido. Não foi possivel atualizar.");
        }
    }
}
