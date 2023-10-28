package com.cybertroncompany.sitecadastro.model.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {

    private String nome;
    private String email;
    private String celular;
}
