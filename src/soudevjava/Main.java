package soudevjava;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.Produto;

public class Main {

	public static void main(String[] args) {

		Produto produto = new Produto();
		List<Produto> ListaDeProdutos = new ArrayList<>();

		Scanner scanner = new Scanner(System.in);
		boolean Cadrastra = true;
		int inicio = 1;

		System.out.println(" ********** OLA SEJA BEM - VINDO AO CADRASTRA DEV ********");
		System.out.println("VOCÊ DESEJAR CADRASTRA ALGUM PRODUTO? ");

		while (Cadrastra) {
			System.out.println("digite 1 para cadrastrar o produto e 2 para finalizar o cadrastro!! ");
			inicio = scanner.nextInt();

			if (inicio != 1) {
				System.out.println("CADRASTRO nao realizado DIGITE 1 ( cadrastra )ou 2 ( finalizar )");

			} else {
				System.out.println("por favor digite o nome do produto");
				String Nproduto = scanner.next();
				produto.setName(Nproduto);

				System.out.println("por favor digite a descrição do produto");
				String Ddescricao = scanner.next();
				produto.setDescription(Ddescricao);

				System.out.println("por favor digite o preço do produto");
				Double Ppreco = scanner.nextDouble();
				produto.setPrice(Ppreco);

				System.out.println("por favor digite quatidade do  produto");
				int Qquantidade = scanner.nextInt();
				produto.setQuantity(Qquantidade);

				ListaDeProdutos.add(produto); /* adicionando produtos a lista */


				System.out.println("Produto cadrastrado com sucesso realizado");

				System.out.println(
						"desejar realizar mais algum cadrastro, se nao digite 2 para finalizar e 1 para um novo cadrastro?");
				inicio = scanner.nextInt();

				if (inicio == 2) {
					System.out.println("cadrastro de produto finalizado OBRIGADO");
					Cadrastra = false;

				} else {
					Cadrastra = true;

				}
			}

		}

		System.out.print("os produtos cadrastrados foram ");
		for (Produto i : ListaDeProdutos) {
			System.out.println("Nome: " + produto.getName() + ", Descrição: " + produto.getDescription() + ", Preço: "
					+ produto.getPrice() + ", Quantidade: " + produto.getQuantity());
		}

		scanner.close();

	}

}
