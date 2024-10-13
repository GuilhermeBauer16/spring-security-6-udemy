//package com.debugandoides.app_security.services;
//
//import com.debugandoides.app_security.repositories.CustomerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class JwtDetailService implements UserDetailsService {
//
//    private CustomerRepository customerRepository;
//
//    @Autowired
//    public JwtDetailService(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return this.customerRepository.findByEmail(username).map(customer ->
//        {
//
//            List<SimpleGrantedAuthority> authorities = customer.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())
//            ).toList();
//
//            return new User(customer.getEmail(), customer.getPassword(), authorities);
//        }).orElseThrow(() -> new UsernameNotFoundException("User not found"));
//    }
//}
