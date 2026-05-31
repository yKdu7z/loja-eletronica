package br.com.lojaeletronica;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

public abstract class Produto {
    private final String marca;
    private final String modelo;
    private final BigDecimal preco;

    protected Produto(String marca, String modelo, BigDecimal preco) {
        if (preco == null || preco.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("O preço do produto não pode ser negativo.");
        }

        this.marca = validarTexto(marca, "marca");
        this.modelo = validarTexto(modelo, "modelo");
        this.preco = preco;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getPrecoFormatado() {
        NumberFormat formatador = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"));
        return formatador.format(preco);
    }

    public abstract String getCategoria();

    public abstract String getEspecificacoesTecnicas();

    public String exibirDetalhes() {
        return getCategoria() + " | " + marca + " " + modelo + " | " + getPrecoFormatado()
                + " | " + getEspecificacoesTecnicas();
    }

    private static String validarTexto(String valor, String campo) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException("O campo " + campo + " é obrigatório.");
        }

        return valor.trim();
    }

    @Override
    public String toString() {
        return getCategoria() + " " + marca + " " + modelo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Produto outroProduto)) {
            return false;
        }

        return marca.equalsIgnoreCase(outroProduto.marca)
                && modelo.equalsIgnoreCase(outroProduto.modelo)
                && getCategoria().equalsIgnoreCase(outroProduto.getCategoria());
    }

    @Override
    public int hashCode() {
        return Objects.hash(marca.toLowerCase(Locale.ROOT), modelo.toLowerCase(Locale.ROOT), getCategoria());
    }
}
