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
import templates.ClientesEntityTemplate;
import vendas.model.Entities.ClientesEntity;
import vendas.model.Responses.ClientesResponse;
import vendas.repositories.ClientesRepository;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class ClientesServicesTest {

    @Mock
    private ClientesRepository clientesRepository;

    private ClientesService clientesService;

    private ClientesEntity clientes;

    @Before
    public void setup() {
        FixtureFactoryLoader.loadTemplates("templates");
        this.clientesService = new ClientesImp(clientesRepository);
    }

    @Test
    public void testFindByIdClienteSuccess() {
        clientes = Fixture.from(ClientesEntity.class).gimme(ClientesEntityTemplate.CLIENTE_VALIDO);
        when(clientesRepository.findById(anyInt())).thenReturn(clientes);
        ClientesEntity clientesEntity = clientesService.findById(clientes.getId());
        Assert.assertSame(clientesEntity.getId(), clientes.getId());
    }

    @Test
    public void testAddClienteSuccess() {
        clientes = Fixture.from(ClientesEntity.class).gimme(ClientesEntityTemplate.CLIENTE_VALIDO);
        when(clientesRepository.save(clientes)).thenReturn(clientes);
        ClientesEntity clientesEntity = clientesService.add(clientes);
        Assertions.assertThat(clientesEntity != null);
    }

    @Test
    public void testFindAllClienteSuccess() {
        clientes = Fixture.from(ClientesEntity.class).gimme(ClientesEntityTemplate.CLIENTE_VALIDO);
        List<ClientesEntity> clientesEntityList = new ArrayList<>();
        clientesEntityList.add(clientes);
        when(clientesRepository.findAll()).thenReturn(clientesEntityList);
        List<ClientesEntity> clientesEntities = clientesService.listAll();
        Assertions.assertThat(clientesEntities.size() > 0);
    }

    @Test
    public void testUpdateClienteSuccess(){
        clientes = Fixture.from(ClientesEntity.class).gimme(ClientesEntityTemplate.CLIENTE_VALIDO);
        when(clientesRepository.findById(anyInt())).thenReturn(clientes);
        when(clientesRepository.save(clientes)).thenReturn(clientes);
        ClientesResponse clientesResponse = clientesService.update(clientes.getId(), clientes);
        Assertions.assertThat(clientesResponse).isEqualToIgnoringGivenFields(clientes, "vendas");
    }

    //bugado
    @Test
    public void testDeleteClienteByIdSuccess() {
        clientes = Fixture.from(ClientesEntity.class).gimme(ClientesEntityTemplate.CLIENTE_VALIDO);
        when(clientesRepository.findById(anyInt())).thenReturn(clientes);
        clientesService.deleteByID(clientes.getId());
        Assertions.assertThat(clientes).isNull();
    }
}
