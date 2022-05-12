package com.client.clientwebflux.controller;

import com.client.clientwebflux.domain.Client;
import com.client.clientwebflux.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("clients")
public class ClientController {
    private final ClientService clientService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<Client> listAll(){
        return clientService.findAll();
    }

    @GetMapping(path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Client> findById(@PathVariable int id){
        return clientService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Client> createClient(@Valid @NotNull @RequestBody Client client){
        return clientService.save(client);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<Void>  updateClient(@PathVariable Long id, @RequestBody Client client) {
        return clientService.update(client.withId(id));
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteClient(@PathVariable int id){
        return clientService.delete(id);
    }
}
