package vendas.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import vendas.model.Entities.ProdutoEntity;

import javax.persistence.*;
import java.io.Serializable;

public class ProdutoEntityTest{

    private ProdutoEntity produto;

    @Before
    public void setUp(){
        produto = new ProdutoEntity();
    }

       @Test
    public void testGetterProdutoId_Sucesso(){
        produto.setId(1);
        Assert.assertTrue(produto.getId() == 1);
    }

    @Test
    public void testGetterProdutoId_Falha(){
        produto.setId(1);
        Assert.assertFalse(produto.getId() == 2);
    }

    @Test
    public void testGetterProdutoNome_Sucesso(){
        produto.setNome("mouse");
        Assert.assertTrue(produto.getNome().equals("mouse"));
    }

    @Test
    public void testGetterProdutoNome_Falha(){
        produto.setNome("mouse");
        Assert.assertFalse(produto.equals("mmouse"));
    }

    @Test
    public void testGetterProdutoPreco_Sucesso(){
        produto.setNome("10.50");
        Assert.assertFalse(produto.equals("10.50"));
    }

    @Test
    public void testGetterProdutoPreco_Fail(){
        produto.setNome("10.50");
        Assert.assertFalse(produto.equals("10.00"));
    }



}
