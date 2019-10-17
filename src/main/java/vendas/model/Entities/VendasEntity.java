package vendas.model.Entities;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity(name = "vendas")
@Table(name = "vendas")
@NoArgsConstructor
@Data
public class VendasEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private ClientesEntity clientes;

    @OneToMany(mappedBy = "venda", fetch = FetchType.LAZY)
    private List<ProdutoVendaEntity> itemVenda;

    public VendasEntity(int id, String data) {
        this.id = id;
        this.data = data;
    }
}
