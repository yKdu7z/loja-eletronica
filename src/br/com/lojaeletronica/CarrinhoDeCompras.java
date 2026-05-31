package br.com.lojaeletronica;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class CarrinhoDeCompras {
    private final List<ItemCarrinho> itens = new ArrayList<>();

    public void adicionarProduto(Produto produto, int quantidade) {
        Optional<ItemCarrinho> itemExistente = buscarItem(produto);

        if (itemExistente.isPresent()) {
            itemExistente.get().adicionarQuantidade(quantidade);
            return;
        }

        itens.add(new ItemCarrinho(produto, quantidade));
    }

    public void removerProduto(Produto produto) {
        itens.removeIf(item -> item.getProduto().equals(produto));
    }

    public List<ItemCarrinho> getItens() {
        return Collections.unmodifiableList(itens);
    }

    public BigDecimal calcularTotal() {
        return itens.stream()
                .map(ItemCarrinho::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public String getTotalFormatado() {
        NumberFormat formatador = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"));
        return formatador.format(calcularTotal());
    }

    public boolean estaVazio() {
        return itens.isEmpty();
    }

    private Optional<ItemCarrinho> buscarItem(Produto produto) {
        return itens.stream()
                .filter(item -> item.getProduto().equals(produto))
                .findFirst();
    }
}
