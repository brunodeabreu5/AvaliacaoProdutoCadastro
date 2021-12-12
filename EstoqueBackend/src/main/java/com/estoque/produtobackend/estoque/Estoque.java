package com.estoque.produtobackend.estoque;

import com.estoque.produtobackend.produto.Produto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import javax.persistence.*;

@Entity
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEstoque;

    private int estoque;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Produto produto;

    public Estoque(long idEstoque, int estoque, Produto produto) {
        this.idEstoque = idEstoque;
        this.estoque = estoque;
        this.produto = produto;
    }

    public Estoque(){}

    public Estoque(Produto produto, Integer estoque) {

    }

    public long getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(long idEstoque) {
        this.idEstoque = idEstoque;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public static Estoque from(EstoqueForm form){
        ModelMapper modelMapper =new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(form, Estoque.class);
    }
}
