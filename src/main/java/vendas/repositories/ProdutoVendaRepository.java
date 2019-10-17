package vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vendas.model.Entities.ProdutoVendaEntity;

import java.util.List;

@Repository
public interface ProdutoVendaRepository extends JpaRepository<ProdutoVendaEntity, Integer> {
    public ProdutoVendaEntity findById(int id);
    public List<ProdutoVendaEntity> findAll();
    void delete(ProdutoVendaEntity produtoVendaEntity);
}
