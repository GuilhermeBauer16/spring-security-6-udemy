package com.debugandoides.app_security.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

public class ApiKeyFilter extends OncePerRequestFilter {

    private static final String API_KEY_HEADER = "api_key";
    private static final String API_KEY = "myKey";
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try{

            final String apiKeyOpt = Optional.of(request.getHeader(API_KEY_HEADER))
                    .orElseThrow(() -> new BadCredentialsException("No header API key"));

            if(!apiKeyOpt.equals(API_KEY)){

               throw new BadCredentialsException("invalid API key");
            }

        } catch (Exception e) {
            throw new BadCredentialsException("invalid API key" + e);
        }

        filterChain.doFilter(request, response);
    }
}
