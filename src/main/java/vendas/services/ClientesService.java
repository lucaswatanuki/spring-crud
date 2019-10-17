package vendas.services;

import org.springframework.stereotype.Service;
import vendas.model.Entities.ClientesEntity;
import vendas.model.Responses.ClientesResponse;

import java.util.List;

public interface ClientesService {
    ClientesEntity findById(int id);

    List<ClientesEntity> findByNome(String nome);

    List<ClientesResponse> findAll();

    List<ClientesEntity> listAll();

    ClientesEntity add(ClientesEntity clientesEntity);

    ClientesResponse update(int id, ClientesEntity clientesEntity);

    public void deleteByID(int id);}
