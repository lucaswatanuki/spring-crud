package vendas.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vendas.model.Entities.ProdutoVendaEntity;
import vendas.model.Entities.VendasEntity;
import vendas.model.Responses.ProdutoVendaResponse;
import vendas.model.Responses.VendasResponse;
import vendas.repositories.VendasRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class VendaImp implements VendasService {

    private final VendasRepository vendasRepository;

    @Autowired
    public VendaImp(VendasRepository vendasRepository) {
        this.vendasRepository = vendasRepository;
    }

    @Override
    public VendasEntity findById(int id) {
        return vendasRepository.findById(id);
    }

    @Override
    public List<VendasResponse> findAll() {
        List<VendasResponse> vendasResponses = new ArrayList<>();

        for(VendasEntity vendasEntity: vendasRepository.findAll()){
            VendasResponse vendasResponse = new VendasResponse();
            vendasResponse.setId(vendasEntity.getId());
            vendasResponse.setData(vendasEntity.getData());
            vendasResponse.setCliente_id(vendasEntity.getId());

            List<ProdutoVendaResponse> items = new ArrayList<>();
            for(ProdutoVendaEntity produtoVendaEntity : vendasEntity.getItemVenda()){
                ProdutoVendaResponse produto = new ProdutoVendaResponse();
                produto.setId(produtoVendaEntity.getId());
                produto.setValor(produtoVendaEntity.getValor());
                produto.setQuantidade(produtoVendaEntity.getQuantidade());
                items.add(produto);
            }
            vendasResponse.setItem(items);
            vendasResponses.add(vendasResponse);
        }
        return vendasResponses;
    }

    @Override
    public List<VendasEntity> listAll() {
        return vendasRepository.findAll();
    }

    @Override
    public VendasEntity add(VendasEntity vendasEntity) {
        return vendasRepository.save(vendasEntity);
    }

    @Override
    public VendasResponse update(int id, VendasEntity vendas) {
        VendasEntity update = new VendasEntity();
        update.setData(vendas.getData());
        update.setClientes(vendas.getClientes());
        update.setItemVenda(vendas.getItemVenda());
        VendasResponse vendasupdate = new VendasResponse();
        vendasupdate.setData(update.getData());
        vendasupdate.setCliente_id(update.getClientes().getId());
        vendasRepository.save(update);
        return vendasupdate;
    }

    @Override
    public void deleteByID(int id) {
        vendasRepository.delete(vendasRepository.findById(id));
    }
}
