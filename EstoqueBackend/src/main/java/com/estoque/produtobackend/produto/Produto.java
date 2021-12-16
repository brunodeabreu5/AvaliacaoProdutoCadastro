package com.estoque.produtobackend.produto;

import com.estoque.produtobackend.estoque.Estoque;
import com.estoque.produtobackend.fornecedor.Fornecedor;
import com.estoque.produtobackend.tipoDeProduto.TipoDeProduto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import javax.persistence.*;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  idproduto;
    private String nomeProduto;
    @ManyToOne
    private Fornecedor fornecedor;
    @ManyToOne
    private TipoDeProduto tipoDeProduto;
    private Double precoVenda;
    private Double precoDeCompra;
    @ManyToOne
    @JoinColumn(name = "estoque_id")
    private Estoque estoque;

    public static Produto from(ProdutoForm form){
        ModelMapper modelMapper =new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(form, Produto.class);
    }
}
