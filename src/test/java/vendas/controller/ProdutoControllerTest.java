package vendas.controller;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import jdk.internal.dynalink.linker.LinkerServices;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import templates.ProdutosEntityTemplate;
import vendas.model.Entities.ProdutoEntity;
import vendas.model.Responses.ProdutoResponse;
import vendas.services.ProdutoService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProdutoControllerTest {

    @Mock
    private ProdutoService produtoService;

    @InjectMocks
    private ProdutoController produtoController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        FixtureFactoryLoader.loadTemplates("templates");
    }

    @Test
    public void testAddProdutoSuccess() {
        ProdutoEntity produto = Fixture.from(ProdutoEntity.class).gimme(ProdutosEntityTemplate.PRODUTO_VALIDO);
        when(produtoService.add(produto)).thenReturn(produto);
        ProdutoEntity produtoEntity = produtoController.save(produto);
        Assertions.assertThat(produtoEntity).isEqualToComparingFieldByField(produto);
    }
/*
    @Test
    public void testFindAllProdutoSuccess() {
        ProdutoEntity produto = Fixture.from(ProdutoEntity.class).gimme(ProdutosEntityTemplate.PRODUTO_VALIDO);
        List<ProdutoEntity> produtoList = new ArrayList<>();
        produtoList.add(produto);
        when(produtoService.findAll()).thenReturn(produtoList);
        List<ProdutoEntity> produtoEntities = produtoController.listAll();
        Assertions.assertThat(produtoEntities).containsExactlyInAnyOrderElementsOf(produtoList);
    }

    @Test
    public void testFindByIdProdutoSuccess() {
        ProdutoEntity produto = Fixture.from(ProdutoEntity.class).gimme(ProdutosEntityTemplate.PRODUTO_VALIDO);
        when(produtoService.findById(anyInt())).thenReturn(produto);
        ProdutoEntity produtoEntity = produtoController.getID(produto.getId());
        Assertions.assertThat(produtoEntity).isEqualToComparingFieldByField(produto);
    }

    @Test
    public void testFindByNameProdutoSuccess() {
        ProdutoEntity produto = Fixture.from(ProdutoEntity.class).gimme(ProdutosEntityTemplate.PRODUTO_VALIDO);
        when(produtoService.findByNome(anyString())).thenReturn(produto);
        ProdutoEntity produtoEntity = produtoController.getNome(produto.getNome());
        Assertions.assertThat(produtoEntity).isEqualToComparingFieldByField(produto);
    }
*/
    @Test
    public void testUpdateProdutoSuccess() {
        ProdutoEntity produto = Fixture.from(ProdutoEntity.class).gimme(ProdutosEntityTemplate.PRODUTO_VALIDO);
        ProdutoResponse produtoResponse = new ProdutoResponse(1, "mouse", "10.00");
        when(produtoService.update(anyInt(), any())).thenReturn(produtoResponse);
        ProdutoResponse produtoResponseReturn = produtoController.update(produto.getId(), produto);
        Assertions.assertThat(produtoResponseReturn).isEqualToComparingFieldByField(produto);
    }

    @Test
    public void testDeleteProdutoSuccess() {
        ProdutoEntity produto = Fixture.from(ProdutoEntity.class).gimme(ProdutosEntityTemplate.PRODUTO_VALIDO);
        when(produtoService.findById(produto.getId())).thenReturn(produto);
        produtoController.delete(produto.getId());
        verify(produtoService).deleteByID(produto.getId());
    }

}
