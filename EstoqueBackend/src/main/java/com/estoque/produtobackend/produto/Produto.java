package com.estoque.produtobackend.produto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private int idproduto;
    private String nomeProduto;
    private Double precoVenda;
    private Double precoDeCompra;

    public static Produto from (ProdutoForm produtoFrom){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(produtoFrom, Produto.class);
    }

}
