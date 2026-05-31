package br.com.lojaeletronica;

import java.math.BigDecimal;

public class TV extends Produto {
    private final int tamanhoPolegadas;
    private final String resolucao;
    private final boolean smartTv;
    private final String tecnologiaTela;

    public TV(
            String marca,
            String modelo,
            BigDecimal preco,
            int tamanhoPolegadas,
            String resolucao,
            boolean smartTv,
            String tecnologiaTela) {
        super(marca, modelo, preco);
        this.tamanhoPolegadas = validarPositivo(tamanhoPolegadas, "tamanho da TV");
        this.resolucao = validarTexto(resolucao, "resolução");
        this.smartTv = smartTv;
        this.tecnologiaTela = validarTexto(tecnologiaTela, "tecnologia da tela");
    }

    @Override
    public String getCategoria() {
        return "TV";
    }

    @Override
    public String getEspecificacoesTecnicas() {
        String conectividade = smartTv ? "Smart TV" : "TV convencional";
        return tamanhoPolegadas + "\", " + resolucao + ", " + tecnologiaTela + ", " + conectividade;
    }

    private static String validarTexto(String valor, String campo) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException("O campo " + campo + " é obrigatório.");
        }

        return valor.trim();
    }

    private static int validarPositivo(int valor, String campo) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O campo " + campo + " deve ser maior que zero.");
        }

        return valor;
    }
}
