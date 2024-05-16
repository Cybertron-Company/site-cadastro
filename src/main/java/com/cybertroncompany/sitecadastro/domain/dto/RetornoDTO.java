package com.cybertroncompany.sitecadastro.domain.dto;

import com.cybertroncompany.sitecadastro.domain.Cliente;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RetornoDTO {

    private String mensagem;

    private Cliente cliente;
}
