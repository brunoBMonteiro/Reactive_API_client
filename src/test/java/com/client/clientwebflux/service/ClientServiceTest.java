package com.client.clientwebflux.service;

import com.client.clientwebflux.domain.Client;
import com.client.clientwebflux.repository.ClientRepository;
import com.client.clientwebflux.stub.ClientCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
class ClientServiceTest {

    @InjectMocks
    private ClientService clientService;

    @Mock
    private ClientRepository clientRepositoryMock;

    private final Client client = ClientCreator.createValidClient();


    @Test
    @DisplayName("FindAll, retorna um flux de clientes")
    void findAllReturnFluxOfClientWhenSuccessful(){
        Mockito.when(clientRepositoryMock.findAll())
                .thenReturn(Flux.just(client));

        StepVerifier.create(clientService.findAll())
                .expectSubscription()
                .expectNext(client)
                .verifyComplete();
    }

    @Test
    @DisplayName("FindAll, retorna um flux de clientes")
    void findAllReturnFluxClientErrorWhenFluxIsEmpty(){
        Mockito.when(clientRepositoryMock.findAll())
                .thenReturn(Flux.empty());

        StepVerifier.create(clientService.findAll())
                .expectSubscription()
                .expectError(ResponseStatusException.class);
    }

    @Test
    @DisplayName("FindById, retorna um mono com cliente quando encontrar id")
    void findByIdReturnMonoClientWhenSuccessful(){
        Mockito.when(clientRepositoryMock.findById(ArgumentMatchers.anyInt()))
                .thenReturn(Mono.just(client));

        StepVerifier.create(clientService.findById(1))
                .expectSubscription()
                .expectNext(client)
                .verifyComplete();
    }

    @Test
    @DisplayName("FindById, retorna um Mono erro quando o cliente não existe")
    void findByIdReturnMonoErrorWhenEmptyMonoIsReturned(){
        Mockito.when(clientRepositoryMock.findById(ArgumentMatchers.anyInt()))
                .thenReturn(Mono.empty());

        StepVerifier.create(clientService.findById(1))
                .expectSubscription()
                .expectError(ResponseStatusException.class)
                .verify();
    }

    @Test
    @DisplayName("Save client, salva client criado quando der sucesso!")
    void saveCreateClientWhenSuccessful(){
        Client clientToBeSaved = ClientCreator.createClientToBeSaved();

        Mockito.when(clientRepositoryMock.save(ClientCreator.createClientToBeSaved()))
                .thenReturn(Mono.just(client));


        StepVerifier.create(clientService.createClient(clientToBeSaved))
                .expectSubscription()
                .expectNext(client)
                .verifyComplete();
    }

}
