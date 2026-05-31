package br.com.lojaeletronica;

import java.math.BigDecimal;

public class ItemCarrinho {
    private final Produto produto;
    private int quantidade;

    public ItemCarrinho(Produto produto, int quantidade) {
        if (produto == null) {
            throw new IllegalArgumentException("O produto é obrigatório.");
        }

        this.produto = produto;
        alterarQuantidade(quantidade);
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void adicionarQuantidade(int quantidade) {
        validarQuantidade(quantidade);
        this.quantidade += quantidade;
    }

    public void alterarQuantidade(int quantidade) {
        validarQuantidade(quantidade);
        this.quantidade = quantidade;
    }

    public BigDecimal getSubtotal() {
        return produto.getPreco().multiply(BigDecimal.valueOf(quantidade));
    }

    private static void validarQuantidade(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }
    }
}
