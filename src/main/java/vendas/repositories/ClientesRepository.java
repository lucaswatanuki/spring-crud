package vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vendas.model.Entities.ClientesEntity;

import java.util.List;

@Repository
public interface ClientesRepository extends CrudRepository<ClientesEntity, Integer> {

    public ClientesEntity findById(int id);

    public List<ClientesEntity> findByNome(String nome);

    List<ClientesEntity> findAll();

    ClientesEntity save(ClientesEntity clientesEntity);

    void delete(ClientesEntity clientesEntity);
}
