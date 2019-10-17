package vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vendas.model.Entities.ProdutoEntity;

import java.util.List;

@Repository
public interface ProdutoRepository extends CrudRepository<ProdutoEntity, Integer> {
    public ProdutoEntity findById(int id);
    public ProdutoEntity findByNome(String nome);
    public List<ProdutoEntity> findAll();
    void delete(ProdutoEntity produtoEntity);
}
