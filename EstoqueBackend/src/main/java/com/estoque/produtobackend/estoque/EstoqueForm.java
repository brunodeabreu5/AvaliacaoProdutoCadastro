package com.estoque.produtobackend.estoque;

import com.estoque.produtobackend.produto.ProdutoForm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstoqueForm {

    private int estoque;
    private ProdutoForm produto;

}
