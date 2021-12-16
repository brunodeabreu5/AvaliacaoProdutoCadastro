package com.estoque.produtobackend.tipoDeProduto;

import lombok.Data;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
@Data
public class TipoDeProdutoDto {

    private Long idTipoDeProduto;
    private String tipoDeProduto;

    public static TipoDeProdutoDto from(TipoDeProduto tipoDeProduto){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(tipoDeProduto, TipoDeProdutoDto.class);
    }
}
