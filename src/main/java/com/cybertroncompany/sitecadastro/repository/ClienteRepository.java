package com.cybertroncompany.sitecadastro.repository;

import com.cybertroncompany.sitecadastro.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Cliente findByEmail(String email);
    Cliente findByNome(String cliente);
}
