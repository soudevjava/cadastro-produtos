
import src.service.AtualizarProduto;
import src.vo.Produto;


public class Main {
    public static void main(String[] args) {
        AtualizarProduto atualizador = new AtualizarProduto();

        Produto produto1 = new Produto("Caneta","Caneta ponta fina na cor azul",2.99,23);
        Produto produto2 = new Produto("Estojo", "Estojo Organizador Escola Grande Masculino Feminino Box Liso",32.99,50);
        Produto produto3 = new Produto("Borracha","Borracha Pequena Comum Faber Castell",4.99,15);
        Produto produto4 = new Produto("Régua","Régua Serena Pastel 30cm",9.99,26);

        System.out.println("==== Produto antes da atualização ====");
        System.out.println(produto1);
        System.out.println(produto2);
        System.out.println(produto3);
        System.out.println(produto4);

        // Atualizando os produtos
        atualizador.atualizar(produto1, "Pincel marcador", "Pincel marcador atômico preto 1100-P Pilot BT", 7.20, 44);
        produto3.setPreco(5.00);

        System.out.println("==== Produto Atualizado ====");
        System.out.println(produto1);
        System.out.println(produto3);
    }
}
