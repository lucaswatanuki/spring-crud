package vendas.services;

import vendas.model.Entities.VendasEntity;
import vendas.model.Responses.VendasResponse;

import java.util.List;
import java.util.Optional;

public interface VendasService {
    public VendasEntity findById(int id);

    public List<VendasResponse> findAll();

    List<VendasEntity> listAll();

    public VendasEntity add(VendasEntity vendasEntity);

    VendasResponse update(int id, VendasEntity vendas);

    public void deleteByID(int id);
}
