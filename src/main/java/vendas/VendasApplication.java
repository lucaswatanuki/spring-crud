package vendas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import vendas.model.Entities.ClientesEntity;
import vendas.model.Entities.ProdutoEntity;
import vendas.model.Entities.ProdutoVendaEntity;
import vendas.model.Entities.VendasEntity;
import vendas.model.Responses.ClientesResponse;
import vendas.model.Responses.VendasResponse;
/*
@EnableJpaRepositories(basePackages = "vendas.repositories")
@EnableAutoConfiguration
@EntityScan(basePackageClasses = {ClientesEntity.class, VendasEntity.class, ProdutoEntity.class, ProdutoVendaEntity.class} )
@ComponentScan(basePackages = "vendas")*/
@SpringBootApplication
public class VendasApplication {
    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
