package com.estoque.produtobackend.produto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoForm {

    private String nomeProduto;
    private Double precoVenda;
    private Double precoDeCompra;
}
