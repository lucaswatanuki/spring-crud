package vendas.model.Entities;



import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vendas.model.Entities.VendasEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity(name = "clientes")
@Table(name = "clientes")
@NoArgsConstructor
@Data
public class ClientesEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    @OneToMany(mappedBy = "clientes", fetch = FetchType.LAZY)
    private List<VendasEntity> vendas_id;

    public ClientesEntity(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}