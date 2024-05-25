package com.cybertroncompany.sitecadastro.controller;

import com.cybertroncompany.sitecadastro.domain.dto.ClienteDTO;
import com.cybertroncompany.sitecadastro.domain.dto.RetornoDTO;
import com.cybertroncompany.sitecadastro.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/cadastra")
public class CadastroController {

    @Autowired
    private ClienteService clienteService;

    //@PreAuthorize("hasAnyRole('ADMIN')")
    //@CrossOrigin(origins = "https://cybertron-cadastro.up.railway.app/")
    @PostMapping("/usuario")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<RetornoDTO> cadastrarUsuario(@RequestBody ClienteDTO clienteDTO) {
        RetornoDTO retorno = clienteService.cadastrar(clienteDTO);
        return ResponseEntity.ok().body(retorno);
    }

    @GetMapping("/usuario")
    @CrossOrigin(origins = "http://localhost:3000/")
    public ResponseEntity<String> dados() {
        String retorno = clienteService.generateNewApiKey();
        return ResponseEntity.ok().body(retorno);
    }

    @GetMapping("/teste")
    public ResponseEntity<String> teste() {
        return ResponseEntity.ok().body("Deu Certo!");
    }
}
