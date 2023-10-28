package com.cybertroncompany.sitecadastro.model;

import com.cybertroncompany.sitecadastro.model.dto.ClienteDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "cliente")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "celular")
    private String celular;

    public ClienteModel(ClienteDTO clienteDTO) {
       this.nome = clienteDTO.getNome();
       this.email = clienteDTO.getEmail();
       this.celular = clienteDTO.getCelular();
    }
}
