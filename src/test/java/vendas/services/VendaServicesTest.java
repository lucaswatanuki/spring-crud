package vendas.services;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import templates.VendasEntityTemplate;
import vendas.model.Entities.VendasEntity;
import vendas.repositories.VendasRepository;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class VendaServicesTest {

    @Mock
    private VendasRepository vendasRepository;

    private VendasService vendasService;

    private VendasEntity venda;

    private List<VendasEntity> vendasEntityList;

    @Before
    public void setup() {
        vendasService = new VendaImp(vendasRepository);
        FixtureFactoryLoader.loadTemplates("templates");
     }

    @Test
    public void testFindByIdVenda() {
        VendasEntity venda = Fixture.from(VendasEntity.class).gimme(VendasEntityTemplate.VENDA_VALIDA);
        when(vendasRepository.findById(anyInt())).thenReturn(venda);
        VendasEntity vendasEntity = vendasService.findById(venda.getId());
        Assertions.assertThat(vendasEntity).isEqualToComparingFieldByField(venda);
    }

    @Test
    public void testAddVenda() {
        VendasEntity venda = Fixture.from(VendasEntity.class).gimme(VendasEntityTemplate.VENDA_VALIDA);
        when(vendasRepository.save(any())).thenReturn(venda);
        VendasEntity vendasEntity = vendasService.add(venda);
        Assertions.assertThat(vendasEntity).isEqualToComparingFieldByField(venda);
    }

    @Test
    public void testFindAll() {
        VendasEntity venda = Fixture.from(VendasEntity.class).gimme(VendasEntityTemplate.VENDA_VALIDA);
        List<VendasEntity> vendasEntityList = new ArrayList<>();
        vendasEntityList.add(venda);
        when(vendasRepository.findAll()).thenReturn(vendasEntityList);
        List<VendasEntity> vendasEntities = vendasService.listAll();
        Assertions.assertThat(vendasEntities.size() > 0);
    }

    @Test
    public void testDeleteById() {
        VendasEntity venda = Fixture.from(VendasEntity.class).gimme(VendasEntityTemplate.VENDA_VALIDA);
        when(vendasRepository.findById(anyInt())).thenReturn(venda);
        vendasService.deleteByID(venda.getId());
        Assertions.assertThat(venda == null);
    }
}
