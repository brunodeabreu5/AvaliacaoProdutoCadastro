package com.estoque.produtobackend.fornecedor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FornecedorDto {
    private Long idFornecedor ;
    private String NomeDoFornecedor;

    public static FornecedorDto from(Fornecedor fornecedor){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(fornecedor, FornecedorDto.class);
    }
}
