package com.cybertroncompany.sitecadastro.service;

import com.cybertroncompany.sitecadastro.domain.CustomUserDetails;
import com.cybertroncompany.sitecadastro.domain.Perfil;
import com.cybertroncompany.sitecadastro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.cybertroncompany.sitecadastro.domain.UserConnection;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserConnection user = userRepository.findByUser(username);

        return new CustomUserDetails(user.getId(), user.getUser(), user.getPassword(), Perfil.ADMIN);
    }
}

