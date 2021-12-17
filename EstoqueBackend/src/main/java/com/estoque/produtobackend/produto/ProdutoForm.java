package com.estoque.produtobackend.produto;

import com.estoque.produtobackend.fornecedor.Fornecedor;
import com.estoque.produtobackend.fornecedor.FornecedorDto;
import com.estoque.produtobackend.tipoDeProduto.TipoDeProduto;
import com.estoque.produtobackend.tipoDeProduto.TipoDeProdutoDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoForm {

    private String nomeProduto;
    private Integer quantidade;
    private Double precoVenda;
    private Double precoDeCompra;
    private TipoDeProduto tipoDeProduto;
    private Fornecedor fornecedor;
}
