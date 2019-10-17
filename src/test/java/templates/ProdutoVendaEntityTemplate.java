package templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import vendas.model.Entities.ProdutoVendaEntity;

public class ProdutoVendaEntityTemplate implements TemplateLoader {

    public static final String PRODUTO_VENDA_VALIDO = "informações validas";

    @Override
    public void load() {


        Fixture.of(ProdutoVendaEntity.class).addTemplate(ProdutoVendaEntityTemplate.PRODUTO_VENDA_VALIDO, new Rule() {
            {
                add("id", 1);
                add("quantidade", 1);
                add("valor", 10.00);
            }
        });

    }
}
