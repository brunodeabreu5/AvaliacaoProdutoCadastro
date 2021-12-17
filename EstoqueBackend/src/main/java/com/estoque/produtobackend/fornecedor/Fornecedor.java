package com.estoque.produtobackend.fornecedor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
public class Fornecedor {

    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Long idFornecedor ;
    private String NomeDoFornecedor;

    public static Fornecedor from(FornecedorForm form){
        ModelMapper modelMapper =new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(form, Fornecedor.class);
    }
}
