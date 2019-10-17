package vendas.model.Responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.bind.annotation.ResponseBody;
import vendas.model.Entities.VendasEntity;

import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;


@Data
public class ClientesResponse {
    private Integer id;

    private String nome;

    private List<VendasEntity> vendas;

    public ClientesResponse() {
    }

    public ClientesResponse(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
