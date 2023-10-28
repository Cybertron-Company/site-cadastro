package com.cybertroncompany.sitecadastro.controller;

import com.cybertroncompany.sitecadastro.model.dto.ClienteDTO;
import com.cybertroncompany.sitecadastro.model.dto.RetornoDTO;
import com.cybertroncompany.sitecadastro.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/cadastra")
public class CadastroController {

    @Autowired
    private ClienteService clienteService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/usuario")
    public ResponseEntity<RetornoDTO> cadastrarUsuario(@RequestBody ClienteDTO clienteDTO) {
        RetornoDTO retorno = clienteService.cadastrar(clienteDTO);
        return ResponseEntity.ok().body(retorno);
    }
}
