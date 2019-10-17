package vendas.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vendas.model.Entities.ProdutoEntity;
import vendas.model.Entities.ProdutoVendaEntity;
import vendas.model.Entities.VendasEntity;
import vendas.model.Responses.ProdutoVendaResponse;
import vendas.repositories.ProdutoVendaRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProdutoVendaImp implements ProdutoVendaService {

    private final ProdutoVendaRepository produtoVendaRepository;

    @Autowired
    public ProdutoVendaImp(ProdutoVendaRepository produtoVendaRepository) {
        this.produtoVendaRepository = produtoVendaRepository;
    }

    @Override
    public ProdutoVendaEntity findById(int id) {
        return produtoVendaRepository.findById(id);
    }

    @Override
    public List<ProdutoVendaResponse> findAll() {
        List<ProdutoVendaResponse> itens = new ArrayList<>();

        produtoVendaRepository.findAll().forEach(produtoVendaEntity -> {
            ProdutoVendaResponse itemResponse = new ProdutoVendaResponse();
            itemResponse.setId(produtoVendaEntity.getId());
            itemResponse.setQuantidade(produtoVendaEntity.getQuantidade());
            itemResponse.setValor(produtoVendaEntity.getValor());
          //  itemResponse.setProduto_id(produtoVendaEntity.getProduto().getId());
          //  itemResponse.setVenda_id(produtoVendaEntity.getVenda().getId());
            itens.add(itemResponse);
        });
        return itens;
    }

    @Override
    public List<ProdutoVendaEntity> listAll() {
        return produtoVendaRepository.findAll();
    }

    @Override
    public ProdutoVendaEntity add(ProdutoVendaEntity produtoVendaEntity) {
        return produtoVendaRepository.save(produtoVendaEntity);
    }

    @Override
    public ProdutoVendaResponse update(int id, ProdutoVendaEntity item) {
        ProdutoVendaEntity update = produtoVendaRepository.findById(id);
        update.setQuantidade(item.getQuantidade());
        update.setValor(item.getValor());
        update.setVenda(item.getVenda());
        update.setProduto(item.getProduto());
        ProdutoVendaResponse itemupdated = new ProdutoVendaResponse();
        itemupdated.setQuantidade(update.getQuantidade());
        itemupdated.setValor(update.getValor());
        itemupdated.setProduto_id(update.getProduto().getId());
        itemupdated.setVenda_id(update.getVenda().getId());
        produtoVendaRepository.save(update);
        return itemupdated;
    }

    @Override
    public void deleteByID(int id) {
        produtoVendaRepository.delete(produtoVendaRepository.findById(id));
    }
}
