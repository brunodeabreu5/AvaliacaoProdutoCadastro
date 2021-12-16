package com.estoque.produtobackend.tipoDeProduto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/tipodeproduto")
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

    @GetMapping("/{tipodeproduto}")
    public ResponseEntity<TipoDeProdutoDto> findById(@PathVariable Long tipodeproduto) {
        return ResponseEntity.ok(service.findById(tipodeproduto));
    }

    @PostMapping
    @Column(unique = true)
    public ResponseEntity<TipoDeProdutoDto> create(@RequestBody @Valid TipoDeProdutoForm tipoDeProdutoForm) {
        return ResponseEntity.ok(service.create(tipoDeProdutoForm));
    }

    @PutMapping("/{tipodeproduto}")
    public ResponseEntity<TipoDeProdutoDto> update(@PathVariable Long tipodeproduto, @RequestBody @Valid TipoDeProdutoForm tipoDeProdutoForm) {
        return ResponseEntity.ok(service.update(tipodeproduto, tipoDeProdutoForm));
    }

    @DeleteMapping("/{tipodeproduto}")
    public ResponseEntity<?> delete(@PathVariable Long idFornecedor) {
        service.delete(idFornecedor);
        return ResponseEntity.ok().build();
    }
}
