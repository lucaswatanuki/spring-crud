package vendas.services;

import vendas.model.Entities.ProdutoEntity;
import vendas.model.Responses.ProdutoResponse;

import java.util.List;

public interface ProdutoService {
    public ProdutoEntity findById(int id);

    public ProdutoEntity findByNome(String nome);

    public List<ProdutoEntity> findAll();

    List<ProdutoEntity> listAll();

    public ProdutoEntity add(ProdutoEntity produtoEntity);

    ProdutoResponse update(int id, ProdutoEntity produto);

    public void deleteByID(int id);}
