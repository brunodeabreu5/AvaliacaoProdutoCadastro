package com.estoque.produtobackend.produto;

import com.estoque.produtobackend.estoque.Estoque;
import com.estoque.produtobackend.estoque.EstoqueForm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private long  idproduto;
    private String nomeProduto;
    private Double precoVenda;
    private Double precoDeCompra;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private List<Estoque> estoques = new ArrayList<>();

    public static Produto from(ProdutoForm form){
        ModelMapper modelMapper =new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(form, Produto.class);
    }


}
