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
import templates.ProdutoVendaEntityTemplate;
import templates.ProdutoVendaResponseTemplate;
import vendas.model.Entities.ProdutoVendaEntity;
import vendas.model.Responses.ProdutoVendaResponse;
import vendas.services.ProdutoVendaService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProdutoVendaControllerTest {

    @Mock
    private ProdutoVendaService produtoVendaService;

    @InjectMocks
    private ProdutoVendaController produtoVendaController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        FixtureFactoryLoader.loadTemplates("templates");
    }

    @Test
    public void testAddProdutoSuccess() {
        ProdutoVendaEntity produtovenda = Fixture.from(ProdutoVendaEntity.class).gimme(ProdutoVendaEntityTemplate.PRODUTO_VENDA_VALIDO);
        when(produtoVendaService.add(produtovenda)).thenReturn(produtovenda);
        ProdutoVendaEntity produtoVendaEntity = produtoVendaController.save(produtovenda);
        Assertions.assertThat(produtoVendaEntity).isEqualToComparingFieldByField(produtovenda);
    }
/*
    @Test
    public void testFindAllProdutoSuccess() {
        ProdutoVendaResponse produtoVendaResponse = Fixture.from(ProdutoVendaResponse.class).gimme(ProdutoVendaResponseTemplate.ITEM_VALIDO);
        List<ProdutoVendaResponse> items = new ArrayList<>();
        items.add(produtoVendaResponse);
        when(produtoVendaService.findAll()).thenReturn(items);
        List<ProdutoVendaResponse> itemResponses = produtoVendaController.listAll();
        Assertions.assertThat(itemResponses).containsExactlyInAnyOrderElementsOf(items);
    }

    @Test
    public void testFindByIdProdutoSuccess() {
        ProdutoVendaEntity produtoVenda = Fixture.from(ProdutoVendaEntity.class).gimme(ProdutoVendaEntityTemplate.PRODUTO_VENDA_VALIDO);
        when(produtoVendaService.findById(anyInt())).thenReturn(produtoVenda);
        ProdutoVendaEntity produtoVendaEntity = produtoVendaController.getID(produtoVenda.getId());
        Assertions.assertThat(produtoVendaEntity).isEqualToComparingFieldByField(produtoVenda);
    }
*/

    @Test
    public void testUpdateProdutoSuccess() {
        ProdutoVendaEntity produtoVenda = Fixture.from(ProdutoVendaEntity.class).gimme(ProdutoVendaEntityTemplate.PRODUTO_VENDA_VALIDO);
        ProdutoVendaResponse produtoVendaResponse = Fixture.from(ProdutoVendaResponse.class).gimme(ProdutoVendaResponseTemplate.ITEM_VALIDO);
        when(produtoVendaService.update(produtoVenda.getId(), produtoVenda)).thenReturn(produtoVendaResponse);
        ProdutoVendaResponse retorno = produtoVendaController.update(produtoVenda.getId(), produtoVenda);
        Assertions.assertThat(retorno).isNotNull();
    }

    @Test
    public void testDeleteProdutoSuccess() {
        ProdutoVendaEntity produtoVenda = Fixture.from(ProdutoVendaEntity.class).gimme(ProdutoVendaEntityTemplate.PRODUTO_VENDA_VALIDO);
        when(produtoVendaService.findById(produtoVenda.getId())).thenReturn(produtoVenda);
        produtoVendaController.delete(produtoVenda.getId());
        verify(produtoVendaService).deleteByID(produtoVenda.getId());
    }

}
