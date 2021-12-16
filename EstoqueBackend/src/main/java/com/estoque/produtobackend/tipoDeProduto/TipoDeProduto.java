package com.estoque.produtobackend.tipoDeProduto;

import lombok.Data;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class TipoDeProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoDeProduto;
    private String tipoDeProduto;

    public static TipoDeProduto from(TipoDeProdutoForm form) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(form, TipoDeProduto.class);
    }
}
