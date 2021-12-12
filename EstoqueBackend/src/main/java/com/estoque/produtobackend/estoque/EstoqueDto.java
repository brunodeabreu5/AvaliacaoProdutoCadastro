package com.estoque.produtobackend.estoque;

import com.estoque.produtobackend.produto.Produto;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import javax.persistence.*;
@Data
public class EstoqueDto {

    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private long idEstoque;
    private int estoque;

    @ManyToOne
    @JoinColumn(name="produto_id")
    private Produto produto;

    public static EstoqueDto from(Estoque estoque){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(estoque, EstoqueDto.class);
    }
}
