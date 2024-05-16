package com.cybertroncompany.sitecadastro.repository;

import com.cybertroncompany.sitecadastro.domain.UserConnection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserConnection, Integer> {

    public UserConnection findByUser(String user);
}
