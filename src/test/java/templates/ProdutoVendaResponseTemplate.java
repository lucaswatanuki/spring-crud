package templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import vendas.model.Entities.ProdutoVendaEntity;
import vendas.model.Responses.ProdutoVendaResponse;

public class ProdutoVendaResponseTemplate implements TemplateLoader {

    public static final String ITEM_VALIDO = "info validas";

    @Override
    public void load() {
        Fixture.of(ProdutoVendaResponse.class).addTemplate(ProdutoVendaResponseTemplate.ITEM_VALIDO, new Rule(){
            {
                add("id", 1);
                add("quantidade", 10);
                add("valor", 100.00);
            }
        });
    }
}
