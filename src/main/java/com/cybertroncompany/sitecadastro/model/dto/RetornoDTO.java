package com.cybertroncompany.sitecadastro.model.dto;

import com.cybertroncompany.sitecadastro.model.ClienteModel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RetornoDTO {

    private String mensagem;

    private ClienteModel cliente;
}
