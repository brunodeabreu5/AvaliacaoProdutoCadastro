package com.estoque.produtobackend.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Column;
import javax.validation.Valid;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    @Column(unique= true)
    public ResponseEntity<ProdutoDto> create(@RequestBody @Valid ProdutoForm produtoForm){
        return ResponseEntity.ok(service.create(produtoForm));
    }

}
