package com.estoque.produtobackend.estoque;

import com.estoque.produtobackend.produto.Produto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class EstoqueRequest {
    @NotNull
    @Positive
    private Integer estoque;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private String dataEntrada;

    public Estoque toModelo(Produto produto){
        @PastOrPresent
        LocalDateTime data=LocalDateTime.parse(dataEntrada, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        return new Estoque(produto,estoque);
    }
}
