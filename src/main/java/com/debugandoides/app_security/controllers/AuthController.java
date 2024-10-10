package com.debugandoides.app_security.controllers;

import com.debugandoides.app_security.request.JWTRequest;
import com.debugandoides.app_security.response.JWTResponse;
import com.debugandoides.app_security.services.JWTService;
import com.debugandoides.app_security.services.JwtDetailService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authenticate")
public class AuthController {

    private final  AuthenticationManager authenticationManager;
    private final JwtDetailService service;
    private final JWTService jwtService;

    public AuthController(AuthenticationManager authenticationManager, JwtDetailService service, JWTService jwtService) {
        this.authenticationManager = authenticationManager;
        this.service = service;
        this.jwtService = jwtService;
    }


    @PostMapping
    public ResponseEntity<?> postToken(@RequestBody JWTRequest request) {
        this.authenticate(request);
        UserDetails userDetails = this.service.loadUserByUsername(request.getUsername());
        final String token = jwtService.generateToken(userDetails);
        return ResponseEntity.ok(new JWTResponse(token));
    }


    private void authenticate(JWTRequest request) {
        try{

            this.authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));


        }catch (BadCredentialsException | DisabledException e) {
            throw new BadCredentialsException(e.getMessage());
        }
    }



}
