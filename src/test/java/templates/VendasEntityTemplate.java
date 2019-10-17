package templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import vendas.model.Entities.ClientesEntity;
import vendas.model.Entities.VendasEntity;

public class VendasEntityTemplate implements TemplateLoader {

    public static final String VENDA_VALIDA = "informacoes validas";
    @Override
    public void load() {
        Fixture.of(VendasEntity.class).addTemplate(VendasEntityTemplate.VENDA_VALIDA, new Rule(){
            {
                add("id", 1);
                add("data", "14-10-96");
            }
        });
    }
}
