package com.estoque.produtobackend.estoque;

import com.estoque.produtobackend.produto.ProdutoForm;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
@Data
public class EstoqueDto {

    private Long idEstoque;
    private int estoque;
    private ProdutoForm produto;

    public static EstoqueDto from(Estoque estoque){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(estoque, EstoqueDto.class);
    }
}
