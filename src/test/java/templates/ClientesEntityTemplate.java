package templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import vendas.model.Entities.ClientesEntity;
import vendas.model.Entities.VendasEntity;

public class ClientesEntityTemplate implements TemplateLoader {

    public static final String CLIENTE_VALIDO = "informações validas";

    @Override
    public void load() {
        Fixture.of(ClientesEntity.class).addTemplate(ClientesEntityTemplate.CLIENTE_VALIDO, new Rule() {
            {
                add("id", 1);
                add("nome", "lucas");
            }
        });
    }
}
