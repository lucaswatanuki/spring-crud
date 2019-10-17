package vendas.controller;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import templates.VendasEntityTemplate;
import vendas.model.Entities.VendasEntity;
import vendas.model.Responses.VendasResponse;
import vendas.services.VendasService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class VendasControllerTest {

    @Mock
    private VendasService vendasService;

    @InjectMocks
    private VendasController vendasController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        FixtureFactoryLoader.loadTemplates("templates");
    }

    @Test
    public void testAddVendaSuccess() {
        VendasEntity venda = Fixture.from(VendasEntity.class).gimme(VendasEntityTemplate.VENDA_VALIDA);
        when(vendasService.add(venda)).thenReturn(venda);
        VendasEntity vendasEntity = vendasController.save(venda);
        Assertions.assertThat(vendasEntity).isEqualToComparingFieldByField(venda);
    }

    @Test
    public void testFindAllVendaSuccess() {
        VendasEntity venda = Fixture.from(VendasEntity.class).gimme(VendasEntityTemplate.VENDA_VALIDA);

    }
/*
    @Test
    public void testFindByIdVendaSuccess() {
        VendasEntity venda = Fixture.from(VendasEntity.class).gimme(VendasEntityTemplate.VENDA_VALIDA);
        when(vendasService.findById(anyInt())).thenReturn(venda);
        VendasEntity vendasEntity = vendasController.getID(venda.getId());
        Assertions.assertThat(vendasEntity).isEqualToComparingFieldByField(venda);
    }
*/
/*
    @Test
    public void testUpdateVendaSuccess() {
        VendasEntity venda = Fixture.from(VendasEntityTemplate.class).gimme(VendasEntityTemplate.VENDA_VALIDA);
        VendasResponse vendasResponse = Fixture.from(VendasResponse.class).gimme(VendasRe);
        when(vendasService.update(venda.getId(), venda)).thenReturn(vendasResponse);
        VendasResponse retorno = vendasController.update(venda.getId(), venda);
        Assertions.assertThat(retorno).isNotNull();
    }
*/
    @Test
    public void testDeleteVendaSuccess() {
        VendasEntity venda = Fixture.from(VendasEntity.class).gimme(VendasEntityTemplate.VENDA_VALIDA);
        when(vendasService.findById(venda.getId())).thenReturn(venda);
        vendasController.delete(venda.getId());
        verify(vendasService).deleteByID(venda.getId());
    }
}
