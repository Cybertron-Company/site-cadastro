package com.cybertroncompany.sitecadastro.repository;

import com.cybertroncompany.sitecadastro.model.ClienteModel;
import com.cybertroncompany.sitecadastro.model.dto.ClienteDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Integer> {

    ClienteModel findByEmail(String email);
}
