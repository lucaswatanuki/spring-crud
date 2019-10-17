package vendas.services;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import templates.ProdutoVendaEntityTemplate;
import vendas.model.Entities.ProdutoVendaEntity;
import vendas.repositories.ProdutoVendaRepository;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)

public class ProdutoVendaServicesTest {

    @Mock
    private ProdutoVendaRepository produtoVendaRepository;

    private ProdutoVendaService produtoVendaService;

    private ProdutoVendaEntity produtoVenda;

    @Before
    public void setup() {
        produtoVendaService = new ProdutoVendaImp(produtoVendaRepository);
        FixtureFactoryLoader.loadTemplates("templates");
    }

    @Test
    public void testFindByIdProdutoVendaSuccess() {
        ProdutoVendaEntity produtoVenda = Fixture.from(ProdutoVendaEntity.class).gimme(ProdutoVendaEntityTemplate.PRODUTO_VENDA_VALIDO);
        when(produtoVendaRepository.findById(anyInt())).thenReturn(produtoVenda);
        ProdutoVendaEntity produtoVendaEntity = produtoVendaService.findById(produtoVenda.getId());
        Assertions.assertThat(produtoVendaEntity).isEqualToComparingFieldByField(produtoVenda);
    }

    @Test
    public void testAddProdutoVendaSuccess() {
        ProdutoVendaEntity produtoVenda = Fixture.from(ProdutoVendaEntity.class).gimme(ProdutoVendaEntityTemplate.PRODUTO_VENDA_VALIDO);
        when(produtoVendaRepository.save(any())).thenReturn(produtoVenda);
        ProdutoVendaEntity produtoVendaEntity = produtoVendaService.add(produtoVenda);
        Assertions.assertThat(produtoVendaEntity).isEqualToComparingFieldByField(produtoVenda);
    }

    @Test
    public void testFindAllSuccess() {
        ProdutoVendaEntity produtoVenda = Fixture.from(ProdutoVendaEntity.class).gimme(ProdutoVendaEntityTemplate.PRODUTO_VENDA_VALIDO);
        List<ProdutoVendaEntity> produtoVendaList = new ArrayList<>();
        produtoVendaList.add(produtoVenda);
        when(produtoVendaRepository.findAll()).thenReturn(produtoVendaList);
        List<ProdutoVendaEntity> produtoVendaEntities = produtoVendaService.listAll();
        Assertions.assertThat(produtoVendaEntities.size() > 0);
    }

    @Test
    public void testDeleteByIdSuccess() {
        ProdutoVendaEntity produtoVenda = Fixture.from(ProdutoVendaEntity.class).gimme(ProdutoVendaEntityTemplate.PRODUTO_VENDA_VALIDO);
        when(produtoVendaRepository.findById(anyInt())).thenReturn(produtoVenda);
        produtoVendaService.deleteByID(produtoVenda.getId());
        Assertions.assertThat(produtoVenda == null);
    }
}
