package templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import vendas.model.Entities.ProdutoEntity;

public class ProdutosEntityTemplate implements TemplateLoader {

    public static final String PRODUTO_VALIDO = "informações produto valido";

    @Override
    public void load() {

        Fixture.of(ProdutoEntity.class).addTemplate(ProdutosEntityTemplate.PRODUTO_VALIDO, new Rule() {
            {
                add("id",1);
                add("nome","mouse");
                add("preco", "10.00");
            }
        });

    }
}
