package com.client.clientwebflux.repository;

import com.client.clientwebflux.domain.Client;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;


public interface ClientRepository extends ReactiveCrudRepository<Client, Integer> {
}
