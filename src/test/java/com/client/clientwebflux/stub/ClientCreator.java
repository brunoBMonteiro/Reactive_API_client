package com.client.clientwebflux.stub;

import com.client.clientwebflux.domain.Client;

public class ClientCreator {
    public static Client createClientToBeSaved(){
        return Client.builder()
                .name("Bruno")
                .build();
    }

    public static Client createValidClient(){
        return Client.builder()
                .id(1L)
                .name("Bruno")
                .build();
    }

    public static Client createValidUpdateClient(){
        return Client.builder()
                .id(1L)
                .name("Bruno Monteiro")
                .build();
    }
}
