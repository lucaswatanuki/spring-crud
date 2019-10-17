package vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vendas.model.Entities.VendasEntity;
import vendas.model.Responses.VendasResponse;

import java.util.List;

@Repository
public interface VendasRepository extends JpaRepository<VendasEntity, Integer> {
   VendasEntity findById(int id);
   List<VendasEntity> findAll();
   VendasEntity save(VendasEntity vendasEntity);
   void delete(VendasEntity vendasEntity);
}
