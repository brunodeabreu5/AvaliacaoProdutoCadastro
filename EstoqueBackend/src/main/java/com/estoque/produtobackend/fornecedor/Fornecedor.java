package com.estoque.produtobackend.fornecedor;

import com.estoque.produtobackend.estoque.Estoque;
import com.estoque.produtobackend.estoque.EstoqueForm;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
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
