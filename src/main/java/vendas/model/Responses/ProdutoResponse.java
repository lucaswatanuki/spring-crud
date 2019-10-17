package vendas.model.Responses;

import lombok.Data;
import vendas.model.Entities.ProdutoVendaEntity;

import java.util.List;

@Data
public class ProdutoResponse {
    private int id;
    private String nome;
    private String preco;

    public ProdutoResponse(int id, String nome, String preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public ProdutoResponse() {
    }
}
