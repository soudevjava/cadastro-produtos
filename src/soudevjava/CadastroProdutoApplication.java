package soudevjava;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import soudevjava.model.Produto;

/*
 * Cadastro de Produtos: Permite adicionar novos produtos ao sistema, 
 * fornecendo informações como nome, descrição, preço e quantidade 
 * em estoque.
 */

public class CadastroProdutoApplication {

	public static void main(String[] args) {
		Locale.setDefault(Locale.CANADA);
		Scanner read = new Scanner(System.in);
		List<Produto> produtos = new ArrayList<>();

		System.out.println("### Product Registration ###\n");
		System.out.print("Enter 1 - Add | 0 - End: ");
		int op = read.nextInt();

		while (op != 0) {

			System.out.println();
			read.nextLine();

			System.out.print("Enter a product name: ");
			String name = read.nextLine().trim();

			System.out.print("Enter a description: ");
			String description = read.nextLine().trim();

			System.out.print("Enter a price: ");
			Double price = read.nextDouble();

			System.out.print("Enter a quantity: ");
			Integer quantity = read.nextInt();

			Produto produto = new Produto(name, description, price, quantity);

			produtos.add(produto);

			System.err.println("\nProduct registration successfully!");
			System.out.println("");

			System.out.print("Continue? 1 - Yes | 0 - No: ");
			op = read.nextInt();

		}

		System.out.println("");

		if (!produtos.isEmpty()) {
			System.err.println("ALL REGISTRATION PRODUCTS");
			for (Produto produto : produtos) {
				System.out.println(produto);
			}
		}

		System.err.println("Thank you for visiting our system!");

		read.close();
	}

}
