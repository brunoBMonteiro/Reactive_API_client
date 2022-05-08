package com.client.clientwebflux.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
@Table("client")
public class Client {
    @Id
    private Integer id;
    @NotNull(message = "O nome do cliente não pode ser nulo")
    @NotEmpty(message = "O nome do cliente não pode estar vazio!")
    private String name;
}
