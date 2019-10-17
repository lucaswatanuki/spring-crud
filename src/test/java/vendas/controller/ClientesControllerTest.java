package vendas.controller;


import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

import org.springframework.util.AutoPopulatingList;
import templates.ClienteResponseTemplate;
import templates.ClientesEntityTemplate;
import vendas.model.Entities.ClientesEntity;
import vendas.model.Responses.ClientesResponse;
import vendas.services.ClientesService;

import java.util.ArrayList;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class ClientesControllerTest {

    @InjectMocks
    private ClientesController clientesController;

    @Mock
    private ClientesService clientesService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        FixtureFactoryLoader.loadTemplates("templates");
    }

    @Test
    public void testAddClienteSuccess() throws Exception {
        ClientesEntity cliente = Fixture.from(ClientesEntity.class).gimme(ClientesEntityTemplate.CLIENTE_VALIDO);
        when(clientesService.add(cliente)).thenReturn(cliente);
        ClientesEntity clienteResp = clientesController.save(cliente);
        Assert.assertTrue(clienteResp.getId() == cliente.getId());
    }
/*
    @Test
    public void testListAllClienteSuccess() throws Exception {
        ClientesResponse cliente = Fixture.from(ClientesResponse.class).gimme(ClienteResponseTemplate.CLIENTE_RESPONSE_VALIDO);
        List<ClientesResponse> clientesResponseList = new ArrayList<>();
        clientesResponseList.add(cliente);
        when(clientesService.findAll()).thenReturn(clientesResponseList);
        List<ClientesResponse> clientesResponse = clientesController.listAll();
        Assert.assertTrue(clientesResponse.size() > 0);
    }

    @Test
    public void testFindByIdClienteSuccess() {
        ClientesEntity cliente = Fixture.from(ClientesEntity.class).gimme(ClientesEntityTemplate.CLIENTE_VALIDO);
        when(clientesService.findById(anyInt())).thenReturn(cliente);
        ClientesEntity clientesEntity = clientesController.findByID(cliente.getId());
        Assertions.assertThat(clientesEntity).isEqualToComparingFieldByField(cliente);
    }
*/
    @Test
    public void testUpdateClienteSuccess() {
        ClientesEntity cliente = Fixture.from(ClientesEntity.class).gimme(ClientesEntityTemplate.CLIENTE_VALIDO);
        when(clientesService.findById(anyInt())).thenReturn(cliente);
        when(clientesService.add(cliente)).thenReturn(cliente);
        ClientesResponse response = clientesController.update(cliente.getId(), cliente);
        Assertions.assertThat(response).isNull();
    }

    @Test
    public void testDeleteClienteSuccess() {
        ClientesEntity cliente = Fixture.from(ClientesEntity.class).gimme(ClientesEntityTemplate.CLIENTE_VALIDO);
        when(clientesService.findById(cliente.getId())).thenReturn(cliente);
        clientesController.delete(cliente.getId());
        verify(clientesService).deleteByID(cliente.getId());
    }
}
