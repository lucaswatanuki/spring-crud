package vendas.services;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import templates.ProdutosEntityTemplate;
import vendas.model.Entities.ProdutoEntity;
import vendas.model.Responses.ProdutoResponse;
import vendas.repositories.ProdutoRepository;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProdutosServicesTest {

    @Mock
    private ProdutoRepository produtoRepository;

    private ProdutoService produtoService;

    private ProdutoEntity produto;

    private List<ProdutoEntity> produtoEntityList;

    @Before
    public void setup() {
        produtoService = new ProdutoImp(produtoRepository);
        FixtureFactoryLoader.loadTemplates("templates");
    }

    @Test
    public void testFindByIdProdutoSuccess() {
        produto = Fixture.from(ProdutoEntity.class).gimme(ProdutosEntityTemplate.PRODUTO_VALIDO);
        when(produtoRepository.findById(anyInt())).thenReturn(produto);
        ProdutoEntity produtoEntity = produtoService.findById(produto.getId());
        Assertions.assertThat(produtoEntity).isEqualToComparingFieldByField(produto);
    }

    @Test
    public void testAddProdutoSuccess() {
        produto = Fixture.from(ProdutoEntity.class).gimme(ProdutosEntityTemplate.PRODUTO_VALIDO);
        when(produtoRepository.save(any())).thenReturn(produto);
        ProdutoEntity produtoEntity = produtoService.add(produto);
        Assertions.assertThat(produtoEntity).isEqualToComparingFieldByField(produto);
    }

    @Test
    public void testFindAllSuccess() {
        produto = Fixture.from(ProdutoEntity.class).gimme(ProdutosEntityTemplate.PRODUTO_VALIDO);
        produtoEntityList = new ArrayList<>();
        produtoEntityList.add(produto);
        when(produtoRepository.findAll()).thenReturn(produtoEntityList);
        List<ProdutoEntity> produtos = produtoService.listAll();
        Assertions.assertThat(produtos.size() > 0);
    }

    @Test
    public void testDeleteByIdSuccess() {
        produto = Fixture.from(ProdutoEntity.class).gimme(ProdutosEntityTemplate.PRODUTO_VALIDO);
        when(produtoRepository.findById(anyInt())).thenReturn(produto);
        produtoService.deleteByID(produto.getId());
        Assertions.assertThat(produto == null);
    }
}
