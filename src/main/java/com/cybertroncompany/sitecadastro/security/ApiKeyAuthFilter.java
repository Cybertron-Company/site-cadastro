package com.cybertroncompany.sitecadastro.security;

import com.cybertroncompany.sitecadastro.domain.Cliente;
import com.cybertroncompany.sitecadastro.domain.UserConnection;
import com.cybertroncompany.sitecadastro.repository.ClienteRepository;
import com.cybertroncompany.sitecadastro.repository.UserRepository;
import com.cybertroncompany.sitecadastro.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class ApiKeyAuthFilter extends OncePerRequestFilter {

    private String apiKey;
    private String origin;
    private String type;

    private ClienteRepository clienteRepository;
    private ClienteService clienteService;

    public ApiKeyAuthFilter(String apiKey, String origin, String type) {
        this.apiKey = apiKey;
        this.origin = origin;
        this.type = type;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        ServletContext servletContext = request.getServletContext();
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        clienteRepository = webApplicationContext.getBean(ClienteRepository.class);
        clienteService = webApplicationContext.getBean(ClienteService.class);


        String requestApiKey = request.getHeader("API-Key");
        String requestOrigin = request.getHeader("Origin");
        String requestType = request.getHeader("api-type");
        this.apiKey = clienteRepository.findByNome("lucas").getEmail();
        if(requestType.equals(type) && origin.equals(requestOrigin)) {
            filterChain.doFilter(request, response);
        } else if (apiKey.equals(requestApiKey) && origin.equals(requestOrigin)) {
            filterChain.doFilter(request, response);
            clienteService.generateNewApiKey();
        } else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write("Acesso Negado: API Key inválida");
        }
    }


}
