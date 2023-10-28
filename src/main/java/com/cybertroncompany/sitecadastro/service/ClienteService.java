package com.cybertroncompany.sitecadastro.service;

import com.cybertroncompany.sitecadastro.model.ClienteModel;
import com.cybertroncompany.sitecadastro.model.dto.ClienteDTO;
import com.cybertroncompany.sitecadastro.model.dto.RetornoDTO;
import com.cybertroncompany.sitecadastro.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public RetornoDTO cadastrar(ClienteDTO clienteDTO) {
       ClienteModel clienteOld = clienteRepository.findByEmail(clienteDTO.getEmail());

       if(clienteOld == null) {
           ClienteModel newCliente = clienteRepository.save(new ClienteModel(clienteDTO));

           return RetornoDTO.builder()
                   .cliente(newCliente)
                   .mensagem("Cadastro realizado com sucesso!")
                   .build();
       }

       return RetornoDTO.builder()
                .mensagem("Cadastro realizado com sucesso!")
                .build();
    }
}
