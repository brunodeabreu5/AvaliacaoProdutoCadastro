package com.estoque.produtobackend.produto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDto {

    private int idproduto;
    private String nomeProduto;
    private Double precoVenda;
    private Double precoDeCompra;

    public static ProdutoDto from (Produto produto){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(produto, ProdutoDto.class);
    }
}
