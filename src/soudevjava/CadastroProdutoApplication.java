package soudevjava;

import java.util.Locale;
import java.util.Scanner;

import soudevjava.model.Produto;

/*Cadastro de Produtos: Permite adicionar novos produtos ao sistema, 
 * fornecendo informações como nome, descrição, preço e quantidade 
 * em estoque.
 */

public class CadastroProdutoApplication {

	public static void main(String[] args) {
		Locale.setDefault(Locale.CANADA);
		Scanner read = new Scanner(System.in);
		
		System.out.println("Cadastro De Produto");
		
		System.out.print("Enter a name: ");
		String name = read.nextLine().trim();
		
		System.out.print("Enter a description: ");
		read.next();
		String description = read.nextLine().trim();
		
		System.out.print("Enter a price: ");
		Double price = read.nextDouble();
		
		System.out.print("Enter a quantity: ");
		Integer quantity = read.nextInt();
		
		Produto produto = new Produto(name, description, price, quantity);
		
		System.out.println(produto);
		
		read.close();
	}

}
