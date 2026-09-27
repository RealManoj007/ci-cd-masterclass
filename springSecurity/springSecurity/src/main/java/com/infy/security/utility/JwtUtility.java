package com.infy.security.utility;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

import static io.jsonwebtoken.Jwts.parser;

@Component
public class JwtUtility {

    private final String SecretKey = "mysecretkeymysecretkeymysecretkeymysecretkey";
    private final SecretKey key  = Keys.hmacShaKeyFor(SecretKey.getBytes());
    private final long EXPIRATION_TIME = 1000*60*60; // 1 hour


    public String generateToken(String username){
        return  Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRATION_TIME)) // 1 hour
                .signWith(key,SignatureAlgorithm.HS256) // use a strong key
                .compact();
    }

    //Claims allow the application to verify identity and trust the token without needing to query a database every time.
//Here we are parsing token based on secretKey with its algorithm
    private Claims extractClaims(String token){
        Claims body = Jwts.parser()
                .setSigningKey(key) //need to validate token based on this key
                .build()
                .parseClaimsJws(token)//parse token
                .getBody();//parse all claims
        System.out.println("Claims Body: " + body);
        return body;
    }

    public String extractUsername(String token){
        return  extractClaims(token).getSubject();  //parse username
    }

    private boolean isTokenExpired(String token){
        Date expiration = extractClaims(token).getExpiration();
        System.out.println("Token Expiration Date: " + expiration+" and current time is "+new Date());
        return extractClaims(token).getExpiration().before(new Date());
    }

    public boolean validateToken(String username, UserDetails userDetails, String token) {
        //TODO: check if username is same as userDetails and Check Token is not expired
        boolean usernameStatus = username.equals(userDetails.getUsername());
        boolean tokenExpired = isTokenExpired(token);
        System.out.println("Username Status: " + usernameStatus + ", Token Expired: " + tokenExpired);
        return (usernameStatus && !tokenExpired);
    }
}
