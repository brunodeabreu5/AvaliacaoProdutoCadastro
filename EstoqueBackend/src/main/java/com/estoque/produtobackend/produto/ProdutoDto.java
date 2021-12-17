package com.estoque.produtobackend.produto;

import com.estoque.produtobackend.fornecedor.Fornecedor;
import com.estoque.produtobackend.fornecedor.FornecedorDto;
import com.estoque.produtobackend.tipoDeProduto.TipoDeProduto;
import com.estoque.produtobackend.tipoDeProduto.TipoDeProdutoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDto {


    private Long idproduto;
    private String nomeProduto;
    private Double precoVenda;
    private Integer quantidade;
    private Double precoDeCompra;

    private TipoDeProduto tipoDeProduto;

    private Fornecedor fornecedor;

    public static ProdutoDto from (Produto produto){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(produto, ProdutoDto.class);
    }
}
