package br.com.cadastro.application;

import br.com.cadastro.modelo.DadosCadastroProduto;
import br.com.cadastro.modelo.service.ProdutoService;
import br.com.cadastro.modelo.service.exceptions.RegraDeNegocioException;

import java.util.Scanner;

public class ProdutoApplication {

    private static ProdutoService service = new ProdutoService();
    private static Scanner teclado = new Scanner(System.in).useDelimiter("\n");

    public static void main(String[] args) {
        var opcao = exibirMenu();
        while (opcao != 8) {
            try {
                switch (opcao) {
                    case 1:
                        listarProdutos();
                        break;
                    case 2:
                        cadastrarProduto();
                        break;
                    case 3:
                        excluirProduto();
                        break;
                    case 4:
                        buscarProdutoPeloNome();
                        break;
                    case 5:
                        alterarPrecoProduto();
                        break;
                    case 6:
                        alterarNomeProduto();
                        break;
                    case 7:
                        alterarQuantidadeProduto();
                        break;
                }
            } catch (RegraDeNegocioException e) {
                System.out.println("Erro: " + e.getMessage());
                System.out.println("Pressione qualquer tecla e de ENTE para voltar ao menu");
                teclado.next();
            }

            opcao = exibirMenu();
        }

        System.out.println("Finalizando a aplicação.");
    }

    private static void alterarQuantidadeProduto() {
        System.out.println("Digite o nome do produto: ");
        var nome = teclado.next();

        System.out.println("Digite a nova quantidade do produto: ");
        var quantidade = teclado.nextInt();

        service.alterarQuantidade(nome, quantidade);
        System.out.println("Quantidade alterada com sucesso!");
        System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu principal");
        teclado.next();

    }

    private static void alterarNomeProduto() {
        System.out.println("Digite o nome atual do produto: ");
        var nome = teclado.next();

        System.out.println("Digite o novo nome do produto: ");
        var novoNome = teclado.next();

        service.alterarNome(nome, novoNome);
        System.out.println("Nome alterado com sucesso!");
        System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu principal");
        teclado.next();
    }

    private static void alterarPrecoProduto() {

        System.out.println("Digite o nome do produto: ");
        var nome = teclado.next();

        System.out.println("Digite o novo preço do produto: ");
        var preco = teclado.nextBigDecimal();

        service.alterarPreco(nome, preco);
        System.out.println("Preço alterado com sucesso!");
        System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu principal");
        teclado.next();
    }

    private static void buscarProdutoPeloNome() {
        System.out.println("Digite o nome do produto: ");
        var nome = teclado.next();

        service.buscarProdutoPorNome(nome);
        System.out.println("Produto encontrado: " + nome);
        System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu principal");
        teclado.next();

    }

    private static void excluirProduto() {
        System.out.println("Digite o nome do produto: ");
        var nome = teclado.next();

        service.excluir(nome);

        System.out.println("Produto excluido com sucesso!");
        System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu principal");
        teclado.next();
    }

    private static void cadastrarProduto() {
        System.out.println("Digite o nome do produto: ");
        var nome = teclado.next();

        System.out.println("Digite o preço do produto: ");
        var preco = teclado.nextBigDecimal();

        System.out.println("Digite a quantidade do produto: ");
        var quantidade = teclado.nextInt();

        System.out.println("Digite a descrição do produto: ");
        var descricao = teclado.next();

        service.cadastrar(new DadosCadastroProduto(nome, preco, quantidade, descricao));

        System.out.println("Produto cadastrado com sucesso!");
        System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu principal");
        teclado.next();
    }

    private static void listarProdutos() {
        System.out.println("Produtos cadastrados: ");
        var produtos = service.listarProdutos();
        produtos.stream().forEach(System.out::println);
    }

    private static int exibirMenu() {
        System.out.println("""
                SUPERMARKET - ESCOLHA UMA OPÇÃO:
                1 - Listar os produtos
                2 - Cadastrar um Produto
                3 - Excluir um Produto
                4 - Buscar Produto pelo nome
                5 - Alterar Preço do Produto
                6 - Alterar Nome do Produto
                7 - Alterar Quantidade do Produto
                """);
        return teclado.nextInt();
    }
}
