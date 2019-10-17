package vendas.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vendas.model.Entities.ClientesEntity;
import vendas.model.Entities.VendasEntity;
import vendas.model.Responses.VendasResponse;
import vendas.services.VendasService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/vendas")
public class VendasController {

    @Autowired
    VendasService vendasService;


    @PostMapping("/add")
    public VendasEntity save(@RequestBody VendasEntity venda) {
        return vendasService.add(venda);
    }
/*
    @GetMapping
    public List<VendasResponse> listAll() {
        return vendasService.findAll();
    }

    @GetMapping("/{id}")
    public VendasEntity getID(@PathVariable("id") int id) {
        return vendasService.findById(id);
    }
*/
    @PutMapping("/{id}")
    public VendasResponse update(@PathVariable("id") int id, @RequestBody VendasEntity vendasEntity) {
        return vendasService.update(id, vendasEntity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        vendasService.deleteByID(id);
    }
}
