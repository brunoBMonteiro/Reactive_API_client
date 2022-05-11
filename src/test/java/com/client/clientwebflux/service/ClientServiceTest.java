package com.client.clientwebflux.service;

import com.client.clientwebflux.domain.Client;
import com.client.clientwebflux.repository.ClientRepository;
import com.client.clientwebflux.stub.ClientCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
public class ClientServiceTest {

    @InjectMocks
    private ClientService clientService;

    @Mock
    private ClientRepository clientRepositoryMock;

    private final Client client = ClientCreator.createValidClient();

    @BeforeEach
    public void setUp(){
        Mockito.when(clientRepositoryMock.findAll())
                .thenReturn(Flux.just(client));
    }

    @Test
    @DisplayName("FindAll retorna um flux de clientes")
    public void findAllReturnFluxOfClientWhenSuccessful(){
        StepVerifier.create(clientService.findAll())
                .expectSubscription()
                .expectNext(client)
                .verifyComplete();
    }
}
