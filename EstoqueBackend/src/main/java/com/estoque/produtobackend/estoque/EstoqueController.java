package com.estoque.produtobackend.estoque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/estoque")

public class EstoqueController {

    @Autowired
    private EstoqueService service;

    @GetMapping
    public ResponseEntity<List<EstoqueDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstoqueDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<EstoqueDto> create(@RequestBody @Valid EstoqueForm estoqueForm) {
        return ResponseEntity.ok(service.create(estoqueForm));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstoqueDto> update(@PathVariable Long id, @RequestBody @Valid EstoqueForm estoqueForm) {
        return ResponseEntity.ok(service.update(id, estoqueForm));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
