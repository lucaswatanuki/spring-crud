package vendas.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vendas.model.Entities.ProdutoVendaEntity;
import vendas.model.Responses.ProdutoVendaResponse;
import vendas.services.ProdutoVendaService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/item_venda")
public class ProdutoVendaController {

    @Autowired
    ProdutoVendaService produtoVendaService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ProdutoVendaEntity save(@RequestBody ProdutoVendaEntity item) {
        return produtoVendaService.add(item);
    }
/*
    @GetMapping("")
    public List<ProdutoVendaResponse> listAll() {
        return produtoVendaService.findAll();
    }

    @GetMapping("/{id}")
    public ProdutoVendaEntity getID(@PathVariable("id") int id) {
        return produtoVendaService.findById(id);
    }
*/
    @PutMapping("/{id}")
    public ProdutoVendaResponse update(@PathVariable("id") int id, @RequestBody ProdutoVendaEntity item) {
        return produtoVendaService.update(id, item);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        produtoVendaService.deleteByID(id);
    }
}
