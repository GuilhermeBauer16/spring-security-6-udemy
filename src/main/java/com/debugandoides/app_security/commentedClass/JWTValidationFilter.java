//package com.debugandoides.app_security.security;
//
//import com.debugandoides.app_security.services.JWTService;
//import com.debugandoides.app_security.services.JwtDetailService;
//import io.jsonwebtoken.ExpiredJwtException;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//import java.util.Objects;
//
//@Component
//public class JWTValidationFilter extends OncePerRequestFilter {
//
//
//    private final JWTService jwtService;
//    private final JwtDetailService jwtDetailService;
//
//    public static final String AUTHORIZATION_HEADER = "Authorization";
//    public static final String AUTHORIZATION_HEADER_BEARER = "Bearer ";
//
//    @Autowired
//    public JWTValidationFilter(JWTService jwtService, JwtDetailService jwtDetailService) {
//        this.jwtService = jwtService;
//        this.jwtDetailService = jwtDetailService;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//
//        final String header = request.getHeader(AUTHORIZATION_HEADER);
//        String username = null;
//        String jwt = null;
//
//        if (Objects.nonNull(header) && header.startsWith(AUTHORIZATION_HEADER_BEARER)) {
//            jwt = header.substring(AUTHORIZATION_HEADER_BEARER.length());
//            try {
//                username = jwtService.getUsernameFromToken(jwt);
//
//            } catch (IllegalArgumentException e) {
//                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid JWT token");
//                return; // Do not proceed further
//            } catch (ExpiredJwtException e) {
//                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Expired JWT token");
//                return; // Do not proceed further
//            }
//        }
//
//        if (Objects.nonNull(username) && Objects.isNull(SecurityContextHolder.getContext().getAuthentication())) {
//
//            final UserDetails userDetails = jwtDetailService.loadUserByUsername(username);
//
//            if (Boolean.TRUE.equals(this.jwtService.validateToken(jwt, userDetails))) {
//                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
//                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//
//                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//            }
//        }
//
//        filterChain.doFilter(request, response);
//    }
//
//}
