package templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import vendas.model.Responses.ClientesResponse;

public class ClienteResponseTemplate implements TemplateLoader {

    public static final String CLIENTE_RESPONSE_VALIDO = "Informações validas";

    @Override
    public void load() {
        Fixture.of(ClientesResponse.class).addTemplate(ClienteResponseTemplate.CLIENTE_RESPONSE_VALIDO, new Rule(){
            {
                add("id", 1);
                add("nome", "lucas");
            }
        });
    }
}
