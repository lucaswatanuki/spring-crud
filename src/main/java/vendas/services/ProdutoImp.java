package vendas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vendas.model.Entities.ProdutoEntity;
import vendas.model.Responses.ProdutoResponse;
import vendas.repositories.ProdutoRepository;

import java.util.List;


@Service
public class ProdutoImp implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoImp(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public ProdutoEntity findById(int id) {
        return produtoRepository.findById(id);
    }

    @Override
    public ProdutoEntity findByNome(String nome) {
        return produtoRepository.findByNome(nome);
    }

    @Override
    public List<ProdutoEntity> findAll() {
        return produtoRepository.findAll();
    }

    @Override
    public List<ProdutoEntity> listAll() {
        return produtoRepository.findAll();
    }

    @Override
    public ProdutoEntity add(ProdutoEntity produtoEntity) {
        return produtoRepository.save(produtoEntity);
    }

    @Override
    public ProdutoResponse update(int id, ProdutoEntity produto) {
        ProdutoEntity update = produtoRepository.findById(id);
        update.setNome(produto.getNome());
        update.setPreco(produto.getPreco());
        ProdutoResponse produtoResponse = new ProdutoResponse();
        produtoResponse.setNome(update.getNome());
        produtoResponse.setPreco(update.getPreco());
        produtoRepository.save(update);
        return produtoResponse;
    }

    @Override
    public void deleteByID(int id) {
        produtoRepository.delete(produtoRepository.findById(id));
    }
}
