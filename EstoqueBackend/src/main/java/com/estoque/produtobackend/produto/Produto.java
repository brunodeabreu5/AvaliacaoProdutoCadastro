package com.estoque.produtobackend.produto;

import com.estoque.produtobackend.fornecedor.Fornecedor;
import com.estoque.produtobackend.tipoDeProduto.TipoDeProduto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
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
    private Integer quantidade;


    public static Produto from(ProdutoForm form){
        ModelMapper modelMapper =new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(form, Produto.class);
    }

}
