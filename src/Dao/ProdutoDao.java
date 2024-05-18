package Dao;

import java.util.ArrayList;
import java.util.List;

import Model.Produto;

public class ProdutoDao {

	public static List<Produto> produtos = new ArrayList<>();

	public static void addProduct(Produto produto) {
		produtos.add(produto);
	}

	public static List<Produto> findAll() {
		return new ArrayList<>(produtos);
	}

	public static Produto findByName(String name) {
		for (Produto produto : produtos) {
			if (produto.getName().contains(name)) {
				return produto;
			}
		}
		return null;
	}

}