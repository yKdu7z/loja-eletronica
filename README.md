# Loja Eletrônica - Trabalho de POO

Sistema em Java para modelar uma loja de eletrônicos com produtos, cliente e carrinho de compras.

## Requisitos

- Java JDK 17 ou superior

## Como executar

```powershell
javac -encoding UTF-8 -d out src/br/com/lojaeletronica/*.java
java -cp out br.com.lojaeletronica.Main
```

## Estrutura

- `Produto`: classe base abstrata dos produtos.
- `Smartphone`, `Laptop` e `TV`: classes derivadas com atributos específicos.
- `Cliente`: representa o cliente da loja.
- `CarrinhoDeCompras`: armazena os produtos escolhidos e calcula o total.
- `ItemCarrinho`: associa produto e quantidade.

## Repositório

GitHub: https://github.com/yKdu7z/loja-eletronica
