package vendas.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import vendas.model.Entities.ClientesEntity;
import vendas.model.Entities.ProdutoEntity;
import vendas.model.Entities.VendasEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class VendasEntityTest {

    private VendasEntity vendaExpected;
    private List<ProdutoEntity> produtosExpected;
    private List<ClientesEntity> clientesExpected;

    @Before
    public void init() {
        vendaExpected = new VendasEntity(1, "14-10-1996");
        produtosExpected = new ArrayList<>();
        produtosExpected.add(new ProdutoEntity(1, "mouse", "10.00"));
        clientesExpected = new ArrayList<>();
        clientesExpected.add(new ClientesEntity(1, "lucas"));
    }

    @Test
    public void testGetterVendaId_Sucesso() {
        int testeID = 1;
        Assert.assertTrue(vendaExpected.getId() == testeID);
    }


    @Test
    public void testGetterVendaId_Fail() {
        int testeID = 2;
        Assert.assertFalse(vendaExpected.getId() == 2);
    }

    @Test
    public void testGetterVendaData_Success() {
        String dataTeste = "14-10-1996";
        Assert.assertTrue(vendaExpected.getData().equals(dataTeste));
    }

    @Test
    public void testGetterVendaData_Fail() {
        String dataTeste = "13-10-96";
        Assert.assertFalse(vendaExpected.getData().equals(dataTeste));
    }

    @Test
    public void testGetterVendaClientes_Success() {
        List<ClientesEntity> clientesTeste = new ArrayList<>();
        clientesTeste.add(new ClientesEntity(1, "lucas"));
        clientesTeste.forEach(vendasEntity -> {
            int i = 0;
            Assert.assertEquals(clientesTeste.get(i).getId(), clientesExpected.get(i).getId());
            Assert.assertEquals(clientesTeste.get(i).getNome(), clientesExpected.get(i).getNome());
            i++;
        });
    }

    @Test
    public void testGetterVendaClientes_Fail() {
        List<ClientesEntity> clientesTeste = new ArrayList<>();
        clientesTeste.add(new ClientesEntity(2, "lukas"));
        clientesTeste.forEach(vendasEntity -> {
            int i = 0;
            Assert.assertNotEquals(clientesTeste.get(i).getId(), clientesExpected.get(i).getId());
            Assert.assertNotEquals(clientesTeste.get(i).getNome(), clientesExpected.get(i).getNome());
            i++;
        });
    }

    @Test
    public void testGetterVendaProdutos_Success() {
        List<ProdutoEntity> produtosTeste = new ArrayList<>();
        produtosTeste.add(new ProdutoEntity(1, "mouse", "10.00"));
        produtosTeste.forEach(produtoEntity -> {
            int i = 0;
            Assert.assertEquals(produtosTeste.get(i).getId(), produtosExpected.get(i).getId());
            Assert.assertEquals(produtosTeste.get(i).getNome(), produtosExpected.get(i).getNome());
            i++;
        });
    }

    @Test
    public void testGetterVendaProdutos_Fail() {
        List<ProdutoEntity> produtosTeste = new ArrayList<>();
        produtosTeste.add(new ProdutoEntity(2, "teclado", "50"));
        produtosTeste.forEach(produtoEntity -> {
            int i = 0;
            Assert.assertNotEquals(produtosTeste.get(i).getId(), produtosExpected.get(i).getId());
            Assert.assertNotEquals(produtosTeste.get(i).getNome(), produtosExpected.get(i).getNome());
            i++;
        });
    }
}
