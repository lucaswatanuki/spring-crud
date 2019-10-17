package vendas.services;

import vendas.model.Entities.ProdutoVendaEntity;
import vendas.model.Responses.ProdutoVendaResponse;

import java.util.List;


public interface ProdutoVendaService {
    public ProdutoVendaEntity findById(int id);

    public List<ProdutoVendaResponse> findAll();

    List<ProdutoVendaEntity> listAll();

    public ProdutoVendaEntity add(ProdutoVendaEntity produtoVendaEntity);

    ProdutoVendaResponse update(int id, ProdutoVendaEntity item);


    public void deleteByID(int id);}
