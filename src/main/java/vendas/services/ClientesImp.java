package vendas.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vendas.model.Entities.ClientesEntity;
import vendas.model.Entities.VendasEntity;
import vendas.model.Responses.ClientesResponse;
import vendas.repositories.ClientesRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class ClientesImp implements ClientesService {

    private final ClientesRepository clientesRepository;

    @Autowired
    public ClientesImp(ClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }

    @Override
    public ClientesEntity findById(int id) {
        return clientesRepository.findById(id);
    }

    @Override
    public List<ClientesEntity> findByNome(String nome) {
        return clientesRepository.findByNome(nome);
    }

    @Override
    public List<ClientesResponse> findAll() {
        ArrayList<ClientesResponse> clientesResponses = new ArrayList<>();

        clientesRepository.findAll().stream().forEach(clientesEntity -> {
            ClientesResponse clientesResponse = new ClientesResponse();
            clientesResponse.setId(clientesEntity.getId());
            clientesResponse.setNome(clientesEntity.getNome());

            ArrayList<VendasEntity> vendasList = new ArrayList<>();
            clientesEntity.getVendas_id().stream().forEach(vendasEntity -> {
                VendasEntity venda = new VendasEntity();
                venda.setId(vendasEntity.getId());
                venda.setData(vendasEntity.getData());
                vendasList.add(venda);
            });
            clientesResponse.setVendas(vendasList);
            clientesResponses.add(clientesResponse);
        });
        return clientesResponses;
    }

    @Override
    public List<ClientesEntity> listAll() {
        return clientesRepository.findAll();
    }

    @Override
    public ClientesEntity add(ClientesEntity clientesEntity) {
        return clientesRepository.save(clientesEntity);
    }

    @Override
    public ClientesResponse update(int id, ClientesEntity cliente) {
        ClientesEntity update = clientesRepository.findById(id);
        update.setNome(cliente.getNome());
        ClientesResponse clienteupdated = new ClientesResponse();
        clienteupdated.setId(update.getId());
        clienteupdated.setNome(update.getNome());
        clienteupdated.setVendas(update.getVendas_id());
        clientesRepository.save(update);
        return clienteupdated;
    }


    @Override
    public void deleteByID(int id) {
        clientesRepository.delete(clientesRepository.findById(id));
    }
}
