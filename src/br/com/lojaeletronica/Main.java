package br.com.lojaeletronica;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Produto smartphone = new Smartphone(
                "Samsung",
                "Galaxy S24",
                new BigDecimal("4299.90"),
                256,
                8,
                6.2,
                4000);

        Produto laptop = new Laptop(
                "Dell",
                "Inspiron 15",
                new BigDecimal("3899.00"),
                "Intel Core i7",
                16,
                512,
                "Intel Iris Xe");

        Produto tv = new TV(
                "LG",
                "OLED C3",
                new BigDecimal("5499.99"),
                55,
                "4K UHD",
                true,
                "OLED");

        Cliente cliente = new Cliente("Carlos Eduardo Michelle Marques", "123.456.789-00");

        cliente.adicionarProdutoAoCarrinho(smartphone, 2);
        cliente.adicionarProdutoAoCarrinho(laptop, 1);
        cliente.adicionarProdutoAoCarrinho(tv, 1);

        exibirCatalogo(smartphone, laptop, tv);
        exibirCarrinho(cliente);
    }

    private static void exibirCatalogo(Produto... produtos) {
        System.out.println("=== Catálogo da Loja de Eletrônicos ===");
        for (Produto produto : produtos) {
            System.out.println(produto.exibirDetalhes());
        }
        System.out.println();
    }

    private static void exibirCarrinho(Cliente cliente) {
        NumberFormat formatador = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"));

        System.out.println("=== Carrinho de Compras ===");
        System.out.println("Cliente: " + cliente.getNome());

        for (ItemCarrinho item : cliente.getCarrinhoDeCompras().getItens()) {
            System.out.println(item.getQuantidade() + "x " + item.getProduto()
                    + " - subtotal: " + formatador.format(item.getSubtotal()));
        }

        System.out.println("Total a pagar: " + cliente.visualizarTotalCarrinho());
    }
}
