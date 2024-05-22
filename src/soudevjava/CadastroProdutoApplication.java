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
			System.out.print("\n 1 - Add Product \n 2 - Find All Product \n 3 - Find Product "
					+ "\n 4 - Update Product \n 5 - Delete Product \n 0 - End \n Enter one of the options: ");
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
			case 4:
				updateProduct();
				break;
			case 5:
				deleteProduct();
				break;
			case 0:
				System.out.println("\nLeaving the system...");
			default:
				break;
			}

		} while (op != 0);
		System.out.println("\nThe End.");
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
			return;
		}
		for (Produto produto : produtos) {
			System.out.println("\nFind All Product");
			System.out.println(produto);
		}
	}

	static void findByNameProduct() {
		List<Produto> produtos = ProdutoDAO.findAll();
		if (produtos.isEmpty()) {
			System.err.println("\nThere are no products registred.");
			return;
		}

		System.out.println("\nFind Product\n");
		System.out.print("Enter a name product: ");
		String name = read.nextLine();

		Produto produto = ProdutoDAO.findByName(name);
		if (produto != null) {
			System.out.println("\nProduct: " + produto);
		} else {
			System.out.println("\nProduct with name '" + name + "' not found.");
		}
	}

	static void updateProduct() {
		List<Produto> produtos = ProdutoDAO.findAll();
		if (produtos.isEmpty()) {
			System.err.println("\nThere are no products registred.");
			return;
		}

		System.out.println("\nUpdate Product\n");

		System.out.print("Enter the name of the product to be updated: ");
		String oldName = read.nextLine();

		System.out.print("Enter new name: ");
		String newName = read.nextLine();

		System.out.print("Enter new description: ");
		String newDescription = read.nextLine();

		System.out.print("Enter new price: ");
		Double newPrice = read.nextDouble();

		System.out.print("Enter new quantity: ");
		Integer newQuantity = read.nextInt();

		Produto productFound = null;
		for (Produto produto : produtos) {
			if (produto.getName().equals(oldName)) {
				productFound = produto;
				return;
			}
		}

		if (productFound == null) {
			System.err.println("Product with name = '" + oldName + "' not found!");
			return;
		}
		
		productFound = new Produto(newName, newDescription, newPrice, newQuantity);
		ProdutoDAO.updateProduct(productFound);
		System.out.println("\nProduct updated successfully!");
	}

	static void deleteProduct() {
		List<Produto> produtos = ProdutoDAO.findAll();
		if (produtos.isEmpty()) {
			System.err.println("\nThere are no products registred.");
			return;
		}
		System.out.println("\nUpdate Product\n");

		System.out.print("Enter the name of the product to be deleted: ");
		String name = read.nextLine();
		
		Produto produtoFound = null;
		for (Produto produto : produtos) {
			if (produto.getName().equals(name)) {
				produtoFound = produto;
				break;
			}
		}
		
		produtos.remove(produtoFound);
		ProdutoDAO.deleteProduct(produtoFound);
	}
}
