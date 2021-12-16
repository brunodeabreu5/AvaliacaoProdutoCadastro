package com.estoque.produtobackend.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;
    @Autowired
    private final EntityManager manager;

    public ProdutoController(EntityManager manager) {
        this.manager = manager;
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{idProduto}")
    public ResponseEntity<ProdutoDto> findById(@PathVariable Long idProduto) {
        return ResponseEntity.ok(service.findById(idProduto));
    }

    @PostMapping
    @Column(unique = true)
    public ResponseEntity<ProdutoDto> create(@RequestBody @Valid ProdutoForm produtoForm) {
        return ResponseEntity.ok(service.create(produtoForm));
    }

    /*@PostMapping("/{id}/estoque")
    @Transactional
    public ResponseEntity<?> EntradaEstoque(@RequestBody @Valid EstoqueRequest entrada, @PathVariable Long id, UriComponentsBuilder uriComponentsBuilder){
        Optional<ProdutoDto> produto = service.findById(id);
        if(produto.isEmpty()){
            Error error = new Error("Produto","Não existe cadastro deste produto");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
        Estoque estoque=entrada(produto.get());
        manager.persist(estoque);
        produto.get().
    }*/

    @PutMapping("/{idProduto}")
    public ResponseEntity<ProdutoDto> update(@PathVariable Long idProduto, @RequestBody @Valid ProdutoForm produtoForm) {
        return ResponseEntity.ok(service.update(idProduto, produtoForm));
    }

    @DeleteMapping("/{idProduto}")
    public ResponseEntity<?> delete(@PathVariable Long idProduto) {
        service.delete(idProduto);
        return ResponseEntity.ok().build();
    }

}
