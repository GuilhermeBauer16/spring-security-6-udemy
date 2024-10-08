//package com.debugandoides.app_security.security;
//
//import com.debugandoides.app_security.model.CustomerEntity;
//import com.debugandoides.app_security.repositories.CustomerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class MyAuthenticationProvider implements AuthenticationProvider {
//
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        final String username = authentication.getName();
//        final String password = authentication.getCredentials().toString();
//        final CustomerEntity customerFromDb = this.customerRepository.findByEmail(username)
//                .orElseThrow(() -> new BadCredentialsException("Customer not found"));
//
//        if (!passwordEncoder.matches(password, customerFromDb.getPassword())) {
//            throw new BadCredentialsException("Wrong password");
//        }
//        var authorities = customerFromDb.getRoles().stream();
//        return new UsernamePasswordAuthenticationToken(username, password, authorities);
//
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
//    }
//}
