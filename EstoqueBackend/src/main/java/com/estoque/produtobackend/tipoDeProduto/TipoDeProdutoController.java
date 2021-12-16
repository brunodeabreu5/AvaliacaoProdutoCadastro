package com.estoque.produtobackend.tipoDeProduto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import javax.validation.Valid;
import java.util.List;

public class TipoDeProdutoController {

    @Autowired
    private TipoDeProdutoService service;
   /* @Autowired
    private final EntityManager manager;

    public ProdutoController(EntityManager manager) {
        this.manager = manager;
    }
*/
    @GetMapping
    public ResponseEntity<List<TipoDeProdutoDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{idFornecedor}")
    public ResponseEntity<TipoDeProdutoDto> findById(@PathVariable Long idFornecedor) {
        return ResponseEntity.ok(service.findById(idFornecedor));
    }

    @PostMapping
    @Column(unique = true)
    public ResponseEntity<TipoDeProdutoDto> create(@RequestBody @Valid TipoDeProdutoForm tipoDeProdutoForm) {
        return ResponseEntity.ok(service.create(tipoDeProdutoForm));
    }

    @PutMapping("/{idFornecedor}")
    public ResponseEntity<TipoDeProdutoDto> update(@PathVariable Long idFornecedor, @RequestBody @Valid TipoDeProdutoForm tipoDeProdutoForm) {
        return ResponseEntity.ok(service.update(idFornecedor, tipoDeProdutoForm));
    }

    @DeleteMapping("/{idFornecedor}")
    public ResponseEntity<?> delete(@PathVariable Long idFornecedor) {
        service.delete(idFornecedor);
        return ResponseEntity.ok().build();
    }
}
