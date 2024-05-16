package com.cybertroncompany.sitecadastro.service;

import com.cybertroncompany.sitecadastro.domain.Cliente;
import com.cybertroncompany.sitecadastro.domain.dto.ClienteDTO;
import com.cybertroncompany.sitecadastro.domain.dto.RetornoDTO;
import com.cybertroncompany.sitecadastro.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public RetornoDTO cadastrar(ClienteDTO clienteDTO) {
       Cliente clienteOld = clienteRepository.findByEmail(clienteDTO.getEmail());

       if(clienteOld == null) {
           Cliente newCliente = clienteRepository.save(new Cliente(clienteDTO));

           return RetornoDTO.builder()
                   .cliente(newCliente)
                   .mensagem("Cadastro realizado com sucesso!")
                   .build();
       }

       return RetornoDTO.builder()
                .mensagem("Cadastro realizado com sucesso!")
                .build();
    }

    public String generateNewApiKey() {
        String s = UUID.randomUUID().toString();

        Cliente cliente = clienteRepository.findByNome("lucas");
        cliente.setEmail(s);
        clienteRepository.save(cliente);

        return cliente.getEmail();
    }
}
