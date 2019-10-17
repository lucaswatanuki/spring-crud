package vendas.model.Entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "produtos")
@Table(name = "produtos")
@NoArgsConstructor
@Data
public class ProdutoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String preco;

    public ProdutoEntity(int id, String nome, String preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }
}
