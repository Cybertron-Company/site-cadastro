package com.cybertroncompany.sitecadastro.domain;

import com.cybertroncompany.sitecadastro.domain.dto.ClienteDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "celular")
    private String celular;

    public Cliente(ClienteDTO clienteDTO) {
       this.nome = clienteDTO.getNome();
       this.email = clienteDTO.getEmail();
       this.celular = clienteDTO.getCelular();
    }
}
