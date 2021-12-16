package com.estoque.produtobackend.estoque;

import com.estoque.produtobackend.produto.Produto;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import javax.persistence.*;


@Entity
@Data
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstoque;
    private int estoque;

    @ManyToOne
    private Produto produto;

    public static Estoque from(EstoqueForm form){
        ModelMapper modelMapper =new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(form, Estoque.class);
    }
}
