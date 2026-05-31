package br.com.lojaeletronica;

import java.math.BigDecimal;

public class Smartphone extends Produto {
    private final int armazenamentoGb;
    private final int memoriaRamGb;
    private final double tamanhoTelaPolegadas;
    private final int capacidadeBateriaMah;

    public Smartphone(
            String marca,
            String modelo,
            BigDecimal preco,
            int armazenamentoGb,
            int memoriaRamGb,
            double tamanhoTelaPolegadas,
            int capacidadeBateriaMah) {
        super(marca, modelo, preco);
        this.armazenamentoGb = validarPositivo(armazenamentoGb, "armazenamento");
        this.memoriaRamGb = validarPositivo(memoriaRamGb, "memoria RAM");
        this.tamanhoTelaPolegadas = validarPositivo(tamanhoTelaPolegadas, "tamanho da tela");
        this.capacidadeBateriaMah = validarPositivo(capacidadeBateriaMah, "capacidade da bateria");
    }

    @Override
    public String getCategoria() {
        return "Smartphone";
    }

    @Override
    public String getEspecificacoesTecnicas() {
        return armazenamentoGb + "GB armazenamento, " + memoriaRamGb + "GB RAM, tela "
                + tamanhoTelaPolegadas + "\", bateria " + capacidadeBateriaMah + "mAh";
    }

    private static int validarPositivo(int valor, String campo) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O campo " + campo + " deve ser maior que zero.");
        }

        return valor;
    }

    private static double validarPositivo(double valor, String campo) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O campo " + campo + " deve ser maior que zero.");
        }

        return valor;
    }
}
