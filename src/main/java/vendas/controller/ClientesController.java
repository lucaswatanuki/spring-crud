package vendas.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import vendas.model.Entities.ClientesEntity;
import vendas.model.Responses.ClientesResponse;
import vendas.services.ClientesService;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    ClientesService clientesService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ClientesEntity save(@RequestBody ClientesEntity clientesEntity) {
        return clientesService.add(clientesEntity);
    }


/*
    @GetMapping("/all")
    public List<ClientesResponse> listAll() {
        return clientesService.findAll();
    }

    @GetMapping("/nome")
    public List<ClientesEntity> findByNome(@RequestParam(value = "nome") String nome) {
        if (nome != null) {
            return clientesService.findByNome(nome);
        } else throw new IllegalArgumentException("Informar um nome válido");
    }

    @GetMapping("/{id}")
    public ClientesEntity findByID(@PathVariable("id") int id) {
        return clientesService.findById(id);
    }
*/
    @PutMapping("/{id}")
    public ClientesResponse update(@PathVariable("id") int id, @RequestBody ClientesEntity cliente) {
        return clientesService.update(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        clientesService.deleteByID(id);
    }
}
