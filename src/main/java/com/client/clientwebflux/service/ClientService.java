package com.client.clientwebflux.service;

import com.client.clientwebflux.domain.Client;
import com.client.clientwebflux.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public Flux<Client> findAll(){
        return clientRepository.findAll();
    }
}
