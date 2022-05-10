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
@Table("clients")
public class Client {
    @Id
    private Long id;
    @NotNull(message = "O nome do cliente não pode ser nulo")
    @NotEmpty(message = "O nome do cliente não pode estar vazio!")
    private String name;
}
