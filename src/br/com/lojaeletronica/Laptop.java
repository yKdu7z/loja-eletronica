package br.com.lojaeletronica;

import java.math.BigDecimal;

public class Laptop extends Produto {
    private final String processador;
    private final int memoriaRamGb;
    private final int armazenamentoSsdGb;
    private final String placaDeVideo;

    public Laptop(
            String marca,
            String modelo,
            BigDecimal preco,
            String processador,
            int memoriaRamGb,
            int armazenamentoSsdGb,
            String placaDeVideo) {
        super(marca, modelo, preco);
        this.processador = validarTexto(processador, "processador");
        this.memoriaRamGb = validarPositivo(memoriaRamGb, "memoria RAM");
        this.armazenamentoSsdGb = validarPositivo(armazenamentoSsdGb, "armazenamento SSD");
        this.placaDeVideo = validarTexto(placaDeVideo, "placa de vídeo");
    }

    @Override
    public String getCategoria() {
        return "Laptop";
    }

    @Override
    public String getEspecificacoesTecnicas() {
        return processador + ", " + memoriaRamGb + "GB RAM, SSD " + armazenamentoSsdGb
                + "GB, vídeo " + placaDeVideo;
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
