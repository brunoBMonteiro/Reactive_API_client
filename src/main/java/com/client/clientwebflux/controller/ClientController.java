package com.client.clientwebflux.controller;

import com.client.clientwebflux.domain.Client;
import com.client.clientwebflux.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import com.client.clientwebflux.repository.ClientRepository;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("clients")
public class ClientController {
    private final ClientService clientService;

    @GetMapping
    public Flux<Client> listAll(){
        return clientService.findAll();
    }


}
