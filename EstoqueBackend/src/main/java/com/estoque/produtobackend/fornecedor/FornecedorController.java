package com.estoque.produtobackend.fornecedor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService service;

    @GetMapping
    public ResponseEntity<List<FornecedorDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{idFornecedor}")
    public ResponseEntity<FornecedorDto> findById(@PathVariable Long idFornecedor) {
        return ResponseEntity.ok(service.findById(idFornecedor));
    }

    @PostMapping
    @Column(unique = true)
    public ResponseEntity<FornecedorDto> create(@RequestBody FornecedorForm fornecedorForm) {
        return ResponseEntity.ok(service.create(fornecedorForm));
    }

    @PutMapping("/{idFornecedor}")
    public ResponseEntity<FornecedorDto> update(@PathVariable Long idFornecedor, @RequestBody @Valid FornecedorForm fornecedorForm) {
        return ResponseEntity.ok(service.update(idFornecedor, fornecedorForm));
    }

    @DeleteMapping("/{idFornecedor}")
    public ResponseEntity<?> delete(@PathVariable Long idFornecedor) {
        service.delete(idFornecedor);
        return ResponseEntity.ok().build();
    }
}
