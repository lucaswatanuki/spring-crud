package vendas.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vendas.model.Entities.ProdutoEntity;
import vendas.model.Responses.ProdutoResponse;
import vendas.services.ProdutoService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ProdutoEntity save(@RequestBody ProdutoEntity produtoEntity) {
        return produtoService.add(produtoEntity);
    }
/*
    @GetMapping("")
    public List<ProdutoEntity> listAll() {
        return produtoService.findAll();
    }

    @GetMapping("/nome")
    public ProdutoEntity getNome(@RequestParam(value = "nome") String nome) {
        if (nome != null) {
            return produtoService.findByNome(nome);
        } else throw new IllegalArgumentException("ProdutoEntity não cadastrado");
    }

    @GetMapping("/{id}")
    public ProdutoEntity getID(@PathVariable("id") int id) {
        return produtoService.findById(id);
    }
*/
    @PutMapping("/{id}")
    public ProdutoResponse update(@PathVariable("id") int id, @RequestBody ProdutoEntity produtoEntity) {
        return produtoService.update(id, produtoEntity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        produtoService.deleteByID(id);
    }
}
