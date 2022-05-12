package com.client.clientwebflux.service;

import com.client.clientwebflux.domain.Client;
import com.client.clientwebflux.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public Flux<Client> findAll(){
        return clientRepository.findAll();
    }

    public Mono<Client> findById(int id){
        return clientRepository.findById(id)
                .switchIfEmpty(monoResponseStatusNotFoundException());
    }

    public Mono<Client> save(Client client){
        return clientRepository.save(client);
    }

    public Mono<Void> update(Client client) {
        return findById(Math.toIntExact(client.getId()))
                .map(clientDb -> client.withId(clientDb.getId()))
                .flatMap(clientRepository::save).thenEmpty(Mono.empty());
    }

    public Mono<Void> delete(int id){
        return findById(id).flatMap(clientRepository::delete);
    }


    public <T> Mono<T> monoResponseStatusNotFoundException(){
        return Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
    }
}
