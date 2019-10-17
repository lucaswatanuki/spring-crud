package vendas.model.Responses;

import lombok.Data;
import vendas.model.Entities.ProdutoEntity;
import vendas.model.Entities.VendasEntity;

import java.util.List;

@Data
public class ProdutoVendaResponse {
    private int id;
    private int quantidade;
    private double valor;
    private int venda_id;
    private int produto_id;

    public ProdutoVendaResponse() {
    }

    public ProdutoVendaResponse(int id, int quantidade, double valor) {
        this.id = id;
        this.quantidade = quantidade;
        this.valor = valor;
    }
}
