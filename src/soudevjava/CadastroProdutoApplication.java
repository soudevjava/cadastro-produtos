package soudevjava;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import soudevjava.dao.ProdutoDAO;
import soudevjava.model.Produto;

/*
 * Cadastro de Produtos: Permite adicionar novos produtos ao sistema, 
 * fornecendo informações como nome, descrição, preço e quantidade 
 * em estoque.
 */

public class CadastroProdutoApplication {
	static Scanner read = new Scanner(System.in);

	public static void main(String[] args) {
		menu();
	}

	static void menu() {
		Locale.setDefault(Locale.CANADA);
		int op;
		do {
			System.out.println("\n### Product Registration ###\n");
			System.out.print("\n 1 - Add Product \n 2 - Find All Product \n 3 - Find Product \n 0 - End \n : ");
			op = read.nextInt();
			read.nextLine();

			switch (op) {
			case 1:
				addProduct();
				break;
			case 2:
				findAllProducts();
				break;
			case 3:
				findByNameProduct();
				break;
			case 0:
				System.err.println("\nLeaving the system...");
			default:
				break;
			}

		} while (op != 0);
		System.err.println("\nThe End.");
	}

	static void addProduct() {
		System.out.println("\nAdd Product\n");

		System.out.print("Enter a name: ");
		String name = read.nextLine();

		System.out.print("Enter a description: ");
		String description = read.nextLine();

		System.out.print("Enter a price: ");
		Double price = read.nextDouble();

		System.out.print("Enter a quantity: ");
		Integer quantity = read.nextInt();

		ProdutoDAO.addProduct(new Produto(name, description, price, quantity));

		System.out.println("\nProduct registered successfully!");
	}

	static void findAllProducts() {
		List<Produto> produtos = ProdutoDAO.findAll();
		if (produtos.isEmpty()) {
			System.err.println("\nThere are no products registred.");
		}
		for (Produto produto : produtos) {
			System.out.println("\nFind All Product");
			System.out.println(produto);
		}
	}
	
	static void findByNameProduct() {
		System.out.println("\nFind Product\n");
		System.out.print("Enter a name product: ");
		String name = read.nextLine();
		
		Produto produto = ProdutoDAO.findByName(name);
		if(produto != null) {
			System.out.println("\nProduct: "+produto);
		}else {
			System.out.println("\nProduct with name '"+name+"' not found.");
		}
	}
}
