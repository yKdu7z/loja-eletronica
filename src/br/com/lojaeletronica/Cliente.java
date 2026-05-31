package br.com.lojaeletronica;

public class Cliente {
    private final String nome;
    private final String cpf;
    private final CarrinhoDeCompras carrinhoDeCompras;

    public Cliente(String nome, String cpf) {
        this.nome = validarTexto(nome, "nome");
        this.cpf = validarTexto(cpf, "CPF");
        this.carrinhoDeCompras = new CarrinhoDeCompras();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public CarrinhoDeCompras getCarrinhoDeCompras() {
        return carrinhoDeCompras;
    }

    public void adicionarProdutoAoCarrinho(Produto produto, int quantidade) {
        carrinhoDeCompras.adicionarProduto(produto, quantidade);
    }

    public String visualizarTotalCarrinho() {
        return carrinhoDeCompras.getTotalFormatado();
    }

    private static String validarTexto(String valor, String campo) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException("O campo " + campo + " é obrigatório.");
        }

        return valor.trim();
    }
}
