package vendas.model.Responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import vendas.model.Entities.ClientesEntity;
import vendas.model.Entities.ProdutoVendaEntity;

import java.util.List;

@Data
public class VendasResponse {

    private Integer id;

    private String data;

    private int cliente_id;

    private List<ProdutoVendaResponse> item;

    public VendasResponse() {
    }

    public VendasResponse(Integer id, String data) {
        this.id = id;
        this.data = data;
    }
}
