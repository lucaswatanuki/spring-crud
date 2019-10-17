package vendas.model;



import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import vendas.model.Entities.ClientesEntity;
import vendas.model.Entities.VendasEntity;
import org.assertj.core.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class ClientesEntityTest{

    private ClientesEntity cliente;
    private ArrayList<VendasEntity> vendasListExpected;

    @Before
    public void setUp(){
        cliente = new ClientesEntity();
        vendasListExpected = new ArrayList<>();
        vendasListExpected.add(new VendasEntity(2,"14-10-1996"));
    }

    @Test
    public void testGetterClienteVendaList_Sucesso(){
        List<VendasEntity> vendasListTeste = new ArrayList<>();
        vendasListTeste.add(new VendasEntity(1,"14-10-1996"));
        Assertions.assertThat(vendasListExpected).containsExactlyInAnyOrderElementsOf(vendasListTeste);
    }


    @Test
    public void testGetterClientId_Sucesso(){
        cliente.setId(1);
        Assert.assertTrue(cliente.getId() == 1);
    }

    @Test
    public void testGetterClienteId_Falha(){
        cliente.setId(1);
        Assert.assertFalse(cliente.getId() == 2);
    }

    @Test
    public void testGetterClienteNome_Sucesso(){
        cliente.setNome("lucas");
        Assert.assertTrue(cliente.getNome().equals("lucas"));
    }

    @Test
    public void testGetterClienteNome_Falha(){
        cliente.setNome("lucas");
        Assert.assertFalse(cliente.equals("lukas"));
    }
}