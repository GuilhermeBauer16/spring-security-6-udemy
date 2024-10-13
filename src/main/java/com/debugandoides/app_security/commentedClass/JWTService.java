//package com.debugandoides.app_security.services;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//import javax.crypto.SecretKey;
//import java.nio.charset.StandardCharsets;
//import java.util.Collections;
//import java.util.Date;
//import java.util.Map;
//import java.util.function.Function;
//
//@Service
//public class JWTService {
//
//    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
//    public static final String JWT_SECRET = "jxgEQe.XHuPq8VdbyYFNkAN.dudQ0903YUn4";
//
//    private Claims getAllClaimsFromToken(String token) {
//        final SecretKey secretKey = Keys.hmacShaKeyFor(JWT_SECRET.getBytes(StandardCharsets.UTF_8));
//        return Jwts.parser()
//                .verifyWith(secretKey)
//                .build()
//                .parseSignedClaims(token).getPayload();
//    }
//
//    public <T> T getClaimsFromToken(String token, Function<Claims,T> claimsResolver) {
//        final Claims claims = this.getAllClaimsFromToken(token);
//        return claimsResolver.apply(claims);
//    }
//
//    private Date getExpirationDateFromToken(String token) {
//        return this.getClaimsFromToken(token, Claims::getExpiration);
//    }
//
//    private Boolean isTokenExpired(String token) {
//        final Date expiration = this.getExpirationDateFromToken(token);
//        return expiration.before(new Date());
//    }
//
//    public String getUsernameFromToken(String token){
//        return this.getClaimsFromToken(token, Claims::getSubject);
//    }
//
//    public String generateToken(UserDetails userDetails) {
//        final Map<String, Object> claims = Collections.singletonMap("ROLES", userDetails.getAuthorities().toString());
//        return this.getToken(claims,userDetails.getUsername());
//
//    }
//
//    private String getToken(Map<String,Object> claims, String subject ) {
//        final SecretKey secretKey = Keys.hmacShaKeyFor(JWT_SECRET.getBytes(StandardCharsets.UTF_8));
//
//        return Jwts.builder()
//                .claims(claims)
//                .subject(subject)
//                .issuedAt(new Date(System.currentTimeMillis()))
//                .expiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 100))
//                .signWith(secretKey)
//                .compact();
//
//
//
//    }
//
//    public Boolean validateToken(String token, UserDetails userDetails) {
//        final String usernameFromUserDetails = userDetails.getUsername();
//        final String usernameFromJWT = this.getUsernameFromToken(token);
//
//        return (usernameFromJWT.equals(usernameFromUserDetails) && !this.isTokenExpired(token));
//
//    }
//}
