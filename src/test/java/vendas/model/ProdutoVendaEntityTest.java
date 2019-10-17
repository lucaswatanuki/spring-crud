package vendas.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import vendas.model.Entities.ProdutoEntity;
import vendas.model.Entities.ProdutoVendaEntity;
import vendas.model.Entities.VendasEntity;

import javax.persistence.*;
import java.io.Serializable;

public class ProdutoVendaEntityTest {

    private ProdutoVendaEntity item;
    private VendasEntity vendaExpected;
    private ProdutoEntity produtoExpected;

    @Before
    public void init() {
        item = new ProdutoVendaEntity();
        produtoExpected = new ProdutoEntity(1, "mouse", "50.00");
        vendaExpected = new VendasEntity(1, "14-10-96");
    }

    @Test
    public void testGetterProdutoVendaId_Success() {
        item.setId(1);
        Assert.assertTrue(item.getId() == 1);
    }

    @Test
    public void testGetterProdutoVendaId_Fail() {
        item.setId(1);
        Assert.assertFalse(item.getId() == 2);
    }

    @Test
    public void testGetterProdutoVendaQuantidade_Success() {
        item.setQuantidade(1);
        Assert.assertTrue(item.getQuantidade() == 1);
    }

    @Test
    public void testGetterProdutoVendaQuantidade_Fail() {
        item.setQuantidade(1);
        Assert.assertFalse(item.getQuantidade() == 2);
    }

    @Test
    public void testGetterProdutoVendaValor_Success() {
        item.setValor(10.50);
        Assert.assertTrue(item.getValor() == 10.50);
    }

    @Test
    public void testGetterProdutoVendaValor_Fail() {
        item.setValor(10.50);
        Assert.assertFalse(item.getValor() == 1);
    }

    @Test
    public void testGetterProdutoVendaGetVendaID_Success() {
        item.setVenda(new VendasEntity(1, "14-10-96"));
        Assert.assertTrue(item.getVenda().getId() == vendaExpected.getId()
                && item.getVenda().getData().equals(vendaExpected.getData()));
    }

    @Test
    public void testGetterProdutoVendaGetVendaID_Fail() {
        item.setVenda(new VendasEntity(2, "11-10-96"));
        Assert.assertTrue(item.getVenda().getId() != vendaExpected.getId()
                && !item.getVenda().getData().equals(vendaExpected.getData()));
    }

    @Test
    public void testGetterProdutoVendaProduto_Success() {
        item.setProduto(new ProdutoEntity(1, "mouse", "50.00"));
        Assert.assertTrue(item.getProduto().getId() == produtoExpected.getId()
                && item.getProduto().getNome().equals(produtoExpected.getNome())
                && item.getProduto().getPreco().equals(produtoExpected.getPreco()));
    }

    @Test
    public void testGetterProdutoVendaProduto_Fail() {
        item.setProduto(new ProdutoEntity(2, "teclado", "100.00"));
        Assert.assertTrue(item.getProduto().getId() != produtoExpected.getId()
                && !item.getProduto().getNome().equals(produtoExpected.getNome())
                && !item.getProduto().getPreco().equals(produtoExpected.getPreco()));
    }
}
