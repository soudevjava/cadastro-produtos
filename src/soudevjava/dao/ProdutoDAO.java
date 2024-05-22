package soudevjava.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import soudevjava.model.Produto;

public class ProdutoDAO {
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
	
	public static void updateProduct(Produto produto) {
		if (produtos.contains(produto)) {
			for (int i = 0; i < produtos.size(); i++) {
				Produto itemProduto = produtos.get(i);
				if (itemProduto.equals(produto)) {
					produtos.set(i, produto);
					return;
				}
			}
		} 
	}
	
	public static void deleteProduct(Produto produto) {
		produtos.remove(produto);
	}

}
