package com.estoque.produtobackend.fornecedor;

import com.estoque.produtobackend.estoque.Estoque;
import com.estoque.produtobackend.estoque.EstoqueDto;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

@Data
public class FornecedorDto {
    private Long idFornecedor ;
    private String NomeDoFornecedor;

    public static FornecedorDto from(Fornecedor fornecedor){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(fornecedor, FornecedorDto.class);
    }
}
